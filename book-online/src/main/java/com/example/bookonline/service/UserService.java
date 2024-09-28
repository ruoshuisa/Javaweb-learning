package com.example.bookonline.service;

import com.example.bookonline.entity.User;

public interface UserService {
    /**
     * 用户登录功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    User signIn(String account, String password);



    /**
     *
     * 用户注册功能
     *
     */

}
