package com.system.controller;

import com.system.model.Notice;
import com.system.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/8/19 11:39
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice/list")
    @ResponseBody
    public List<Notice> getNoticeList(){
        List<Notice> noticeList = noticeService.queryAll();
        System.out.println(noticeList.toString());
        return noticeList;
    }
}
