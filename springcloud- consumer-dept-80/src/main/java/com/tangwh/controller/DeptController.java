package com.tangwh.controller;

import com.tangwh.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者
 */
@RestController

public class DeptController {

    // 理解 消费者会不会有service 层
    //RestTemplate.... 供我们直接调用  注册在Spring中
    //参数(url，实体：map.Class<T>,reposeType)
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程Http 服务的方法 简单的restful 服务模板

    //Ribbon 我们这里注册的地址应该是一个便令 我们通过服务命来访问
  //  private static final String REST_URL_PREFIX = "http://localhost:8001";
   private static final String REST_URL_PREFIX = "http://SRPINGCLOUD-PROVIDER-DEPT";



    //调用 远程服务 提供者的接口 http://localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        // 由于 提供者 定义的为get 请求 所以返回 get  url 地址是提供者的url 实体是参数  最后返回类型
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        System.out.println("消费者传进来的:"+dept);

        // 提供者提供的那种提交方法 就用哪种
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add/",dept,Boolean.class);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);

    }

}
