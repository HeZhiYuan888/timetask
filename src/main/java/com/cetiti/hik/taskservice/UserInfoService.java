package com.cetiti.hik.taskservice;

import com.cetiti.hik.dao.UserInfoMapper;
import com.cetiti.hik.model.UserInfo;
import com.cetiti.hik.paramVO.UserInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoDao;
    public List<UserInfo> getManager(UserInfoParam param) {
        return userInfoDao.getManager(param);
    }
}
