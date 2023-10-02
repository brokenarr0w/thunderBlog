package com.example.controller;

import cn.hutool.json.JSONUtil;
import com.example.entity.Tag;
import com.example.service.ITagService;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
public class TagController {
    @Resource
    ITagService service;
    @GetMapping("/get/tagList")
    public String getTagList(){
        List<Tag> tagList = service.list();
        return JSONUtil.parse(RestBean.success(tagList)).toStringPretty();
    }
    @DeleteMapping("/delete/tag")
    public String deleteTagById(@RequestParam String id){
        try {
            service.removeById(id);
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch (Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }

    }
    @PostMapping("/post/tag")
    public String insertTag(@RequestBody String tag){

        try {
            service.saveOrUpdate(JSONUtil.toBean(tag,Tag.class));
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch (Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }

}
