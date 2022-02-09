package com.example.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * myTask
 *
 * @author Qing2514
 * @since 0.0.1
 */
@Component
public class MyTask {

    @Scheduled(cron = "0/2 * * * * ?")
    public void print() {
        System.out.println("task run...");
    }

}
