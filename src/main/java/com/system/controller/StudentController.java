package com.system.controller;

import com.system.model.CourseCustom;
import com.system.model.SelectedCourse;
import com.system.model.SelectedCourseCustom;
import com.system.model.Student;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/student/{studentId}")
    @ResponseBody
    public Student getStudentById(@PathVariable Integer studentId) throws Exception{
        Student student = studentService.findStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "/student/getCourse")
    @ResponseBody
    public String getSelectedCourse(@PathVariable Integer id) throws Exception{
        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseId(id);
        selectedCourseCustom.setStudentId(id);
        return selectedCourseCustom.toString();
    }

}
