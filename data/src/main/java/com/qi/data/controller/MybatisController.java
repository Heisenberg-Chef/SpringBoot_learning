package com.qi.data.controller;

import com.qi.data.mapper.UserMapper;
import com.qi.data.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String queryList()
    {
        List<User> userList = userMapper.queryList();
        for (User user:userList
             ) {
            System.out.println(user);
        }
        return userList.toString();
    }
}
