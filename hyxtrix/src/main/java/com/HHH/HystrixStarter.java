package com.HHH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//启用数据监控
@EnableCircuitBreaker
//启用hystrix的数据监控的可视化仪表盘
@EnableHystrixDashboard
public class HystrixStarter {
    public static void main(String[] args) {
        SpringApplication.run(HystrixStarter.class,args);
    }
}
