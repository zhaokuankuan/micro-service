package com.microservice.server.business.service;

import org.springframework.stereotype.Component;

/**
 * @author :Mr.kk
 * @date: 2019/11/4 17:40
 */
@Component
public class BusinessServiceHystrix implements BusinessService {
    @Override
    public String exeBusinessService(String type) {
        return "I AM ERROR" + type;
    }
}
