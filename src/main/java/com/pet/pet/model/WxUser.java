package com.pet.pet.model;

/**
 * @author 侯存路
 * @date 2018/7/26
 * @company codingApi
 * @description
 */
public class WxUser {

    private String openId;

    private String sessionKey;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

}
