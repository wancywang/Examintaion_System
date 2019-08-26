package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.model.CourseCustom;
import com.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Alex
 * @Date: 2019/8/25 13:34
 */
@RequestMapping("/course")
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 我的课程
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/mycourse",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getAllCourse(@RequestParam(value = "page",defaultValue = "1")Integer page) throws Exception{
        PageHelper.startPage(page,10);
        try {
            List<CourseCustom> courseCustomList = courseService.findAllCourse();
            PageInfo<CourseCustom> pageInfo = new PageInfo<>(courseCustomList);
            Map<String,Object> results = new HashMap<>();
            results.put("code",200);
            results.put("msg","");
            results.put("count",pageInfo.getTotal());
            results.put("data",pageInfo.getList());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build().toString();
        }
        return null;
    }

}
