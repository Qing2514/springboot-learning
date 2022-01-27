package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

        // String[] arg = new String[1];
        // arg[0] = "--server.port=8081";
        // System.out.println(Arrays.toString(arg));
        // // arg中保存的就是覆盖参数的信息
        // SpringApplication.run(SpringbootApplication.class, arg);
        // // 断开读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
        // SpringApplication.run(SpringbootApplication.class);
    }

}
