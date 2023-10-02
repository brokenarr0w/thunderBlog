package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Thunder
 * @since 2023-09-08
 */
public class Blog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片url
     */
    private String firstPicture;

    /**
     * 文章正文
     */
    private String content;

    /**
     * 摘要
     */
    private String description;

    /**
     * 是否置顶
     */
    private Boolean isTop;

    /**
     * 文章分类
     */
    @TableField(exist = false)
    private String categoryName;
    @TableField("category_id")
    private Integer categoryId;
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }



    /**
     * 阅读时间
     */
    private Long readTime;

    /**
     * 浏览次数
     */
    private Long views;

    /**
     * 文章字数
     */
    private Long words;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    @TableField(exist = false)
    private long totalNum;
    @TableField(exist = false)
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getReadTime() {
        return readTime;
    }

    public void setReadTime(Long readTime) {
        this.readTime = readTime;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getWords() {
        return words;
    }

    public void setWords(Long words) {
        this.words = words;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", isTop=" + isTop +
                ", categoryName='" + categoryName + '\'' +
                ", readTime=" + readTime +
                ", views=" + views +
                ", words=" + words +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", tags=" + tags +
                '}';
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }
}
