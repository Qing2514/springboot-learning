package com.example.controller.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * CodeUtils
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Component
public class CodeUtils {

    private final String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        long hash = tele.hashCode();
        long encryption = 20010302;
        // 异或操作
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }

    // public static void main(String[] args) {
    //     System.out.println(new CodeUtils().generator("15397099886"));
    // }
}
