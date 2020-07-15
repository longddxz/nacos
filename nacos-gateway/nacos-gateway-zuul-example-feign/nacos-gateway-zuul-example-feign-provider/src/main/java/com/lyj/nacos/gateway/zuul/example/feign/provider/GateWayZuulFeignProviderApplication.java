package com.lyj.nacos.gateway.zuul.example.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 14:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayZuulFeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulFeignProviderApplication.class, args);
    }
}
