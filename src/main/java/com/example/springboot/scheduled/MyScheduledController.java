package com.example.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @date : 2018/10/24 17:33
 * @author: liangenmao
 */
@Component
public class MyScheduledController {
    private static final String NOW_TIME = "0 0 */1 * * ?";
    @Scheduled(cron = NOW_TIME)
    public void autoCancelOrder(){
        System.out.println("现在是" + new Date());
    }
}
