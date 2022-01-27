package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

        // 断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
        // SpringApplication.run(SpringbootApplication.class);
    }

}
