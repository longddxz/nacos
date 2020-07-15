package com.lyj.nacos.gateway.zuul.config;

import com.lyj.nacos.gateway.zuul.filter.GateWayZuulFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 11:37
 */
@Configuration
@ConditionalOnProperty(name = "gateway.enable", havingValue = "true")//有该属性才生效
public class GateWayZuulConfig {

    @Bean
    public GateWayZuulFilter gateWayZuulFilter(){
        return new GateWayZuulFilter();
    }
}
