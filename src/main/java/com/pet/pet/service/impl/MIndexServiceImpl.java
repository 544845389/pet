package com.pet.pet.service.impl;

import com.lorne.core.framework.exception.ServiceException;
import com.pet.pet.api.mobile.vo.AddDataReq;
import com.pet.pet.api.mobile.vo.FindDataReq;
import com.pet.pet.dao.UserDataMapper;
import com.pet.pet.entity.UserData;
import com.pet.pet.model.WxUser;
import com.pet.pet.service.MIndexService;
import com.pet.pet.service.WeiXinService;
import com.pet.pet.utils.BeanConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 侯存路
 * @date 2018/7/27
 * @company codingApi
 * @description
 */
@Service
public class MIndexServiceImpl implements MIndexService {


    @Autowired
    private WeiXinService  weiXinService;

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public boolean addData(AddDataReq addDataReq) throws ServiceException {
        WxUser wxUser =  weiXinService.getOpendIdAndSessionKey(addDataReq.getCode());

        UserData u = userDataMapper.findByOpenId(wxUser.getOpenId());
        if(u != null){
            throw  new ServiceException("您已提交过审核!");
        }

        UserData userData = new UserData();
        BeanConvertUtils.resetBean(UserData.class , userData , addDataReq );
        userData.setOpenid(wxUser.getOpenId());
        userData.setState(0);
        userData.setCreateTime(new Date());

        return userDataMapper.insert(userData) == 1 ? true : false;
    }



    @Override
    public Object findData(FindDataReq findDataReq) throws ServiceException {
        WxUser wxUser =  weiXinService.getOpendIdAndSessionKey(findDataReq.getCode());
        UserData u = userDataMapper.findByOpenId(wxUser.getOpenId());
        if(u == null){
            return "";
        }
        return u;
    }


}
