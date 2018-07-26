package com.pet.pet.token.interceptor;



import com.pet.pet.token.ato.ao.TokenUser;
import com.pet.pet.token.service.TokenService;
import com.pet.pet.token.threadlocal.TokenUserLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 侯存路
 * @date 2018/7/5
 * @company codingApi
 * @description
 */
public class TokenHandlerInterceptor implements HandlerInterceptor {


    private final  static Logger logger = LoggerFactory.getLogger(TokenHandlerInterceptor.class);


    public TokenHandlerInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private TokenService tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getParameter("token");
        logger.info("token->"+token);

        if(!StringUtils.isEmpty(token)){
            TokenUser tokenUser =  tokenService.getTokenUserByToken(token);
            TokenUserLocal ssoUserLocal = new TokenUserLocal();
            ssoUserLocal.setTokenUser(tokenUser);
            TokenUserLocal.setCurrent(ssoUserLocal);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        TokenUserLocal.setCurrent(null);
    }
}
