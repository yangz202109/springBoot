package com.study.service.impl;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import com.study.service.UserService;
import com.study.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther shkstart
 * @create 2021-11-11-16:30
 */
@Service
public class UserServiceimpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByname(name);
    }

    @Override
    public int addUser(User user) {

        //对添加的用户的密码进行加密
        //1.生成随机盐
        String salt = SaltUtils.getSalt(10);
        //2.随机盐保存到该对象中
        user.setSalt(salt);
        //3.明文加密 md5+salt+hash
        Md5Hash md5Hash = new Md5Hash(user.getUpwd(), salt, 1024);
        //修改密码
        user.setUpwd(md5Hash.toHex());

        return userMapper.addUser(user);
    }
}
