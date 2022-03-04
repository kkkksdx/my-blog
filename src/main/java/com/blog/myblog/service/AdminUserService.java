package com.blog.myblog.service;

import com.blog.myblog.entity.AdminUser;

/**
 * @Description: TODO
 * @author: Li
 * @date: 2022年03月01日 9:38
 */
public interface AdminUserService {
    AdminUser login(String userName, String password);

    AdminUser getUserDetailById(Integer loginUserId);

    Boolean updatePassword(Integer loginUserId,String originalPassword,
                           String newPassword);
    Boolean updateName(Integer loginUserId,String loginUserName,String nickName);
}
