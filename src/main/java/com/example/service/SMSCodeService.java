package com.example.service;

import com.example.domain.SMSCode;

/**
 * SMSCodeService
 *
 * @author Qing2514
 * @since 0.0.1
 */
public interface SMSCodeService {
    String sendCodeToSMS(String tele);

    boolean checkCode(SMSCode SMSCode);
}
