package com.tangwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启监控页面

public class DeptConsumerListening {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerListening.class, args);
    }
}
