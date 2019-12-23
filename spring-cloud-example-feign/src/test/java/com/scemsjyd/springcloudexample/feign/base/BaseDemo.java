package com.scemsjyd.springcloudexample.feign.base;

import com.scemsjyd.springcloudexample.feign.service.HelloService;
import feign.Client;
import feign.Feign;
import org.junit.Test;
import org.springframework.cloud.openfeign.FeignClientBuilder;

public class BaseDemo {
    @Test
    public void test() {
        HelloService target = Feign.builder().target(HelloService.class, "http://119.23.62.173:8761/actuator");
        String hello = target.hello();
        System.out.println(hello);


    }
}
