package com.study.dao;

import com.study.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangz
 * @create 2021-11-08-16:11
 */
@Mapper
@Repository
public interface DepMapper {
    List<Department> queryDeps();
}
