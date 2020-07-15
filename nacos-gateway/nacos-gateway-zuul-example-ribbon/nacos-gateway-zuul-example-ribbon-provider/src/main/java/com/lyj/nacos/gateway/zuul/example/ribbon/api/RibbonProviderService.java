package com.lyj.nacos.gateway.zuul.example.ribbon.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 13:47
 */
@RestController
public class RibbonProviderService {
    @Value("${spring.application.name}")
    private String springApplicationName;

    @GetMapping(value = "getRibbonProviderService")
    public String getRibbonProviderService(){
        return springApplicationName;
    }
}
