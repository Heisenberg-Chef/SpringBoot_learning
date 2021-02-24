package com.qi.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    //  再次复习springboot的yaml注入方式
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource DruidDataSource()
    {
        return new DruidDataSource();
    }

    // 后台监控功能
    @Bean
    public ServletRegistrationBean statViewServletServletRegistrationBean()
    {
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String,String> initParam = new HashMap<>();
        // 是固定的
        initParam.put("loginUsername","admin");
        initParam.put("loginPassword","008778");

        // 允许谁进行访问,如果为空则为所有人都可以访问
        initParam.put("allow","");

        // 禁止谁访问 , 不让Heisenberg 从这个地址访问
        initParam.put("Heisenberg","192.168.1.1");

        statViewServletServletRegistrationBean.setLoadOnStartup(1);
        statViewServletServletRegistrationBean.setInitParameters(initParam);
        return statViewServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,*.html");
        filterFilterRegistrationBean.setInitParameters(map);
        return filterFilterRegistrationBean;
    }
}
