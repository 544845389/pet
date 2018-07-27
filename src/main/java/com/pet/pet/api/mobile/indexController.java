package com.pet.pet.api.mobile;

import com.lorne.core.framework.exception.ServiceException;
import com.pet.pet.api.mobile.vo.AddDataReq;
import com.pet.pet.api.mobile.vo.FindDataReq;
import com.pet.pet.service.MIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 侯存路
 * @date 2018/7/27
 * @company codingApi
 * @description
 */
@Api(description = "首页")
@RestController
@RequestMapping("/mini/index")
public class indexController {



    @Autowired
    private MIndexService  mIndexService;


    @ApiOperation(value="添加资料")
    @PostMapping("addData")
    public boolean addData(@RequestBody AddDataReq addDataReq) throws ServiceException {
      return  mIndexService.addData(addDataReq);
    }



    @ApiOperation(value="查看资料")
    @PostMapping("findData")
    public Object findData(@RequestBody FindDataReq findDataReq) throws ServiceException {
        return  mIndexService.findData(findDataReq);
    }



}
