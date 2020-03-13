package com.HHH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableAutoConfiguration
public class ZuulStarter {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStarter.class,args);
    }
}
