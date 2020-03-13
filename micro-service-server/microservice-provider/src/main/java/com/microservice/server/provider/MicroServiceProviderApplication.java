package com.microservice.server.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 13:44
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class MicroServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProviderApplication.class,args);
    }
}
