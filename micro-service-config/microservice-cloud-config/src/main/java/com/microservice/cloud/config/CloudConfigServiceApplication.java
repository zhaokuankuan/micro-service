package com.microservice.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * springcloud-config分布式配置中心
 * @author :Mr.kk
 * @date: 2019/10/21 14:14
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServiceApplication.class,args);
    }
}
