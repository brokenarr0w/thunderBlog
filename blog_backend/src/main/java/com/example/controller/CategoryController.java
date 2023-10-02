package com.example.controller;

import cn.hutool.json.JSONUtil;
import com.example.entity.Category;
import com.example.service.ICategoryService;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
public class CategoryController {
    @Resource
    ICategoryService service;

    @GetMapping("/get/categoryList")
    public String getCategoryList(){
        List<Category> categoryList = service.list();
        return JSONUtil.parse(RestBean.success(categoryList)).toStringPretty();
    }
    @PostMapping("/post/category")
    public String insertCategory(@RequestBody String category){
        try{
            service.saveOrUpdate(JSONUtil.toBean(category, Category.class));
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch(Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }
    @DeleteMapping("/delete/category")
    public String deleteCetegoryById(@RequestParam String id){
        try{
            service.removeById(id);
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch(Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }
}
