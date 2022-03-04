package com.blog.myblog.service;

import com.blog.myblog.entity.BlogLink;
import com.blog.myblog.utils.PageQueryUtil;
import com.blog.myblog.utils.PageResult;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月02日 19:58
 */
public interface LinkService {
    /**
     * 查询友链的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer id);

    Boolean updateLink(BlogLink tempLink);

    Boolean deleteBatch(Integer[] ids);
}
