package com.system.model;

import java.util.Date;
/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private String teacherSex;

    private Date teacherBirthday;

    private String teacherDegree;

    private String teacherPosition;

    private Date teacherHiredate;

    private Integer collegeId;

    public Teacher(Integer teacherId, String teacherName, String teacherSex, Date teacherBirthday, String teacherDegree, String teacherPosition, Date teacherHiredate, Integer collegeId) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherBirthday = teacherBirthday;
        this.teacherDegree = teacherDegree;
        this.teacherPosition = teacherPosition;
        this.teacherHiredate = teacherHiredate;
        this.collegeId = collegeId;
    }

    public Teacher() {
        super();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree == null ? null : teacherDegree.trim();
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition == null ? null : teacherPosition.trim();
    }

    public Date getTeacherHiredate() {
        return teacherHiredate;
    }

    public void setTeacherHiredate(Date teacherHiredate) {
        this.teacherHiredate = teacherHiredate;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}