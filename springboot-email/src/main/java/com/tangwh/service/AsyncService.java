package com.tangwh.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *异步任务 前台已经展示Ok  后台3秒后 执行
 */
@Service
public class AsyncService {

    // 告诉Spring  这是一个异步的方法  需要在SpringBoot 的main开启异步注解功能
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理");
    }
}
