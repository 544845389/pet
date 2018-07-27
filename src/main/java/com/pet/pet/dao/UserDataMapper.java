package com.pet.pet.dao;

import com.codingapi.mybaties.mapper.BaseMapper;
import com.pet.pet.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 侯存路
 * @date 2018/7/27
 * @company codingApi
 * @description
 */
@Mapper
public interface UserDataMapper extends BaseMapper<UserData> {



    @Select(" SELECT * FROM `yqxx` WHERE openid = #{openId} ")
    UserData findByOpenId(String openId);


}
