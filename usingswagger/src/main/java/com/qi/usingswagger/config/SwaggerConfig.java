package com.qi.usingswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

// swagger-ui
@Configuration
@EnableSwagger2 // 开启swagger
public class SwaggerConfig {
    // 配置类
    @Bean
    public Docket docket(Environment env)
    {
        String[] activeProfiles = env.getActiveProfiles();
        Profiles profiles = Profiles.of("dev","text");
        // 查看是否处于自己设定的环境中.
        boolean b = env.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2). // 指定swagger版本
                apiInfo(func()).
                select().apis(RequestHandlerSelectors.
                        /**     RequestHandlerSelectors , 配置要扫描接口的方法
                         *          basePackage():指定要扫描的包 -- 用的最多的
                         *          any() : 扫描所有的包
                         *          none() : 不扫包
                         *          withClassAnnotation : 扫描类上的注解 , 参数是一个注解的反射对象
                         *          withMethodAnnotation : 扫描方法上的注解
                          */
                basePackage("com.qi.usingswagger")).    // 指定扫包
                /**
                 *  只扫描abc路径下的接口.
                 */
//                paths(PathSelectors.ant("/abc/")).
                build();
    }

    public ApiInfo func()
    {
//        public class ApiInfo {
//            public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
//            public static final springfox.documentation.service.ApiInfo DEFAULT;
//            private final String version;
//            private final String title;
//            private final String description;
//            private final String termsOfServiceUrl;
//            private final String license;
//            private final String licenseUrl;
//            private final Contact contact;
//            private final List<VendorExtension> vendorExtensions;
        // 作者信息
        Contact contact = new Contact("Heisenberg","abc.efg","825958926@qq.com");
        return new ApiInfo("Heisenberg's Swagger Log","No body knows it better than me.","1.0",
                "http://localhost:8080",contact,"Apache2.0","aaaaaa",
                new ArrayList<>());
    }
}
