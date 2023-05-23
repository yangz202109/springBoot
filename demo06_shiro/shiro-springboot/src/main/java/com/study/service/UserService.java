package com.study.service;

import com.study.pojo.User;

/**
 * @auther shkstart
 * @create 2021-11-11-16:30
 */
public interface UserService {
    User queryUserByName(String name);

    int addUser(User user);
}
