package com.system.service.impl;

import com.system.dao.RoleMapper;
import com.system.model.Role;
import com.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Alex
 * @Date: 2019/7/15 23:48
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
