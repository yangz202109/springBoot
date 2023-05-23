package com.study.dao;

import com.study.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author yangz
 * @create 2021-11-08-15:14
 */
@Mapper
@Repository
public interface EmpMapper {
    /**
     * 查询所有用户
     */
    List<Employee> queryAll();

    /**
     * 通过id查询一个用户
     */
    Employee queryById(@Param("id") int id);

    int addEmp(Employee employee);

    int deleteEmp(@Param("id") int id);

    int updateEmp(Employee employee);


}
