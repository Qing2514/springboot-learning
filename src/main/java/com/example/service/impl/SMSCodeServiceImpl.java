package com.example.service.impl;

import com.example.controller.utils.CodeUtils;
import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * SMSCodeServiceImpl
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
    // 每次都重新运行并将数据存入缓存（适用于手机验证码）
    @CachePut(value = "smsCode", key = "#tele")
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        System.out.println(code);
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }
}
