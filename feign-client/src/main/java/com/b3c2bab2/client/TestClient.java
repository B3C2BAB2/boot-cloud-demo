package com.b3c2bab2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author b3c2bab2
 * created on 2019/9/30
 */
@FeignClient("feign-service")
public interface TestClient {
    @RequestMapping(value = "/service/hystrix-test/{number}", method = RequestMethod.GET)
    String hystrixTest(@PathVariable Integer number) throws Exception;
}
