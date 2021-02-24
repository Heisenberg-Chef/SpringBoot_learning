package com.qi.shiro.service;

import com.qi.shiro.mapper.UserMapper;
import com.qi.shiro.pojo.UserDIY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // 业务层,这其中业务与sql的查询相似且没有联合查询.因此汇聚数据进行封装的操作也可以在dao层完成
// 在实际的开发中对于数据的汇聚也是十分重要的.
public class UserDIYServiceImpl implements UserDIYService{
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDIY queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
