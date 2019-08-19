package com.system.service;

import com.system.model.Student;
import com.system.model.StudentCustom;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/2 22:08
 */
public interface StudentService {

    /**
     * 根据id个更新学生信息
     * @param id
     * @param studentCustom
     * @throws Exception
     */
    void updateByStudentById(Integer id, StudentCustom studentCustom) throws Exception;

    /**
     * 根据id删除学生信息
     * @param id
     * @throws Exception
     */
    void removeStudentById(Integer id) throws Exception;

    List<StudentCustom> findByPaging(Integer toPageNo) throws Exception;

    /**
     * 保存学生信息
     * @param studentCustom
     * @return
     * @throws Exception
     */
    Boolean save(StudentCustom studentCustom) throws Exception;

    /**
     * 获取学生总数
     * @return
     * @throws Exception
     */
    int getCountStudent() throws Exception;

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     * @throws Exception
     */
    StudentCustom findStudentById(Integer id) throws Exception;

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    List<StudentCustom> findByStudentName(String name) throws Exception;

    /**
     * 一对多查询，查询该学生的选课信息
     * @param name
     * @return
     * @throws Exception
     */
    StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception;

}
