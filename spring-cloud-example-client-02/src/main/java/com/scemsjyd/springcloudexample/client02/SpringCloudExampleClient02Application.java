package com.scemsjyd.springcloudexample.client02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudExampleClient02Application {
    @RequestMapping("/hello")
    public String home() {
        return "Hello world, client 02";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudExampleClient02Application.class, args);
    }
}
