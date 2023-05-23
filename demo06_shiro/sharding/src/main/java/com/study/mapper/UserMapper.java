package com.study.mapper;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @auther shkstart
 * @create 2021-11-18-15:06
 */
@Mapper
@Repository
public interface UserMapper {
  int addUser(@Param("name") String name, @Param("password") String password);
  User queryUser(@Param("name") String name, @Param("password") String password);

}
