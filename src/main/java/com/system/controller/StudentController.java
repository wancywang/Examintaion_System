package com.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.model.*;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/11 12:03
 */
@Controller
public class StudentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SelectedCourseService selectedCourseService;

    /**
     * 登陆后获取学生id、姓名
     * @return
     */
    @GetMapping("/student/studentInfo")
    @ResponseBody
    public Student getStudentInfo() throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        return studentService.findStudentById((Integer.parseInt(username)));
    }

    /**
     * 根据id获得学生信息
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/student/message/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable Integer id) throws Exception{
       StudentCustom studentCustom = studentService.findStudentById(id);
       return studentCustom;
    }

    /**
     * 根据Id获得该学生课程
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/student/course")
    @ResponseBody
    public String getCourse() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
        System.out.println(studentCustom.getStudentId());
        System.out.println(JSONArray.toJSONString(list));
        return JSONArray.toJSONString(list);
    }
}
