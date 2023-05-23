package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yangz
 * @create 2021-11-09-10:43
 */
@Mapper
@Repository
public interface UserMapper {
    User existOneByName(String name);
    User existOneByPass(String password);
}
