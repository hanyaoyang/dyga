package com.dy.serviceribbon.service.impl;

import com.dy.serviceribbon.service.HellowWorldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hanyaoyang
 * createdby 2019/9/27
 */
@Service
public class HellowWorldServiceImpl implements HellowWorldService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://CONFIG-CLIENT/hello?name="+name,String.class);
    }

    /**
     * ribbon断路器配置
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hello,"+name+",check your server";
    }

}
