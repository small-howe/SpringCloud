package com.tangwh;

import com.myRule.HoweRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 消费者
 */
// Ribbn 和 Eureka 整合以后   客户端可以直调用 不用关心ip地址和端口号
@EnableEurekaClient //启动Eureka
@SpringBootApplication
// 在微服务启动的时候 就能加载我们自定一的Ribbon类
@RibbonClient(name = "SRPINGCLOUD-PROVIDER-DEPT",configuration = HoweRule.class) //给那个id 服务自定义负载均衡轮询机制  从而让他生效


public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class, args);
    }
}
