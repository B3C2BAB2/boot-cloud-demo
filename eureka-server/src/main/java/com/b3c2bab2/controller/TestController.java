package com.b3c2bab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/name")
    public String test() {
        return "eureka-server";
    }

    @RequestMapping("/count")
    public Integer count() {
        return discoveryClient.getServices().size();
    }
}