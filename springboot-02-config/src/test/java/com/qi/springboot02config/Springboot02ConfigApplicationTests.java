package com.qi.springboot02config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
    @Autowired
    private com.qi.springboot02config.pojo.dog dog;
    @Test
    void contextLoads() {
        System.out.println(dog);
    }

}
