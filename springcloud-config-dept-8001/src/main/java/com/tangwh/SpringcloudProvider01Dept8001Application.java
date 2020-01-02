package com.tangwh;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 提供者
 */
@EnableEurekaClient //开启Eureka 客户端 开启后 会自动注册到EurekaServer
@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class SpringcloudProvider01Dept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider01Dept8001Application.class, args);
    }

    /**
     * 配合Hystrix 监控使用
     * @return
     */
    @Bean
    // 添加一个Servlet
    public ServletRegistrationBean hystrixMetricsStreamServlet(){

        ServletRegistrationBean registrationBea = new ServletRegistrationBean(new HystrixMetricsStreamServlet());

        registrationBea.addUrlMappings("/actuator/hystrix.stream");
        return registrationBea;
    }
}
