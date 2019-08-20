package com.system.service.impl;

import com.system.dao.NoticeMapper;
import com.system.model.Notice;
import com.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/8/19 20:07
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> queryAll() {
        List<Notice> noticeList = noticeMapper.selectByExample(null);
        return noticeList;
    }
}
