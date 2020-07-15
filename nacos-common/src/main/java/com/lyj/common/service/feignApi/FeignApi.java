package com.lyj.common.service.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lyj
 * @Date 2019/5/17
 * @Time 17:04
 */
@FeignClient(name = "nacos-provider")
public interface FeignApi {
    @GetMapping(value = "getProvider")
    String getProvider();
}
