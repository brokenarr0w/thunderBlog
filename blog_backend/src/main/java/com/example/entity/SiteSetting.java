package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("site_setting")
public class SiteSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String blogName;
    private String webTitleSuffix;
    private String playlistServer;
    private String playlistId;
    @TableField("rolltext")
    private String rollText;
    private String name;
    private String github;
    private String qq;
    private String bilibili;
    private String netease;
    private String diy1;
    private String diy2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getWebTitleSuffix() {
        return webTitleSuffix;
    }

    public void setWebTitleSuffix(String webTitleSuffix) {
        this.webTitleSuffix = webTitleSuffix;
    }

    public String getPlaylistServer() {
        return playlistServer;
    }

    public void setPlaylistServer(String playlistServer) {
        this.playlistServer = playlistServer;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getRollText() {
        return rollText;
    }

    public void setRollText(String rollText) {
        this.rollText = rollText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBilibili() {
        return bilibili;
    }

    public void setBilibili(String bilibili) {
        this.bilibili = bilibili;
    }

    public String getNetease() {
        return netease;
    }

    public void setNetease(String netease) {
        this.netease = netease;
    }

    public String getDiy1() {
        return diy1;
    }

    public void setDiy1(String diy1) {
        this.diy1 = diy1;
    }

    public String getDiy2() {
        return diy2;
    }

    public void setDiy2(String diy2) {
        this.diy2 = diy2;
    }

    @Override
    public String toString() {
        return "SiteSetting{" +
                "id=" + id +
                ", blogName='" + blogName + '\'' +
                ", webTitleSuffix='" + webTitleSuffix + '\'' +
                ", playlistServer='" + playlistServer + '\'' +
                ", playlistId='" + playlistId + '\'' +
                ", rollText='" + rollText + '\'' +
                ", name='" + name + '\'' +
                ", github='" + github + '\'' +
                ", qq='" + qq + '\'' +
                ", bilibili='" + bilibili + '\'' +
                ", netease='" + netease + '\'' +
                ", diy1='" + diy1 + '\'' +
                ", diy2='" + diy2 + '\'' +
                '}';
    }
}
