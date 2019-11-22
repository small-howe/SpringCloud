package com.tangwh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 提供者
 */
@EnableEurekaClient //开启Eureka 客户端 开启后 会自动注册到EurekaServer
@SpringBootApplication
public class SpringcloudProvider01Dept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider01Dept8001Application.class, args);
    }

}
