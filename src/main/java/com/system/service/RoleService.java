package com.system.service;

import com.system.model.Role;

/**
 * @Author: Alex
 * @Date: 2019/7/15 23:46
 */
public interface RoleService {

    /**
     * 角色赋予
     * @param id
     * @return
     * @throws Exception
     */
    Role findById(Integer id) throws Exception;
}
