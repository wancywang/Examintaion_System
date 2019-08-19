package com.system.service.impl;

import com.system.dao.CollegeMapper;
import com.system.dao.StudentMapper;
import com.system.model.College;
import com.system.model.Student;
import com.system.model.StudentCustom;
import com.system.model.StudentExample;
import com.system.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/2 23:30
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public void updateByStudentById(Integer id, StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    @Override
    public void removeStudentById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentCustom> findByPaging(Integer toPageNo) throws Exception {

        return null;
    }

    @Override
    public Boolean save(StudentCustom studentCustom) throws Exception {
        Student student = studentMapper.selectByPrimaryKey(studentCustom.getStudentId());
        if (student == null){
            studentMapper.insert(studentCustom);
            return true;
        }
        return false;
    }

    @Override
    public int getCountStudent() throws Exception {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentIdIsNotNull();
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public StudentCustom findStudentById(Integer id) throws Exception {
        Student student = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom = null;
        if(student != null){
            studentCustom = new StudentCustom();
            BeanUtils.copyProperties(student,studentCustom);
        }
        return studentCustom;
    }

    @Override
    public List<StudentCustom> findByStudentName(String name) throws Exception {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentNameLike("%" + name + "%");
        List<Student> list = studentMapper.selectByExample(studentExample);
        List<StudentCustom> studentCustomList = null;
        if(list != null){
            studentCustomList = new ArrayList<StudentCustom>();
            for(Student s:list){
                StudentCustom studentCustom = new StudentCustom();
                BeanUtils.copyProperties(s,studentCustom);
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeId());
                studentCustom.setcollegeName(college.getCollegeName());
                studentCustomList.add(studentCustom);
            }
        }
        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception {
        return null;
    }
}
