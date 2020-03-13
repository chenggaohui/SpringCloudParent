package com.HHH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignStarter {
    public static void main(String[] args) {
        SpringApplication.run(FeignStarter.class,args);
    }
}
