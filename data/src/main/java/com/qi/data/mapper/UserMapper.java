package com.qi.data.mapper;

import com.qi.data.pojo.User;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个注解表示了这是一个Mybatis的Mapper类
@Mapper
@MapperScan("com.qi.data.Mapper")   //  扫描包
@Repository
public interface UserMapper {
    List<User> queryList();
//    User queryUserById(int id);
//    int addUser(User user);
//    int addUpdateUser(User user);
//    int deleteUser(int id);
}
