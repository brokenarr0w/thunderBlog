package com.example.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.entity.Blog;
import com.example.entity.BlogTags;
import com.example.entity.SystemStats;
import com.example.mapper.BlogMapper;
import com.example.service.*;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@RestController
@CrossOrigin("*")
public class BlogController {
    @Resource
    IBlogService service;
    @Resource
    BlogMapper mapper;
    @Resource
    IBlogTagService tagService;
    @Resource
    ICategoryService categoryService;
    @Resource
    ITagService iTagService;
    @Resource
    ISystemStatsService statsService;

    @GetMapping("/get/blogs")
    public String getBlogList() {
        List<Blog> list = mapper.selectAllBlogs();
        JSONArray array = JSONUtil.parseArray(list).setDateFormat("yyyy-MM-dd");
        return JSONUtil.parse(RestBean.success(array)).toStringPretty();
    }

    @DeleteMapping("/delete/blog")
    public String deleteBlogById(@RequestParam int id) {
        try {
            Blog blog = service.getById(id);
            Long view = blog.getViews();

            SystemStats stats = statsService.getOne(null);
            stats.setBlogViews(Math.toIntExact(stats.getBlogViews() - view));
            statsService.saveOrUpdate(stats);
            service.removeById(id);

            return JSONUtil.parse(RestBean.success()).toStringPretty();
        } catch (Exception e) {
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }

    @PostMapping("/post/blog")
    public String insertBlog(@RequestBody String blog) {
        Blog object = JSONUtil.toBean(blog, Blog.class);
        try {
            service.saveOrUpdate(object);
            tagService.remove(tagService.query().eq("blog_id", object.getId()).getWrapper());
            List<BlogTags> temps = new ArrayList<>();
            object.getTags().forEach((value) -> {
                temps.add(new BlogTags(object.getId(), value.getId()));
                tagService.saveOrUpdateBatchByMultiId(temps);
            });
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        } catch (Exception e) {
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }

    @GetMapping("/get/blogList")
    public String getBlogListByPageNum(@RequestParam int pageNum) {
        List<Blog> list = mapper.selectblogsByPageNum((pageNum-1)*5,5);
        JSONArray object = JSONUtil.parseArray(list).setDateFormat("yyyy-MM-dd");
        return JSONUtil.parse(RestBean.success(object)).toStringPretty();
    }
    @GetMapping("/get/blog/count")
    public String getBlogCount(){
        return JSONUtil.parse(RestBean.success(mapper.selectCount(null))).toStringPretty();
    }
    @GetMapping("/get/blog")
    public String getBlogById(@RequestParam String id){
        JSONObject blog = JSONUtil.parseObj(mapper.selectBlog(id));
        blog.setDateFormat("yyyy-MM-dd");
        return JSONUtil.parse(RestBean.success(blog)).toStringPretty();
    }
    @PostMapping("/post/image")
    public String uploadImage(@RequestParam(value = "image") MultipartFile file) throws IOException {
        //获取项目根目录
        String path = "/www/wwwroot/blog/static/";
        File upload = new File(path);
        //判断不存在该目录就创建
        if (!upload.exists()){
            upload.mkdirs();
        }
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        file.transferTo(new File(upload,filename));
        return JSONUtil.parse(RestBean.success(filename)).toStringPretty();
    }
    @GetMapping("/get/category/blog")
    public String getBlogListByCategoryName(@RequestParam String categoryName,@RequestParam int pageNum) {
        Long id = categoryService.query().eq("category_name",categoryName).one().getId();
        List<Blog> blogList = mapper.getBlogListByCategoryId(id,(pageNum-1)*5,5);
        return JSONUtil.parse(RestBean.success(blogList)).toStringPretty();
    }
    @GetMapping("/get/category/blog/count")
    public String getBlogByCategoryCount(@RequestParam String categoryName){
        Long id = categoryService.query().eq("category_name",categoryName).one().getId();
        Long count = service.query().eq("category_id",id).count();
        return JSONUtil.parse(RestBean.success(count)).toStringPretty();
    }
    @GetMapping("/view/blog")
    public String viewBlog(@RequestParam String id){
        Blog blog = service.getById(id);
        SystemStats stats = statsService.getOne(null);
        stats.setBlogViews(stats.getBlogViews()+1);
        statsService.saveOrUpdate(stats);
        blog.setViews(blog.getViews()+1);
        service.saveOrUpdate(blog);
        return JSONUtil.parse(RestBean.success()).toStringPretty();
    }
    @GetMapping("/get/tag/blog")
    public String getBlogByTag(@RequestParam String tagName,@RequestParam String pageNum){
        Long tagId = Long.valueOf(iTagService.query().eq("tag_name",tagName).one().getId());
        List<Blog> blogList = mapper.selectBlogByTag(tagId,(Integer.parseInt(pageNum)-1)*5);
        JSONArray array = JSONUtil.parseArray(blogList).setDateFormat("yyyy-MM-dd");

        return JSONUtil.parse(RestBean.success(array)).toStringPretty();
    }
    @GetMapping("/get/tag/blog/count")
    public String getBlogByTagCount(@RequestParam String tagName){
        return JSONUtil.parse(RestBean.success(iTagService.query().eq("tag_name",tagName).count())).toStringPretty();
    }
    @GetMapping("/get/blog/new")
    public String getNewBlogs(){
        List<Blog> list = mapper.selectNewBlogs();
        JSONArray array = JSONUtil.parseArray(list);
        array.setDateFormat("yyyy-MM-dd");
        return JSONUtil.parse(RestBean.success(array)).toStringPretty();
    }
    @GetMapping("/get/blog/top")
    public String getBlogTop(){
        List<Blog> list = mapper.selectTopBlogs();
        JSONArray array = JSONUtil.parseArray(list);
        array.setDateFormat("yyyy-MM-dd");
        return JSONUtil.parse(RestBean.success(array)).toStringPretty();
    }
}

