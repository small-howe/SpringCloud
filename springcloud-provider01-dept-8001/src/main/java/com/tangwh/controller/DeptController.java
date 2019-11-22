package com.tangwh.controller;

import com.tangwh.pojo.Dept;
import com.tangwh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/")
    public String getIndex(){

        return "Hellp Sring";
    }

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


}
