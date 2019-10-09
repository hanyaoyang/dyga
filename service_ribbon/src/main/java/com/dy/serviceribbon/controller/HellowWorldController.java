package com.dy.serviceribbon.controller;

import com.dy.serviceribbon.service.HellowFeiginService;
import com.dy.serviceribbon.service.HellowWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hanyaoyang
 * createdby 2019/9/27
 */
@RestController
public class HellowWorldController {

    @Autowired
    HellowWorldService helloService;

    @Autowired
    HellowFeiginService hellowFeiginService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

    @RequestMapping(value = "/hellowworld",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return hellowFeiginService.hellowWorld(name);
    }
}
