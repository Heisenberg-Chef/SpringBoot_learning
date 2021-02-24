package com.qi.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocalResolverConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");// 我们定义语言标记符号lang= xxx 为l=xxx
        Locale locale = Locale.getDefault(); // 得到默认的环境,如果没有这个参数那么使用默认的.

        if(!StringUtils.isEmpty(l))
        {
            String[] s = l.split("_"); // 将en_US进行分割
            locale = new Locale(s[0], s[1]); // 语言 国家
        }
        return locale;
    }
    // 这个没必要写了 并没有返回类型我们不需要关注这个接口
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}
