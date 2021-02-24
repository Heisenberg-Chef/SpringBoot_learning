package com.qi.springboot02config.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

public class isMobileImpl implements ConstraintValidator<isMobile,String> {

    private boolean required = false;

    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required)
        {
            // 必须
            return isMobileUtil.isMobile(s);
        }
        else
        {
            // 非必须
            if(StringUtils.isEmpty(s))
            {return false;}
            else
            {
                return isMobileUtil.isMobile(s);
            }
        }
    }
}
