package com.lyj.nacos.gateway.zuul.example.feign.provider.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 14:05
 */
@FeignClient(name = "${feignServer.application.name}")
public interface FeignApi {
    @GetMapping(value = "getProvider")
    String getProvider();
}
