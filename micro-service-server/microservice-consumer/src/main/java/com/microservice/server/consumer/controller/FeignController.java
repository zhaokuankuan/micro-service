package com.microservice.server.consumer.controller;

import com.microservice.server.consumer.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 15:04
 */
@RestController
public class FeignController {

    @Autowired
    private IFeignService iFeignService;

    @Value("${congigValue}")
    private String configValue;





    @GetMapping("/exeFeign")
    public String exeFeign(){
        return iFeignService.exeFeign("feign");
    }

    @GetMapping("/testConfig")
    public Object testConfig(){
        return configValue;
    }

}
