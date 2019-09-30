package com.b3c2bab2.bootcloudclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author b3c2bab2
 * created on 2019/9/26
 */
@Service
public class TestService {
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public Future<String> hystrixTest(final Integer number){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return Integer.toString(1 / number);
            }
        };
    }

    public String hystrixFallback(final Integer number) {
        return "hystrix";
    }
}
