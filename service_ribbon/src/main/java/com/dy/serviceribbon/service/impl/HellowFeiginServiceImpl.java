package com.dy.serviceribbon.service.impl;

import com.dy.serviceribbon.service.HellowFeiginService;
import org.springframework.stereotype.Service;

/**
 * @author hanyaoyang
 * createdby 2019/9/27
 */
@Service
public class HellowFeiginServiceImpl implements HellowFeiginService {

    @Override
    public String hellowWorld(String name) {
        return "sorry "+name;
    }
}
