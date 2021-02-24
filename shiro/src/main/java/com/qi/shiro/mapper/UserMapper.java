package com.qi.shiro.mapper;

import com.qi.shiro.pojo.UserDIY;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository // 注册到spring中
@Mapper //  作为一个mapper文件
public interface UserMapper {
    public UserDIY queryUserByName(String name);
}
