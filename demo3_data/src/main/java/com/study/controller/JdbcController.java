package com.study.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author yangz
 * @create 2021-11-06-9:34
 */
@RestController
public class JdbcController {
    JdbcTemplate jdbcTemplate;
    public JdbcController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/allUser",method = RequestMethod.GET)
    public List<Map<String, Object>> all(){
        String sql="select * from t_user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
            return list_maps;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable  int id){
        String sql="delete from t_user where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteUser-ok";

    }
}
