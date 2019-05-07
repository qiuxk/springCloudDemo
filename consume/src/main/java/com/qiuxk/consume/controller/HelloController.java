package com.qiuxk.consume.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiuxk.consume.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;



    @RequestMapping(value = "/hi")
    /**断路器配置，当hi服务无法调用时 则调用hiError方法**/
    @HystrixCommand(fallbackMethod = "hiError")
    public  String hi(@RequestParam String name){
        return helloService.hiService(name);
    }


    @RequestMapping(value = "hiError")
    public  String hiError(String name){
        return "hiError "+ name;
    }
}
