package com.scemsjyd.springcloudexample.ribbon.controller;

import com.scemsjyd.springcloudexample.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(){
        return helloService.hi();
    }
}
