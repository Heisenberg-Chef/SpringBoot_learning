package com.qi.springboot02config;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class exceptionDistribution {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public void exceptionSolute(Exception e)
    {
        System.out.println(e.getMessage());
    }
}

