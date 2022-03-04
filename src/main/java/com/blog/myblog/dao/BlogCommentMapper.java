package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogComment;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月04日 15:17
 */
public interface BlogCommentMapper {

        int deleteByPrimaryKey(Long commentId);

        int insert(BlogComment record);

        int insertSelective(BlogComment record);

        BlogComment selectByPrimaryKey(Long commentId);

        int updateByPrimaryKeySelective(BlogComment record);

        int updateByPrimaryKey(BlogComment record);

        List<BlogComment> findBlogCommentList(Map map);

        int getTotalBlogComments(Map map);

        int checkDone(Integer[] ids);

        int deleteBatch(Integer[] ids);
}
