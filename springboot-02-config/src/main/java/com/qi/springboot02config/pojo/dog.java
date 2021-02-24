package com.qi.springboot02config.pojo;

import com.qi.springboot02config.validator.isMobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "dog")
public class dog {
    @isMobile
    private String name;
    @Null
    private Integer age;
}
