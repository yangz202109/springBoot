package com.study.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @author yangz
 * @create 2021-11-04-8:52
 */
@Data
public class Employee {
    private int id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;
}
