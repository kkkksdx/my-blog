package com.blog.myblog.dao;


import com.blog.myblog.entity.Blog;
import com.blog.myblog.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface BlogMapper {
    int deleteByPrimaryKey(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long blogId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<Blog> findBlogList(PageQueryUtil pageUtil);

    int getTotalBlogs(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    List<Blog> findBlogListByType(@Param("type") int type, @Param("limit") int limit);

    int getTotalBlogsByTagId(PageQueryUtil pageUtil);

    List<Blog> getBlogsPageByTagId(PageQueryUtil pageUtil);
}