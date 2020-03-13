package com.microservice.server.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 14:49
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ExeRibbon")
    @HystrixCommand(fallbackMethod = "exeRibbonError")
    public Object exeRibbon(){
        return restTemplate.getForObject("http://PROVIDER-SERVICE/provider-service?type=ribbon",String.class);
    }

    String exeRibbonError(){
        return "执行失败 ribbon";
    }
}
