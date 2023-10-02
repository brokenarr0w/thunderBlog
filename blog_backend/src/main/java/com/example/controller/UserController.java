package com.example.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.example.entity.Token;
import com.example.entity.User;
import com.example.service.IUserService;
import com.example.utils.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Resource
    IUserService service;
    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        User user = service.query().eq("username",username).one();
        if(user == null){
            return JSONUtil.parse(RestBean.failure("用户不存在")).toStringPretty();
        }else if(!user.getPassword().equals(password)){
            return JSONUtil.parse(RestBean.failure("密码错误")).toStringPretty();
        }else {
            StpUtil.login(username);
            return JSONUtil.parse(RestBean.success(new Token(StpUtil.getTokenValue()))).toString();
        }
    }
}
