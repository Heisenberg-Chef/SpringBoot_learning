package com.qi.asynochorous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class AsyncService {
    @Async
    public void hello()
    {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("数据正在处理中...");
    }

    @Autowired
    JavaMailSender javaMailSender;

//    # 邮件配置
//    spring.mail.username=825958926@qq.com
//    spring.mail.password=saoidhfoighasdf
//    spring.mail.host=mail.qq.com
//    # 开启加密验证
//    spring.mail.properties.mail.smtp.ssl.enable=true

    public void sendSimpleMail()
    {
        // 实体化一个简单的邮件类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 注入属性
        simpleMailMessage.setSubject("aaa");
        simpleMailMessage.setText("abc");
        // 发给谁
        simpleMailMessage.setTo("825958926@qq.com");
        // 从哪里发送
        simpleMailMessage.setFrom("825958926@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    public void sendMimeMail() throws MessagingException {
        // 实体化一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 组装 -- 允许使用附件等功能
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("title plus");
        // html
        mimeMessageHelper.setText("<p> 1111 </p>",true);
        // 附件
        mimeMessageHelper.addAttachment("1.jpg",new File("/?/?/...."));
        // 发给谁
        mimeMessageHelper.setTo("825958926@qq.com");
        // 从哪里发送
        mimeMessageHelper.setFrom("825958926@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
