package com.system.service;

import com.system.model.UserLogin;

/**
 * @Author: Alex
 * @Date: 2019/7/2 0:08
 */
public interface UserLoginService {

    /**
     * 根据名字查找用户
     * @param name
     * @return 用户信息
     * @throws Exception
     */
    UserLogin findUserByName(String name) throws Exception;

    /**
     * 保存用户信息
     * @param userLogin
     * @throws Exception
     */
    void save(UserLogin userLogin) throws Exception;

    /**
     * 根据名字删除用户
     * @param name
     * @throws Exception
     */
    void deleteUserByName(String name) throws Exception;

    /**
     * 根据用户名更新信息
     * @param name
     * @param userLogin
     * @throws Exception
     */
    void updateUserByName(String name,UserLogin userLogin) throws Exception;
}
