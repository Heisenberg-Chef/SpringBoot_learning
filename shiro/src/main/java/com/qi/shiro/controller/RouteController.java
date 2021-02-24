package com.qi.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RouteController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model)
    {
        model.addAttribute("msg","Hello Shiro.");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toAdd()
    {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate()
    {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }

    @RequestMapping("/login")
    // 无论位置如何,都不会影响前端对后端的参数的传递.
    public String login(Model model,String username,String password)
    {
        System.out.println(username+" "+password);
        // 获取当前的用户 : 由工具类获取来的
        Subject subject = SecurityUtils.getSubject();
        // 封装当前用户的登陆数据 UsernamePasswordToken 是shiro的用户认证大类
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            return "index";
        }catch (UnknownAccountException e)
        {
            System.out.println("Username error");
            model.addAttribute("msg","Unknown Username Name");
            return "login";
        }catch (IncorrectCredentialsException e)
        {
            System.out.println("Password error");
            model.addAttribute("msg","Password Error");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String NoAuth()
    {
        return "认证失败无法访问";
    }
}
