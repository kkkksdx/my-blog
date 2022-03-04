package com.blog.myblog.controller.vo;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月04日 12:40
 */
public class SimpleBlogListVO implements Serializable {

    private Long blogId;

    private String blogTitle;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}