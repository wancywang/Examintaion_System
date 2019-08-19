package com.system.service.impl;

import com.system.dao.UserLoginMapper;
import com.system.model.UserLogin;
import com.system.model.UserLoginExample;
import com.system.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/2 21:04
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;


    @Override
    public UserLogin findUserByName(String name) throws Exception {
        UserLoginExample userLoginExample = new UserLoginExample();
        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserNameEqualTo(name);
        List<UserLogin> userLoginList = userLoginMapper.selectByExample(userLoginExample);
        return userLoginList.get(0);
    }

    @Override
    public void save(UserLogin userLogin) throws Exception {
        userLoginMapper.insert(userLogin);
    }

    @Override
    public void deleteUserByName(String name) throws Exception {
        UserLoginExample userLoginExample = new UserLoginExample();
        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserNameEqualTo(name);
        userLoginMapper.deleteByExample(userLoginExample);
    }

    @Override
    public void updateUserByName(String name, UserLogin userLogin) throws Exception {
        UserLoginExample userLoginExample = new UserLoginExample();
        UserLoginExample.Criteria criteria = userLoginExample.createCriteria();
        criteria.andUserNameEqualTo(name);
        userLoginMapper.updateByExample(userLogin,userLoginExample);
    }
}
