package com.tangwh.controller;

import com.tangwh.pojo.Dept;
import com.tangwh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供RestFul服务
 */

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;


    // 获取 Eureka 一些信息
    private DiscoveryClient  discoveryClient;

    @GetMapping("/")
    public String getIndex(){
   return "bootDev"+bootDev;
    }

    @Value("${spring.datasource.url}")
    public String bootDev;

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        System.out.println("传进来的值为"+dept);
        return deptService.addDept(dept);
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        List<Dept> depts = deptService.queryAll();

        for (Dept dept : depts) {
            System.out.println(dept);
        }
        return depts;
    }


    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        System.out.println("传进来的id:"+id);
        return deptService.queryById(id);
    }


    /**
     * 注册进来的微服务 获取一些消息
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
            //获取微服务列表的清单
        System.out.println("请求已经过去");
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>services:"+services);

        //得到一个具体一个微服务信息 通过具体的微服务id获取 也就是SpringApplication name
        List<ServiceInstance> instances = discoveryClient.getInstances("SRPINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                            instance.getUri()+"\t"+
                            instance.getServiceId()



            );
        }

        return this.discoveryClient;
    }
}
