package com.microservice.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author :Mr.kk
 * @date: 2019/10/31 16:20
 */
@SpringBootApplication
@EnableZipkinServer
public class MicroServiceSleuthZipkin {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceSleuthZipkin.class,args);
    }
}
