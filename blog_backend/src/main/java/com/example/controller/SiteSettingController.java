package com.example.controller;

import cn.hutool.json.JSONUtil;
import com.example.entity.SiteSetting;
import com.example.service.ISiteSettingService;
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
public class SiteSettingController {

    @Resource
    ISiteSettingService service;
    @GetMapping("/get/webSetting")
    public String getWebSetting(){
        SiteSetting setting = service.getById(1);
        return JSONUtil.parse(RestBean.success(setting)).toStringPretty();
    }

}
