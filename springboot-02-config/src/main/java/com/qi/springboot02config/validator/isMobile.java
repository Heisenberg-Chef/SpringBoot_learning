package com.qi.springboot02config.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.*;

// FIELD 成员变量作用域
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)  // 作用时间
@Documented
@Constraint(
        validatedBy = {isMobileImpl.class}
)
public @interface isMobile {
    boolean required() default true; // 前端是否需要穿这个数

    String message() default "手机号格式错误";
    //  这两句是springboot的注解需要的参数.
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)  // 作用时间
    @Documented
    @Constraint(
            validatedBy = {isMobileImpl.class}
    )
    public @interface isMobile {
        boolean required() default true; // 前端是否需要穿这个数

        String message() default "手机号格式错误";
        //  这两句是springboot的注解需要的参数.
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
