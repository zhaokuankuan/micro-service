package com.microservice.server.consumer.service;

import com.microservice.server.consumer.service.impl.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :Mr.kk
 * @date: 2019/10/12 15:06
 */
@FeignClient(value = "PROVIDER-SERVICE",fallback = FeignServiceHystrix.class)
public interface IFeignService {

    @RequestMapping(value = "/provider-service",method = RequestMethod.GET)
    String exeFeign(@RequestParam(value = "type",defaultValue = "local",required = true) String type);

}
