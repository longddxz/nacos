package com.lyj.nacos.gateway.zuul.example.ribbon.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 13:54
 */
@RestController
public class RibbonConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "getRibbonConsumer")
    public String getRibbonConsumer(){
        String result = restTemplate.getForObject("http://nacos-gateway-zuul-example-ribbon-provider/getRibbonProviderService", String.class);
        return "调用者：RibbonConsumer， 被调用者：RibbonProviderService，被调用结果为：" + result;
    }
}
