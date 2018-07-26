package com.pet.pet.token.service.impl;

import com.pet.pet.token.ato.ao.TokenUser;
import com.pet.pet.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/7/5
 * @company codingApi
 * @description
 */
@Service
public class TokenServiceImpl implements TokenService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public TokenUser getTokenUserByToken(String token) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String userId = operations.get(token);
        // todo 获取用户id
        TokenUser tokenUser = new TokenUser();
        tokenUser.setUserId(userId);
        return  tokenUser;
    }
}
