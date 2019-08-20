package com.system.service;

import com.system.model.Notice;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/8/19 19:52
 */
public interface NoticeService {

    /**
     *公告展示
     * @return
     */
    List<Notice> queryAll();
}
