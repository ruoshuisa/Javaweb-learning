package com.example.bookonline.dao;

import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().nickname("syc").account("123").password("root").address("江苏常州").avatar("/src/main/webapp/images/bizhi.jpg").build();
        userDao.insertUser(user);
    }

    @Test
    void findUser() {
    }
}