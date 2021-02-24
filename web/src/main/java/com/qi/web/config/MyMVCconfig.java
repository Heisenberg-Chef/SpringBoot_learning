package com.qi.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 我们只要写外部配置都需要这个主类型 继承了 WebMvcConfigurer
@Configuration  // 相当于beans
public class MyMVCconfig implements WebMvcConfigurer {
    // 主页的访问,多个页面都可以指向主页.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    // 放入spring的bean中托管
    @Bean
    public static LocaleResolver localeResolver()
    {
        return new LocalResolverConfig();
    }

    // 托管拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").     // 添加所有路径
                excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**"); // 排除不被拦截的路径
    }
}
