package com.blog.myblog.service;

import com.blog.myblog.controller.vo.BlogDetailVO;
import com.blog.myblog.controller.vo.BlogListVO;
import com.blog.myblog.controller.vo.SimpleBlogListVO;
import com.blog.myblog.entity.Blog;

import com.blog.myblog.utils.PageQueryUtil;
import com.blog.myblog.utils.PageResult;

import java.util.List;


/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月02日 14:15
 */
public interface BlogService {
    String saveBlog(Blog blog);

    Blog getBlogById(Long id);

    String updateBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 首页侧边栏数据列表
     * 0-点击最多 1-最新发布
     *
     * @param type
     * @return
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * 获取首页文章列表
     *
     * @param page
     * @return
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 根据索引获得首页文章列表
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryName
     * @param page
     * @return
     */
    PageResult getBlogsPageByCategory(String categoryName, Integer page);

    /**
     * 根据标签获取文章列表
     *
     * @param tagName
     * @param page
     * @return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 文章获取
     * @param blogId
     * @return
     */
    BlogDetailVO getBlogDetail(Long blogId);

    BlogDetailVO getBlogDetailVO(Blog blog);
}