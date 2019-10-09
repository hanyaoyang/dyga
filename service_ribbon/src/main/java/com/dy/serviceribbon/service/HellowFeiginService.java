package com.dy.serviceribbon.service;

import com.dy.serviceribbon.service.impl.HellowFeiginServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hanyaoyang
 * createdby 2019/9/27
 */
@FeignClient(value = "service-hi-test", fallback = HellowFeiginServiceImpl.class)
public interface HellowFeiginService {

    /**
     * 测试feigin
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String hellowWorld(String name);
}
