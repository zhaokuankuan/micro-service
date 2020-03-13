package com.microservice.register.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2019/10/9 18:08
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }

    @GetMapping("/test")
    public Object test(){
        return "test";
    }

}
