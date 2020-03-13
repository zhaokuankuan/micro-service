package com.microservice.server.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 13:58
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@RefreshScope
public class MicroServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerApplication.class,args);
    }
}
