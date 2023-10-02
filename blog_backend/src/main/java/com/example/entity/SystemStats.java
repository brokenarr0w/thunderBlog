package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
@TableName("system_stats")
public class SystemStats implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 网站浏览数
     */
    private Integer webViews;

    /**
     * 文章观看数
     */
    private Integer blogViews;

    /**
     * 文章点赞数
     */
    private Integer blogLikes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWebViews() {
        return webViews;
    }

    public void setWebViews(Integer webViews) {
        this.webViews = webViews;
    }

    public Integer getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Integer blogViews) {
        this.blogViews = blogViews;
    }

    public Integer getBlogLikes() {
        return blogLikes;
    }

    public void setBlogLikes(Integer blogLikes) {
        this.blogLikes = blogLikes;
    }

    @Override
    public String toString() {
        return "SystemStats{" +
        "id = " + id +
        ", webViews = " + webViews +
        ", blogViews = " + blogViews +
        ", blogLikes = " + blogLikes +
        "}";
    }
}
