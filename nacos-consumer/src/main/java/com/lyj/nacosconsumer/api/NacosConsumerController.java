package com.lyj.nacosconsumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RefreshScope
public class NacosConsumerController {



    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getKind")
    public String[] getKind(@RequestParam String[] kind){
        return kind;
    }

    @RequestMapping("consumer")
    public String consumer(){
        String url = "http://nacos-provider/provider";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("username", "lyj");
        params.add("password", "lyj");
        HttpEntity httpEntity = new HttpEntity<>(params, headers);

        User user = new User();
        user.setUsername("lyj");
        user.setPassword("lyj");
        HttpEntity userHttpEntity = new HttpEntity<>(user, headers);

        //还没调通
        String getResult = restTemplate.getForObject(url+"/lyj/lyj", String.class, "lyj", "lyj");
//        String bodyResult = restTemplate.postForObject(url+"-body", userHttpEntity, String.class);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url+"-body", userHttpEntity, String.class);

        //已经调通
        String mapResult = restTemplate.postForObject(url+"-map", httpEntity, String.class);

        return mapResult;
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
