package com.microservice.hystrix.databoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author :Mr.kk
 * @date: 2019/11/5 14:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class HystrixDataBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDataBoardApplication.class,args);
    }
}
