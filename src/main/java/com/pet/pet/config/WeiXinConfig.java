package com.pet.pet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 侯存路
 * @date 2018/7/26
 * @company codingApi
 * @description
 */
@Component
@ConfigurationProperties(prefix="weixin")
public class WeiXinConfig {


    private String appId;


    private String appSecret;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }


}
