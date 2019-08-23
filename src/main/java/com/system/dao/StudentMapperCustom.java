package com.system.dao;

import com.system.model.PagingVO;
import com.system.model.StudentCustom;

import java.util.List;

/**
 * Created by Jacey on 2017/6/28.
 */
public interface StudentMapperCustom {

    //分页查询学生信息
    List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception;

    //查询学生信息，和其选课信息
    StudentCustom findStudentAndSelectCourseListById(Integer id) throws Exception;
}
