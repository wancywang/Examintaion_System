package com.system.dao;

import com.system.model.SelectedCourse;
import com.system.model.SelectedCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public interface SelectedCourseMapper {
    int countByExample(SelectedCourseExample example);

    int deleteByExample(SelectedCourseExample example);

    int insert(SelectedCourse record);

    int insertSelective(SelectedCourse record);

    List<SelectedCourse> selectByExample(SelectedCourseExample example);

    int updateByExampleSelective(@Param("record") SelectedCourse record, @Param("example") SelectedCourseExample example);

    int updateByExample(@Param("record") SelectedCourse record, @Param("example") SelectedCourseExample example);
}