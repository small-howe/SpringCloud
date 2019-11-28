package com.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HoweRule {


    @Bean
    public IRule myIrule(){
        return new RoundRobinRule(); // 默认是轮询 现在是我自己定义的
    }
}
