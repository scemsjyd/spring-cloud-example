package com.scemsjyd.springcloudexample.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;


    public String hi() {
        String greeting = this.restTemplate.getForObject("http://helloRibbonClient/hello", String.class);
        return String.format("%s", greeting);
    }
}
