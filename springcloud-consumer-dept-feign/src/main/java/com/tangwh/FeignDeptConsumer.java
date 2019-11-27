package com.tangwh;

import com.tangwh.service.DeptClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 消费者
 */
// Ribbn 和 Eureka 整合以后   客户端可以直调用 不用关心ip地址和端口号

@EnableEurekaClient //启动Eureka
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tangwh"}) //开启Feign 并扫描包
public class FeignDeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer.class, args);
    }
}
