package com.study;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @auther shkstart
 * @create 2021-11-18-15:02
 */
@SpringBootTest
public class Mytest {
    @Autowired
    private UserMapper userMapper;

    @Resource
    DataSource dataSource;

    @Test
    public void t(){
        System.out.println(dataSource);
    }

    @Test
    void add() {
        int i = userMapper.addUser("long", "123456");
        System.out.println(i);
    }

    @Test
    public void query() {
        User user = userMapper.queryUser("long", "123456");
        System.out.println(user);
    }
}
