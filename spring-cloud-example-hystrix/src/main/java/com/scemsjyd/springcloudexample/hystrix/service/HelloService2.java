package com.scemsjyd.springcloudexample.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-cloud-example-client-02")
public interface HelloService2 {
    @RequestMapping("/hello")
    String hello();
}
