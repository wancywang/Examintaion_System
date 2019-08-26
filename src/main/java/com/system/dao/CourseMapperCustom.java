package com.system.dao;

import com.system.model.CourseCustom;
import com.system.model.PagingVO;

import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
public interface CourseMapperCustom {

    /**
     *
     * @param pagingVO
     * @return
     * @throws Exception
     */
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

    /**
     *查询学生信息，和其选课信息
     * @param id
     * @return
     * @throws Exception
     */
    List<CourseCustom> findStudentAndSelectCourseListById(Integer id) throws Exception;

    List<CourseCustom> findAllCourse();

}
