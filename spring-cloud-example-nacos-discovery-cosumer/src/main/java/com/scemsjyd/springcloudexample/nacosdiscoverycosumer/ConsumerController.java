package com.scemsjyd.springcloudexample.nacosdiscoverycosumer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/discovery")
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message) {
        return restTemplate.getForObject("http://nacos-discovery-provider/discovery/echo/" + message, String.class);
    }
}
