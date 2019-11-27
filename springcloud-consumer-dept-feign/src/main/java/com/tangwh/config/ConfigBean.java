package com.tangwh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //相当于我们Spring 中的applicationContexe.xml
public class ConfigBean {

    @Bean
    //配置负载均衡实现RestTemplate
    //IRule
    // 访问机制:
    //RoundRobinRule :默认的
     //RandomRule : 随机的访问
    //AvailabilityFilteringRule : 会先过滤掉 跳闸，访问故障的服务 对剩下的进行访问
    //RetryRule : 会按照轮询获取服务 如果服务获取失败 则会在指定的时间内进行重试
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){

        return  new RestTemplate();
    }



}
