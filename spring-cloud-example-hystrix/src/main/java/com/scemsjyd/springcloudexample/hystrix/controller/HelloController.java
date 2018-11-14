package com.scemsjyd.springcloudexample.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.scemsjyd.springcloudexample.hystrix.service.HelloService;
import com.scemsjyd.springcloudexample.hystrix.service.HelloService2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @Resource
    private HelloService2 helloService2;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping("/hello2")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello2(){
        return helloService2.hello();
    }

    public String helloFallback(){
        return "hello hystrix, hystrix command";
    }

}
