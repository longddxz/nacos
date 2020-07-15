package com.lyj.nacos.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 11:24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy //支持网关路由
public class GateWayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulApplication.class, args);
    }
}
