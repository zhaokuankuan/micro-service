package com.microservice.server.business.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :Mr.kk
 * @date: 2019/11/4 17:35
 */
@FeignClient(value = "PROVIDER-SERVICE",fallback = BusinessServiceHystrix.class)
public interface BusinessService {

    @GetMapping(value = "/provider-service")
    public String exeBusinessService(@RequestParam(value = "type",defaultValue = "local",required = true) String type);

}
