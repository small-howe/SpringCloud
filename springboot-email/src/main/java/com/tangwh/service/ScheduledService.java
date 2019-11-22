package com.tangwh.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ScheduledService {

    //特定的事件 去执行这个方法




    //cron 表达式
    // 30 28 14 * * ?  :每天的 14点28分30秒执行此方法
    // 30 0/5 14,15 * * ? :每天的14点和15点 每隔5分钟执行一次
    //秒 分 时 日 月 周几~
   @Scheduled(cron = "30 28 14 * * ?")
    public void hell(){

        System.out.println("你被执行了");
    }
}
