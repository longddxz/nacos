package com.lyj.nacos.gateway.zuul.example.feign.provider.api.impl;

import com.lyj.nacos.gateway.zuul.example.feign.provider.api.FeignApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 14:08
 */
@RestController
public class FeignController implements FeignApi {
    @Value("${spring.application.name}")
    private String springApplicationName;

    @Override
    public String getProvider() {
        return springApplicationName;
    }
}
