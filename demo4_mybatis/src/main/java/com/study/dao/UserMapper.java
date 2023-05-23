package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @create 2021-11-08-13:37
 * @author yangz
 * 该注解表示这是一个mybatis的mapper类
 * */
@Mapper
@Repository
public interface UserMapper {

    List<User> queryAll();

    User queryById(@Param("id") int id);

    int addUser(User user);

    int deleteUser(@Param("id") int id);

    int updateUser(User user);

}
