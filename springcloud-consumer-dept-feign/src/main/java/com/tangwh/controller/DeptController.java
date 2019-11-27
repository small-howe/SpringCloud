package com.tangwh.controller;

import com.tangwh.pojo.Dept;
import com.tangwh.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     DeptClientService service = null;


    //调用 远程服务 提供者的接口 http://localhost:8001/dept/list
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
       return this.service.queryById(id);
    }


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
       return this.service.addDept(dept);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){

        return  service.queryAll();

    }



}
