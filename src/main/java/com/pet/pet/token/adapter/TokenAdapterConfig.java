package com.pet.pet.token.adapter;



import com.pet.pet.token.interceptor.TokenHandlerInterceptor;
import com.pet.pet.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 侯存路
 * @date 2018/7/5
 * @company codingApi
 * @description
 */
@Component
public class TokenAdapterConfig extends WebMvcConfigurerAdapter{


    @Autowired
    private TokenService tokenService;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenHandlerInterceptor(tokenService));
    }

}
