package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("blog_tag")
@Data
@AllArgsConstructor
public class BlogTags {
    @MppMultiId
    @TableField("blog_id")
    Long blogId;
    @MppMultiId
    @TableField("tag_id")
    Integer tagId;
}
