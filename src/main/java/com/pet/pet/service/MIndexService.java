package com.pet.pet.service;

import com.lorne.core.framework.exception.ServiceException;
import com.pet.pet.api.mobile.vo.AddDataReq;
import com.pet.pet.api.mobile.vo.FindDataReq;

/**
 * @author 侯存路
 * @date 2018/7/27
 * @company codingApi
 * @description
 */
public interface MIndexService {


    /**
     * 提交审核资料
     * @param addDataReq
     * @return
     */
    boolean addData(AddDataReq addDataReq) throws ServiceException;

    /**
     * 查看资料
     * @param findDataReq
     * @return
     */
    Object findData(FindDataReq findDataReq) throws ServiceException;
}
