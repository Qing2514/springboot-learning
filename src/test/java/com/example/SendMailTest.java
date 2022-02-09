package com.example;

import com.example.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SendMailTest
 *
 * @author Qing2514
 * @since 0.0.1
 */
@SpringBootTest
public class SendMailTest {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void sendMail() {
        sendMailService.sendMail();
        sendMailService.sendMail2();
    }
}
