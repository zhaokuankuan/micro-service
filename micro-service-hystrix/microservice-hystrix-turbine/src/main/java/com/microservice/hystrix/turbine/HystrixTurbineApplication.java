package com.microservice.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * hystrix turbine 监控
 * @author :Mr.kk
 * @date: 2019/10/31 17:42
 */
@SpringBootApplication
@EnableDiscoveryClient
//熔断超时机制
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class,args);

    }

}
