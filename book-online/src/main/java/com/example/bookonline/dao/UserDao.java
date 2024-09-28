package com.example.bookonline.dao;

import com.example.bookonline.entity.User;

public interface UserDao {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据条件查找用户
     *
     * @param userDto
     * @return
     */
    User findUser(User userDto);

    boolean isUserExists(String account);
}
