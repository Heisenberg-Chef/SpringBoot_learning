package com.qi.shiro;

import com.qi.shiro.service.UserDIYService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    UserDIYService userDIYService;
    @Test
    void contextLoads() {
        System.out.println(userDIYService.queryUserByName("ray"));
    }

}
