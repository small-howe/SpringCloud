package com.tangwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供者
 */
@EnableEurekaClient //开启Eureka 客户端 开启后 会自动注册到EurekaServer
@SpringBootApplication
@EnableDiscoveryClient //服务发现
//@EnableCircuitBreaker //添加对熔断的支持
public class SpringcloudProvider80001Hystirx {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider80001Hystirx.class, args);
    }

}
