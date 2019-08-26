package com.system.service;

import com.system.model.CourseCustom;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/11 20:34
 */
public interface CourseService {

    /**
     * 根据id更新课程信息
     * @param id
     * @param courseCustom
     * @throws Exception
     */
    void updateById(Integer id, CourseCustom courseCustom) throws Exception;

    /**
     * 根据id删除课程信息
     * @param id
     * @return
     * @throws Exception
     */
    Boolean removeById(Integer id) throws Exception;

    /**
     * 获取分页查询课程信息
     * @param courseCustom
     * @return
     * @throws Exception
     */
    Boolean save(CourseCustom courseCustom) throws Exception;

    /**
     * 找出学生选修课程
     * 根据学生id
     * @param studentId
     * @return
     * @throws Exception
     */
    List<CourseCustom> findStudentAndSelectCourseListById(Integer studentId) throws Exception;

    /**
     * 获取课程总数
     * @return
     * @throws Exception
     */
    int getCountCourse() throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    CourseCustom findById(Integer id) throws Exception;

    /**
     * 根据名字查询
     * @param name
     * @return
     * @throws Exception
     */
    List<CourseCustom> findByName(String name) throws Exception;

    /**
     * 根据教师id查找课程
     * @param id
     * @return
     * @throws Exception
     */
    List<CourseCustom> findByTeacherId(Integer id) throws Exception;

    List<CourseCustom> findAllCourse();

}
