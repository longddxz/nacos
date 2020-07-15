package com.lyj.nacos.gateway.zuul.example.ribbon.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 13:50
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayZuulRibbonConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulRibbonConsumerApplication.class, args);
    }
}
