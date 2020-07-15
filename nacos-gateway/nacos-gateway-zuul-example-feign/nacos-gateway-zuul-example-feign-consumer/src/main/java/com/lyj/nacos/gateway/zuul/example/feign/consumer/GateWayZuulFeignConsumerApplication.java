package com.lyj.nacos.gateway.zuul.example.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 14:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages =
        "com.lyj.nacos.gateway.zuul.example.feign.provider.api")//使feignApi类生效
public class GateWayZuulFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulFeignConsumerApplication.class, args);
    }
}
