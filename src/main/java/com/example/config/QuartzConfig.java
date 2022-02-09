package com.example.config;

import com.example.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QuartzConfig
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        // 绑定具体工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printJobTrigger() {
        // 参数依次为 秒 分 时 日 月 星期几，？代表根据其他自动匹配，*代表任意，0,10表示每到0和10都执行，0/10表示从0开始每过10执行一次
        ScheduleBuilder scheBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        // 绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheBuilder).build();
    }

}
