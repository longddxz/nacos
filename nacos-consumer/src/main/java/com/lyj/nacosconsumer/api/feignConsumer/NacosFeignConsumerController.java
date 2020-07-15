package com.lyj.nacosconsumer.api.feignConsumer;

import com.lyj.common.service.feignApi.FeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyj
 * @Date 2019/5/17
 * @Time 17:24
 */
@RestController
@RequestMapping("feignConsumer")
public class NacosFeignConsumerController{

    @Autowired(required = false)
    private FeignApi feignApi;

    @GetMapping("getProvider")
    public String getProvider() {
        return feignApi.getProvider();
    }
}
