package com.scemsjyd.springcloudexampleclient.feign.controller;

import com.scemsjyd.springcloudexampleclient.feign.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

}
