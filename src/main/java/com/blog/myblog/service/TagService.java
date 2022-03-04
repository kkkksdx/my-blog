package com.blog.myblog.service;

import com.blog.myblog.entity.BlogTagCount;
import com.blog.myblog.utils.PageQueryUtil;
import com.blog.myblog.utils.PageResult;

import java.util.List;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月01日 19:29
 */
public interface TagService {
    /**
     * 查看标签的分页数据
     * @param pageQueryUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageQueryUtil);

    Boolean saveTag(String tagName);
    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
