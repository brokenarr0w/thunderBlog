package com.example.controller;

import cn.hutool.json.JSONUtil;
import com.example.entity.About;
import com.example.service.IAboutService;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
public class AboutController {
    @Resource
    IAboutService service;
    @GetMapping("/get/about")
    public String getAbout(){
        About about = service.getById(1);
        return JSONUtil.parse(RestBean.success(about)).toStringPretty();
    }
    @PostMapping("/post/about")
    public String saveAbout(@RequestBody String about){
        About temp = JSONUtil.toBean(about,About.class);
        service.updateById(temp);
        return JSONUtil.parse(RestBean.success()).toStringPretty();
    }
}
