package com.scemsjyd.springcloudexample.turbine.service;

import org.springframework.stereotype.Service;

@Service
public class HystrixHelloService implements HelloService {
    @Override
    public String hello() {
        return "hello hystrix";
    }
}
