package com.baidu.unbiz.dsp.archtype.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhangxu
 */
@Component
public class AppConfig2 {

    @Value("${key}")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
