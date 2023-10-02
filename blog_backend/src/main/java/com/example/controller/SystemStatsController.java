package com.example.controller;

import cn.hutool.json.JSONUtil;
import com.example.entity.SiteSetting;
import com.example.entity.SystemStats;
import com.example.service.ISystemStatsService;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
public class SystemStatsController {
    @Resource
    ISystemStatsService service;
    @GetMapping("/get/webStats")
    public String getWebStats(){
        SystemStats stats = service.getById(1);
        return JSONUtil.parse(RestBean.success(stats)).toStringPretty();
    }
    @GetMapping("/view/site")
    public String viewSite(){
        SystemStats stats = service.getById(1);
        stats.setBlogViews(stats.getBlogViews()+1);
        service.saveOrUpdate(stats);
        return JSONUtil.parse(RestBean.success()).toStringPretty();
    }
}
