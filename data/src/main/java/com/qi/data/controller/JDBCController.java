package com.qi.data.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public List<Map<String,Object>> func()
    {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.queryForList(sql);
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id)
    {
        String sql = "update mybatis.user set name=?,pwd=? where id="+id;
        Object[] objs = new Object[2];
        objs[0] = "小明";
        objs[1] = "abbbbbbc";
        jdbcTemplate.update(sql,objs);
        return "ok-update";
    }
}
