package com.pet.pet.api.mobile;

import com.lorne.core.framework.exception.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(description = "测试")
@RestController
@RequestMapping("/mini/test")
public class TestController {


    @ApiOperation(value="测试列表")
    @PostMapping("test")
    public Map<String,Object> test(String str) throws ServiceException {
        Map<String,Object> map = new HashMap<>();
        map.put("key","123");
        if(str.equals("1")){
            throw  new ServiceException("测试!");
        }

        if(str.equals("2")){
            int a = 10 / 0;
        }

        return  map;
    }





}
