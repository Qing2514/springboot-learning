package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启缓存功能
@EnableCaching
// 开启定时任务功能
@EnableScheduling
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

        // // 第三方bean属性绑定
        // ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        // Source source = run.getBean(Source.class);
        // System.out.println(source);
        // DruidDataSource ds = run.getBean(DruidDataSource.class);
        // System.out.println(ds.getDriverClassName());

    }

    // @Bean
    // @ConfigurationProperties(prefix = "datasource")
    // public DruidDataSource datasource() {
    //     DruidDataSource ds = new DruidDataSource();
    //     return ds;
    // }

}
