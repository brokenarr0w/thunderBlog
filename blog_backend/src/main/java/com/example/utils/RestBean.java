package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestBean<T> {
    int code;
    T data;
    String msg;
    public static <T> RestBean<T> success(T data){
        return new RestBean<>(200,data,"成功");
    }
    public static <T> RestBean<T> success(){
        return new RestBean<>(200,null,"成功");
    }
    public static <T> RestBean<T> failure(String msg){
        return new RestBean<>(400,null,msg);
    }
    public static <T> RestBean<T> failure(){
        return new RestBean<>(400,null,"失败");
    }
}
