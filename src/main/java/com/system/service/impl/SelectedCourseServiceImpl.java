package com.system.service.impl;

import com.system.dao.SelectedCourseMapper;
import com.system.dao.StudentMapper;
import com.system.model.*;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/14 17:22
 */
@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    private SelectedCourseMapper selectedCourseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseService courseService;


    @Override
    public List<SelectedCourseCustom> findByCourseId(Integer courseId) throws Exception {
        //根据课程id找到该课程
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<SelectedCourse> selectedCourseList = selectedCourseMapper.selectByExample(selectedCourseExample);
        //创建课程扩展类链表，将课程
        List<SelectedCourseCustom> selectedCourseCustomList = new ArrayList<SelectedCourseCustom>();
        for(SelectedCourse selectedCourse:selectedCourseList){
            SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
            BeanUtils.copyProperties(selectedCourse,selectedCourseCustom);
            //判断是否完成该课程
            if(selectedCourseCustom.getSelectedcourseMark() != null){
                selectedCourseCustom.setOver(true);
            }
            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentId());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);
            selectedCourseCustomList.add(selectedCourseCustom);
        }
        return selectedCourseCustomList;
    }

    @Override
    public List<SelectedCourseCustom> findByCourseIdPaging(Integer page, Integer id) throws Exception {
        return null;
    }

    @Override
    public Integer countByCourseId(Integer id) throws Exception {
        SelectedCourseExample example = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = example.createCriteria();
        criteria.andCourseIdEqualTo(id);
        return selectedCourseMapper.countByExample(example);

    }

    @Override
    public SelectedCourseCustom findMark(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(selectedCourseCustom.getCourseId());
        criteria.andStudentIdEqualTo(selectedCourseCustom.getStudentId());
        List<SelectedCourse> selectedCourseList = selectedCourseMapper.selectByExample(selectedCourseExample);
        if(selectedCourseList.size() > 0){
            SelectedCourseCustom sc = new SelectedCourseCustom();
            BeanUtils.copyProperties(selectedCourseList.get(0),sc);
            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentId());
            StudentCustom studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student, studentCustom);

            sc.setStudentCustom(studentCustom);

            return sc;

        }
        return null;
    }

    @Override
    public void updateScore(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedCourseExample example = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = example.createCriteria();

        criteria.andCourseIdEqualTo(selectedCourseCustom.getCourseId());
        criteria.andStudentIdEqualTo(selectedCourseCustom.getStudentId());

        selectedCourseMapper.updateByExample(selectedCourseCustom, example);

    }

    @Override
    public void save(SelectedCourseCustom selectedCourseCustom) throws Exception {
        selectedCourseMapper.insert(selectedCourseCustom);
    }

    @Override
    public List<SelectedCourseCustom> findByStudentId(Integer id) throws Exception {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andStudentIdEqualTo(id);
        selectedCourseMapper.selectByExample(selectedCourseExample);
        return null;
    }

    @Override
    public void remove(SelectedCourseCustom selectedCourseCustom) throws Exception {
        SelectedCourseExample selectedCourseExample = new SelectedCourseExample();
        SelectedCourseExample.Criteria criteria = selectedCourseExample.createCriteria();
        criteria.andCourseIdEqualTo(selectedCourseCustom.getCourseId());
        criteria.andStudentIdEqualTo(selectedCourseCustom.getStudentId());
        selectedCourseMapper.deleteByExample(selectedCourseExample);
    }
}
