package com.b3c2bab2;

import com.b3c2bab2.filter.SimpleZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author b3c2bab2
 * created on 2019/10/8
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication {
    @Bean
    public SimpleZuulFilter getSimpleZuulFilter() {
        return new SimpleZuulFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
