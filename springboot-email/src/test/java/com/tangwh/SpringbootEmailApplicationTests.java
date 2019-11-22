package com.tangwh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootEmailApplicationTests {

    /**
     * 邮件发送
     */
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Hello small-howe"); //主题
        message.setText("这里是文本内容");//文本

        message.setTo("yuanshidong-xsxx@e-chinalife.com"); //发送给谁
        message.setFrom("t2678691035@163.com");//收件人
        javaMailSender.send(message);
    }


    @Test
    void contextLoads2() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

         //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("Hello Word");//设置主题
        helper.setText("<h1 style='color:red'>这里是内容</h1>",true);
        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\86177\\Desktop\\Howe.jpg"));

        helper.setTo("t2678691035@163.com"); //发送给谁
        helper.setFrom("t2678691035@163.com");//收件人

        javaMailSender.send(mimeMessage);
    }
}
