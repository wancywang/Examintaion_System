package com.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.dao.CollegeMapper;
import com.system.model.College;
import com.system.model.CollegeExample;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/6/28 12:34
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public College queryById(int collegeId) throws Exception {
        return collegeMapper.selectByPrimaryKey(collegeId);
    }

    @Override
    public void insertById(College record) throws Exception {
        collegeMapper.insert(record);
    }

    @Override
    public List<College> queryAllCollege() throws Exception {
        return collegeMapper.selectByExample(null);
    }
}
