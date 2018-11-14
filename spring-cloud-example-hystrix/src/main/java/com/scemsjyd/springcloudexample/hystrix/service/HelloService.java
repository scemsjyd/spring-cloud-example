package com.scemsjyd.springcloudexample.hystrix.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "helloService", url = "http://localhost:8001")
@FeignClient(name = "spring-cloud-example-client-01", fallback = HystrixHelloService.class)
public interface HelloService {
    @RequestMapping("/hello")
    String hello();
}
