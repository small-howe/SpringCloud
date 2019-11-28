package com.tangwh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {


    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String EurekaServer;

    @Value("${server.port}")
    private  String port;


    @RequestMapping("/config")
    public String getConfig(){

        return "applicationName"+applicationName+
                "EurekaServer"+EurekaServer+
                "port"+port;
    }
}
