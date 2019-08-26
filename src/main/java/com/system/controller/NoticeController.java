package com.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.model.Notice;
import com.system.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Alex
 * @Date: 2019/8/19 11:39
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    /**
     * 公告分页查询
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/notices",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getNotice(@RequestParam(value = "page",defaultValue = "1")Integer page) throws Exception{
        PageHelper.startPage(page,5);
        List<Notice> noticeList = noticeService.queryAll();
        try {
            PageInfo<Notice> pageInfo = new PageInfo(noticeList,5);
            Map<String, Object> results = new HashMap<>();
            results.put("count", "5");
            results.put("code", "200");
            results.put("msg", "获取下一页成功");
            results.put("data", pageInfo.getList());
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(results);
            return jsonStr;
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build().toString();
        }
    }
}
