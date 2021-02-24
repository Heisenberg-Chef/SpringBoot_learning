package com.qi.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity      // 启动安全组件
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问 但是里面的功能也只有对应有权限的人才可以访问. AOP
        http.authorizeRequests().antMatchers("/").permitAll() // 首页
            .antMatchers("/level1/**").hasRole("vip1") // vip1
            .antMatchers("/level2/**").hasRole("vip2") // vip2
            .antMatchers("/level3/**").hasRole("vip3"); // vip3
        // 关闭跨站攻击防护
        http.csrf().disable();
        // 没有权限则跳转请求,并没有书写登陆页面,但是可以登陆进去
        http.formLogin().loginProcessingUrl("/login").usernameParameter("user").passwordParameter("pwd").loginPage("/login");
        // 记住我
        http.rememberMe().rememberMeParameter("remember");
    }

    // 添加用户与授权
    // 密码编码,PasswordEncoding 500报错
    // 在Spring Security 5.0 + 新增了不少加密方式 , 明文密码不安全不让用
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用了默认的加密方式 BCryptPasswordEncoder
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("Ray").roles("vip1","vip2")
                .password(new BCryptPasswordEncoder().encode("008778"));
    }
}
