package com.b3c2bab2.controller;

import com.b3c2bab2.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author b3c2bab2
 * created on 2019/10/8
 */
@RestController
public class TestController {
    @Autowired
    private TestClient testClient;

    @RequestMapping(value = "/hystrix-test/{number}", method = RequestMethod.GET)
    public String hystrixTest(@PathVariable Integer number) throws Exception {
        return testClient.hystrixTest(number);
    }
}
