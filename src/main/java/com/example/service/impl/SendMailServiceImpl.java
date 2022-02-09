package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * SendMailServiceImpl
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    // 发送人，()中为显示的发件人昵称
    private final String from = "2514632453@qq.com" + "(马)";
    // 收件人
    private final String to = "2514632453@qq.com";
    // 标题
    private final String subject = "测试主题";
    // 正文
    private final String context = "测试内容: <a href='https://www.baidu.com'>百度</a>" + "<img src='https://gimg2.baidu" +
            ".com/image_search/src=http%3A%2F%2Fc-ssl.duitang" + ".com%2Fuploads%2Fitem%2F202002%2F16" +
            "%2F20200216195809_lrvuj.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl" + ".duitang.com&app=2002&size=f9999," +
            "10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1647005114&t=3aab6554aa572a5f8fad017dbc654cae'/>";
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }

    @Override
    public void sendMail2() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            // 开启支持添加多部件（包括附件）
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // 支持html
            helper.setText(context, true);
            // 添加附件
            File file1 = new File("D:\\IDEA\\springboot\\src\\main\\resources\\img.png");
            File file2 = new File("D:\\IDEA\\springboot\\src\\main\\resources\\img_1.png");
            helper.addAttachment(file1.getName(), file1);
            helper.addAttachment("祢豆子.png", file2);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
