package com.system.service.impl;

import com.system.dao.CollegeMapper;
import com.system.dao.CourseMapper;
import com.system.dao.CourseMapperCustom;
import com.system.dao.SelectedCourseMapper;
import com.system.model.*;
import com.system.service.CourseService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/11 21:23
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapperCustom courseMapperCustom;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private SelectedCourseMapper selectedCourseMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public void updateById(Integer id, CourseCustom courseCustom) throws Exception {
        courseMapper.updateByPrimaryKey(courseCustom);
    }

    @Override
    public Boolean removeById(Integer id) throws Exception {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(id);
        List<SelectedCourse> list = selectedCourseMapper.selectByExample(selectedCourseExample);
        if (list.size() == 0) {
            courseMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean save(CourseCustom courseCustom) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(courseCustom.getCourseId());
        if (course == null) {
            courseMapper.insert(courseCustom);
            return true;
        }
        return false;
    }

    @Override
    public int getCountCourse() throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseNameIsNotNull();
        return courseMapper.countByExample(courseExample);
    }

    @Override
    public CourseCustom findById(Integer id) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(id);
        CourseCustom courseCustom = null;
        if (course != null) {
            courseCustom = new CourseCustom();
            BeanUtils.copyProperties(course, courseCustom);
        }
        return courseCustom;
    }

    @Override
    public List<CourseCustom> findByName(String name) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseNameLike("%" + name + "%");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        List<CourseCustom> courseCustomList = null;
        if (courseCustomList != null) {
            courseCustomList = new ArrayList<>();
            for (Course course : courseList) {
                CourseCustom courseCustom = new CourseCustom();
                BeanUtils.copyProperties(course, courseCustom);
                College college = collegeMapper.selectByPrimaryKey(course.getCollegeId());
                courseCustom.setcollegeName(college.getCollegeName());
                courseCustomList.add(courseCustom);
            }
        }

        return courseCustomList;
    }

    @Override
    public List<CourseCustom> findByTeacherId(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(id);
        List<Course> list = courseMapper.selectByExample(courseExample);
        List<CourseCustom> courseCustomList = null;

        if (list.size() > 0) {
            courseCustomList = new ArrayList<CourseCustom>();
            for (Course course : list) {
                CourseCustom courseCustom = new CourseCustom();
                BeanUtils.copyProperties(courseCustom, course);
                College college = collegeMapper.selectByPrimaryKey(course.getCollegeId());
                courseCustom.setcollegeName(college.getCollegeName());

                courseCustomList.add(courseCustom);
            }
        }
            return null;
        }
}
