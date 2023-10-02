package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 湛蓝之翼
 */
@Configuration
public class staticConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = System.getProperty("user.dir")+"\\blog_backend\\src\\main\\resources\\static\\img\\";
        registry.addResourceHandler("/static/**").addResourceLocations("file:"+path);
    }
}
