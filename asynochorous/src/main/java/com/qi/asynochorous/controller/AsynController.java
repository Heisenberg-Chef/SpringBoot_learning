package com.qi.asynochorous.controller;

import com.qi.asynochorous.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/")
    public String hello()
    {
        asyncService.hello();
        return "Hello world";
    }
}
