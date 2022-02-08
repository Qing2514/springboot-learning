package com.example.controller;

import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SMSCodeController
 *
 * @author Qing2514
 * @since 0.0.1
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tele) {
        return smsCodeService.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
