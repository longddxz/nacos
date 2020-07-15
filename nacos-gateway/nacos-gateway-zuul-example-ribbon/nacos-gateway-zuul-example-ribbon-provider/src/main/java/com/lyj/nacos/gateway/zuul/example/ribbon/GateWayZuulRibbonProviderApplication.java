package com.lyj.nacos.gateway.zuul.example.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 12:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayZuulRibbonProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulRibbonProviderApplication.class, args);
    }
}
