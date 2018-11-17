package com.scemsjyd.springcloudexample.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "helloService", url = "http://localhost:8001")
@FeignClient(name = "spring-cloud-example-client-01")
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
