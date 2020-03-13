package com.microservice.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 17:28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MicroServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceZuulApplication.class,args);
    }
}
