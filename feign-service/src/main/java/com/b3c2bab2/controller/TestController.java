package com.b3c2bab2.controller;

import com.b3c2bab2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author b3c2bab2
 * created on 2019/9/26
 */
@RestController
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/count")
    public Integer count() {
        return discoveryClient.getInstances("eureka-server").size();
    }

    @RequestMapping("/hystrix-test/{number}")
    public String hystrixTest(@PathVariable Integer number) throws Exception {
        return testService.hystrixTest(number).get();
    }
}
