package com.study.controller;

import com.study.dao.UserMapper;
import com.study.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author yangz
 * @create 2021-11-08-14:06
 */
@RestController
public class UserController {
    private UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @RequestMapping(value = "/one/{id}",method = RequestMethod.GET)
    public User queryById(@PathVariable int id) {
        return userMapper.queryById(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String deleteOne(@PathVariable int id) {
        userMapper.deleteUser(id);
        return "delete-ok";
    }


}
