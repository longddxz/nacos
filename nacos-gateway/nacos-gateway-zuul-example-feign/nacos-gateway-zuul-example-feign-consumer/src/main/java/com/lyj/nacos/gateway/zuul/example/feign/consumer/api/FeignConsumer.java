package com.lyj.nacos.gateway.zuul.example.feign.consumer.api;

import com.lyj.nacos.gateway.zuul.example.feign.provider.api.FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidatorFactory;

/**
 * @author lyj
 * @Date 2019/5/28
 * @Time 14:13
 */
@RestController
public class FeignConsumer {

    @Autowired
    private FeignApi feignApi;

    @GetMapping(value = "getFeignConsumer")
    public String getFeignConsumer(){
        String provider = feignApi.getProvider();
        return "调用者：FeignConsumer， 被调用者：FeignProvider，被调用结果为：" + provider;
    }
}
