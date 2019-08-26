package com.system.model;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/7/2 23:00
 */
public class CourseCustom extends Course {

    //所属院系名
    private String collegeName;

    //课程导师
    private String teacherName;

    //选课列表
    private List<SelectedCourseCustom> selectedCourseList;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<SelectedCourseCustom> getSelectedCourseList() {
        return selectedCourseList;
    }

    public void setSelectedCourseList(List<SelectedCourseCustom> selectedCourseList) {
        this.selectedCourseList = selectedCourseList;
    }
}
