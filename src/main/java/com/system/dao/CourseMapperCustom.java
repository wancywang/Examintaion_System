package com.system.dao;

import com.system.model.CourseCustom;
import com.system.model.PagingVO;;

import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
public interface CourseMapperCustom {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}
