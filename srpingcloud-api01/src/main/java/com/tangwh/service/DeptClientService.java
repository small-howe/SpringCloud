package com.tangwh.service;

import com.tangwh.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient(value = "srpingcloud-provider-dept")//只要写这个注解 就可以被服务直接调用  value 代表的是服务名
@Component
public interface DeptClientService {


    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);






}
