package com.system.service;

import com.system.model.College;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.json.Json;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/6/28 11:55
 */
public interface CollegeService {

    /**
     * 根据id查找院系
     * @param collegeId
     * @return
     * @throws Exception
     */
    College queryById(int collegeId) throws Exception;

    /**
     * 新增院系
     * @param record
     * @return
     * @throws Exception
     */
    void insertById(College record) throws Exception;

    /**
     * 查找所有院系
     * @return
     * @throws Exception
     */
    List<College> queryAllCollege() throws Exception;

}
