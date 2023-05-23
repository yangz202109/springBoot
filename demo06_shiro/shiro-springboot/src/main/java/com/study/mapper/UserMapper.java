package com.study.mapper;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @auther shkstart
 * @create 2021-11-11-16:20
 */
@Repository
@Mapper
public interface UserMapper {
    User queryUserByname(@Param("name") String name);

    int addUser(User user);
}
