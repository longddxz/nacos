package com.lyj.nacosconsumer.utils;

import com.google.common.base.CaseFormat;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将map转换为对应bean
 */
public class ConvertUtil {
    private final static Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    public static <T> T convertMethod(Map<String, Object> map, Class<T> clazz) {
        T object = null;
        if (map == null) {
            return null;
        }
        CaseInsensitiveMap<String, Object> caseInsensitiveMap = new CaseInsensitiveMap<>(map);
        try {
            object = clazz.getDeclaredConstructor().newInstance();
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(clazz);
            for (int i = 0; i < propertyDescriptors.length; i++) {
                try {
                    PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                    String propertyDescriptorName = propertyDescriptor.getName();
                    if (propertyDescriptorName.equals("class")) {
                        continue;
                    }
                    if (caseInsensitiveMap.containsKey(propertyDescriptorName)) {
                        invoke(object, propertyDescriptor, caseInsensitiveMap.get(propertyDescriptorName));
                        continue;
                    }
                    String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, propertyDescriptorName);
                    if (caseInsensitiveMap.containsKey(name)) {
                        invoke(object, propertyDescriptor, caseInsensitiveMap.get(name));
                        continue;
                    }
                    name = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, propertyDescriptorName);
                    if (caseInsensitiveMap.containsKey(name)) {
                        invoke(object, propertyDescriptor, caseInsensitiveMap.get(name));
                        continue;
                    }
                } catch (IllegalArgumentException e) {
                    logger.warn("", e);
                } catch (Exception e) {
                    logger.error("", e);
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }
        return object;
    }

    private static void invoke(Object object, PropertyDescriptor propertyDescriptor, Object value) {
        try {
            if (propertyDescriptor.getWriteMethod() != null) {
                propertyDescriptor.getWriteMethod().invoke(object, value);
            }
        } catch (Exception e) {
            logger.error("property:{},value:{}", propertyDescriptor.getName(), value, e);
        }
    }

    static class User{
        private String username;
        private String password;
        private List<String> hobbies;
        private Map<String, Object> keyValue;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<String> getHobbies() {
            return hobbies;
        }

        public void setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
        }

        public Map<String, Object> getKeyValue() {
            return keyValue;
        }

        public void setKeyValue(Map<String, Object> keyValue) {
            this.keyValue = keyValue;
        }


    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("basketball");
        hobbies.add("baseball");
        hobbies.add("bingbang");

        Map<String, Object> map = new HashMap<>();
        map.put("key", "keyValue");

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", "lyj");
        userMap.put("password", "lyj111");
        userMap.put("hobbies", hobbies);
        userMap.put("keyValue", map);

        System.out.println(convertMethod(userMap, User.class));
    }
}
