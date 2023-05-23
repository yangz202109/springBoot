package com.study.controller;

import com.study.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangz
 * @create 2021-11-12-14:52
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

    //当接口中，存在实体类，就会被Swagger扫描
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制类")
    @GetMapping(value = "/toHello")
    public String hello(@ApiParam("用户名") String username){
        return "hello "+username;
    }
}
