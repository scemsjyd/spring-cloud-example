package com.scemsjyd.springcloudexample.nacosdiscoveryprovider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discovery")
public class ProviderController {

    @RequestMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message) {
        return message;
    }
}
