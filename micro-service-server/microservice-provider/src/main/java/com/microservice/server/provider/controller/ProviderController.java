package com.microservice.server.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 14:50
 */
@RestController
@Slf4j
public class ProviderController {

    @GetMapping("/provider-service")
    public String providerService(@RequestParam(value = "type",defaultValue = "local",required = true) String type){
        log.info("{}调用成功",type);
        return type + "调用成功";
    }

}
