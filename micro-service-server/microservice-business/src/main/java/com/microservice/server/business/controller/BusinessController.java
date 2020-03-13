package com.microservice.server.business.controller;

import com.microservice.server.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2019/11/4 17:32
 */
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/exeBusinessService")
    public Object exeBusinessService(){
        return businessService.exeBusinessService("business");
    }
}
