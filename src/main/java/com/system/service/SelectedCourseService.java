package com.system.service;

import com.system.model.SelectedCourse;
import com.system.model.SelectedCourseCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/14 17:18
 */
public interface SelectedCourseService {

    /**
     * 根据课程id查询课程
     * @param id
     * @return
     * @throws Exception
     */
    List<SelectedCourseCustom> findByCourseId(Integer id) throws Exception;

    /**
     * 根据课程id分页查询课程
     * @param page
     * @param id
     * @return
     * @throws Exception
     */
    List<SelectedCourseCustom> findByCourseIdPaging(Integer page, Integer id) throws Exception;

    /**
     * 获取该课程学生数
     * @param id
     * @return
     * @throws Exception
     */
    Integer countByCourseId(Integer id) throws Exception;

    /**
     * 查询指定学生成绩
     * @param selectedCourseCustom
     * @return
     * @throws Exception
     */
    SelectedCourseCustom findMark(SelectedCourseCustom selectedCourseCustom) throws Exception;

    /**
     * 打分
     * @param selectedCourseCustom
     * @throws Exception
     */
    void updateScore(SelectedCourseCustom selectedCourseCustom) throws Exception;

    /**
     * 选课
     * @param selectedCourseCustom
     * @throws Exception
     */
    void save(SelectedCourseCustom selectedCourseCustom) throws Exception;

    /**
     * 根据学生id查找课程
     * @param id
     * @return
     * @throws Exception
     */
    List<SelectedCourseCustom> findByStudentId(Integer id) throws Exception;

    /**
     * 退课
     * @param selectedCourseCustom
     * @throws Exception
     */
    void remove(SelectedCourseCustom selectedCourseCustom) throws Exception;

}
