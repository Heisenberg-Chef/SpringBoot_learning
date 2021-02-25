package com.qi.asynochorous.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    // 在一个定时的时间执行这个方法 cron 表达式
    // 秒 分 时 日 月 周几
    @Scheduled(cron = "0 * * * * 0-7")
    public void scheduled()
    {
        System.out.println("嘿嘿嘿");
    }
}
