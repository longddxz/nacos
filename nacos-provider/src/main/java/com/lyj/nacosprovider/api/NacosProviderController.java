package com.lyj.nacosprovider.api;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@RestController
@RefreshScope
public class NacosProviderController {
    @Value("${spring.application.name}")
    private String springApplicationName;

    @RequestMapping(value = "provider/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String provider(@PathVariable String username, @PathVariable String password){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Map<String, String[]> parameterMap = requestAttributes.getRequest().getParameterMap();
        return "当前服务为：" + springApplicationName + "->params:"+ JSON.toJSONString(username) + "," + password;
    }

    @RequestMapping(value = "provider-map", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String provider(@RequestParam Map<String, Object> params){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Map<String, String[]> parameterMap = requestAttributes.getRequest().getParameterMap();
        return "当前服务为：" + springApplicationName + "->params:"+ JSON.toJSONString(params);
    }

    @RequestMapping(value = "provider-body")
    public String provider(@RequestBody User user){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Map<String, String[]> parameterMap = requestAttributes.getRequest().getParameterMap();
        return "当前服务为：" + springApplicationName + "->params:"+ JSON.toJSONString(user);
    }

    class User{
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
