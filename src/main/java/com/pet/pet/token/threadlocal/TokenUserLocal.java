package com.pet.pet.token.threadlocal;


import com.pet.pet.token.ato.ao.TokenUser;

/**
 * @author 侯存路
 * @date 2018/7/5
 * @company codingApi
 * @description
 */
public class TokenUserLocal {

    private final static ThreadLocal<TokenUserLocal> currentLocal = new InheritableThreadLocal<TokenUserLocal>();

    public static TokenUserLocal current() {
        return currentLocal.get();
    }

    public static void setCurrent(TokenUserLocal current) {
        currentLocal.set(current);
    }


    private TokenUser ssoUser;

    public TokenUser getTokenUser() {
        return ssoUser;
    }

    public void setTokenUser(TokenUser tokenUser) {
        this.ssoUser = tokenUser;
    }
}
