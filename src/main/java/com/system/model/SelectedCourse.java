package com.system.model;

import java.util.Date;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class SelectedCourse {
    private Integer courseId;

    private Integer studentId;

    private Integer selectedcourseMark;

    private Date selectedcourseTeam;

    public SelectedCourse(Integer courseId, Integer studentId, Integer selectedcourseMark, Date selectedcourseTeam) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.selectedcourseMark = selectedcourseMark;
        this.selectedcourseTeam = selectedcourseTeam;
    }

    public SelectedCourse() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSelectedcourseMark() {
        return selectedcourseMark;
    }

    public void setSelectedcourseMark(Integer selectedcourseMark) {
        this.selectedcourseMark = selectedcourseMark;
    }

    public Date getSelectedcourseTeam() {
        return selectedcourseTeam;
    }

    public void setSelectedcourseTeam(Date selectedcourseTeam) {
        this.selectedcourseTeam = selectedcourseTeam;
    }
}