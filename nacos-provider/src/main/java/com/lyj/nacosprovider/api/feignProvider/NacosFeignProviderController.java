package com.lyj.nacosprovider.api.feignProvider;

import com.lyj.common.service.feignApi.FeignApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyj
 * @Date 2019/5/17
 * @Time 17:17
 */
@RestController
public class NacosFeignProviderController implements FeignApi {

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Override
    public String getProvider() {
        return springApplicationName + "-> FeingApiImpl-> getProvider ->haha successful!!!";
    }
}
