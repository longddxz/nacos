package com.lyj.nacos.gateway.zuul.example.ribbon.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 13:56
 */
@Configuration
public class RibbonConsumerConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
