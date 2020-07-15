package com.lyj.nacosconfig.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController {
    @Value("${configValue: true}")
    private boolean configValue;

    @GetMapping(value = "getConfigValue", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConfigValue(){
        return String.valueOf(configValue);
    }
}
