package com.microservice.server.consumer.service.impl;

import com.microservice.server.consumer.service.IFeignService;
import org.springframework.stereotype.Component;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 16:39
 */
@Component
public class FeignServiceHystrix implements IFeignService {

    public String exeFeign(String type) {
        return "调用失败 feign";
    }
}
