package com.tangwh.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tangwh.pojo.Dept;
import com.tangwh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供RestFul服务
 */

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;



    @GetMapping("/dept/get/{id}")
   @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Integer id){
        Dept dept = deptService.queryById(id);
        if (dept ==null){
            throw  new RuntimeException("id=>"+id+"用户不存在");
        }
      return dept;
    }

    /**
     * 备选方案
     * @param id
     * @return
     */

    public Dept hystrixGet(@PathVariable("id") Integer id){
        return new Dept()
                .setDept_id(id)
                .setDept_name("id=>"+id+"用户不存在 null --@hystrix")
                .setDb_source("no this database in musql");
    }

}
