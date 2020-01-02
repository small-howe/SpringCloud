package com.tangwh.controller;

import com.tangwh.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;


    @RequestMapping("/hello")
   public String hello(){
      asyncService.hello(); //停止三秒转圈3秒
      return "ok";
  }

}
