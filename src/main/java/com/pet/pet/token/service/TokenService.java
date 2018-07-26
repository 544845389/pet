package com.pet.pet.token.service;


import com.pet.pet.token.ato.ao.TokenUser;

/**
 * @author 侯存路
 * @date 2018/7/5
 * @company codingApi
 * @description
 */
public interface TokenService {

    /**
     * 通过token 获取用户信息，并延长时间
     *
     * @param token
     * @return
     */
    TokenUser getTokenUserByToken(String token);
}
