package com.blog.myblog.service;

import com.blog.myblog.entity.BlogCategory;
import com.blog.myblog.utils.PageQueryUtil;
import com.blog.myblog.utils.PageResult;

import java.util.List;


/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月01日 14:33
 */
public interface CategoryService {
    /**
     * 查询分页数据
     * @param pageUtil
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);
    int getTotalCategories();
    /**
     * 添加分类数据
     */
    Boolean saveCategory(String categoryName,String categoryIcon);

    Boolean updateCategory(Integer categoryId,String categoryName,String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

    BlogCategory selectById(Integer id);
}
