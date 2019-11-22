package com.tangwh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

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
        helper.setSubject("彭于晏");//设置主题
        helper.setText("周末快乐呀！",true);
        //附件
        helper.addAttachment("1.jpg", new File("C:\\Users\\86177\\Desktop\\Howe.jpg"));

        helper.setTo("2678691035@qq.com"); //发件人  // 要给谁发送
        helper.setFrom("t2678691035@163.com");//件人  //谁发送

        javaMailSender.send(mimeMessage);
    }
}
