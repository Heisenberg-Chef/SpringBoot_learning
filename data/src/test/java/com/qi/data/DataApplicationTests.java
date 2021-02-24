package com.qi.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DataApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        // 查看一下默认的数据源 Hikari.
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        connection.close();
    }

}
