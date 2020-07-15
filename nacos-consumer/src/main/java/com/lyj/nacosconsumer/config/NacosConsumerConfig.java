package com.lyj.nacosconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NacosConsumerConfig {

    @Bean
    @LoadBalanced //ribbon使用
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
