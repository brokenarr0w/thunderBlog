package com.example.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Moment;
import com.example.service.IMomentService;
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
public class MomentController {
    @Resource
    IMomentService service;
    @GetMapping("/get/moments")
    public String getMomentList(){
        try{
           List<Moment> momentList = service.list();
           return JSONUtil.parse(RestBean.success(momentList)).toStringPretty();
        }catch (Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }
    @PostMapping("/post/moment")
    public String insertMoment(@RequestBody String moment){
        try{
            service.saveOrUpdate(JSONUtil.toBean(moment,Moment.class));
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch(Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
    }

    @DeleteMapping("/delete/moment")
    public String deleteMomentById(@RequestParam String id){
        try{
            service.removeById(id);
            return JSONUtil.parse(RestBean.success()).toStringPretty();
        }catch(Exception e){
            return JSONUtil.parse(RestBean.failure(e.getMessage())).toStringPretty();
        }
        }
   @GetMapping("/get/moment")
    public String getMomentListByPageNum(@RequestParam Integer pageNum){
       Page<Moment> page;
       page = new Page<>(pageNum,5);

       List<Moment> momentList = service.page(page).getRecords();
       System.out.println(momentList);
       JSONArray objects = JSONUtil.parseArray(momentList);
       objects.setDateFormat("yyyy-MM-dd");
       return JSONUtil.parse(RestBean.success(objects)).toStringPretty();
   }
   @GetMapping("/moment/like")
    public String updateLike(@RequestParam String id){
        Moment moment = service.getById(id);
        moment.setLikes(moment.getLikes() + 1);
        service.saveOrUpdate(moment);
        return JSONUtil.parse(RestBean.success()).toStringPretty();
   }
   @GetMapping("/get/moment/count")
    public String getMomentCount(){
        return JSONUtil.parse(RestBean.success(service.count())).toStringPretty();
   }
}
