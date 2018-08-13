package com.cetiti.hik.dao;


import com.cetiti.hik.model.UserInfo;
import com.cetiti.hik.paramVO.UserInfoParam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
    public void save(UserInfo userInfo);
    public UserInfo getUserInfo(long id);
    public List<UserInfo> getManager(UserInfoParam param);
}
