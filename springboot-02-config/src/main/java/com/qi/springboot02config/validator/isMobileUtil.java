package com.qi.springboot02config.validator;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isMobileUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\[0-9]{10}");

    public static boolean isMobile(String src)
    {
        if(StringUtils.isEmpty(src))
        {
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }
}
