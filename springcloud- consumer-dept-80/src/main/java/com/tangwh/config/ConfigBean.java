package com.tangwh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //相当于我们Spring 中的applicationContexe.xml
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate(){

        return  new RestTemplate();
    }
}
