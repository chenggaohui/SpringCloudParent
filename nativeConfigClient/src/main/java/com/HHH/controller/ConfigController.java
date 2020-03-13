package com.HHH.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class ConfigController {
    @Value("${server.port}")
    String port;
    @Value("${foo}")
    String foo;

    @RequestMapping("/config")
    public String getConfig(){
        return this.port+"--"+this.foo;
    }
}
