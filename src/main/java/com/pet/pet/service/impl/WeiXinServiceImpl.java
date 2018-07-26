package com.pet.pet.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.http.HttpUtils;
import com.pet.pet.config.WeiXinConfig;
import com.pet.pet.model.WxUser;
import com.pet.pet.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 侯存路
 * @date 2018/7/26
 * @company codingApi
 * @description
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {


    @Autowired
    private WeiXinConfig weiXinConfig;


    private static final String JSCODE_SESSION_API = "https://api.weixin.qq.com/sns/jscode2session";

    /**
     * 获取微信用户的信息
     *
     * @param
     * @param
     * @param code
     * @return
     */
    @Override
    public  WxUser getOpendIdAndSessionKey(String code) throws ServiceException {
        WxUser userKey = null;
        try {
            String url =
                    JSCODE_SESSION_API
                            + "?appid="
                            + weiXinConfig.getAppId()
                            + "&secret="
                            + weiXinConfig.getAppSecret()
                            + "&js_code="
                            + code
                            + "&grant_type=authorization_code";
            String res = HttpUtils.get(url);
            userKey = JSONObject.parseObject(res, WxUser.class);
            if (StringUtils.isEmpty(userKey.getOpenId()) || StringUtils.isEmpty(userKey.getSessionKey())) {
                throw new ServiceException("微信用户信息获取失败！");
            }
        } catch (Exception e) {
            throw new ServiceException("获取用信息失败");
        }
        return userKey;
    }


}
