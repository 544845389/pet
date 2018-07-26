package com.pet.pet.service;

import com.lorne.core.framework.exception.ServiceException;
import com.pet.pet.model.WxUser;

/**
 * @author 侯存路
 * @date 2018/7/26
 * @company codingApi
 * @description
 */
public interface WeiXinService {



    WxUser getOpendIdAndSessionKey(String code) throws ServiceException;


}
