package com.system.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Date;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Student {
    private Integer studentId;

    private String studentImage;

    private String studentName;

    private String studentSex;

    @JSONField(format = "yyyy-MM-dd")
    private Date studentBirthday;

    @JSONField(format = "yyyy-MM-dd")
    private Date studentGrade;

    private Integer collegeId;

    public Student(Integer studentId, String studentImage, String studentName, String studentSex, Date studentBirthday, Date studentGrade, Integer collegeId) {
        this.studentId = studentId;
        this.studentImage = studentImage;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentBirthday = studentBirthday;
        this.studentGrade = studentGrade;
        this.collegeId = collegeId;
    }

    public Student() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage == null ? null : studentImage.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public Date getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Date studentGrade) {
        this.studentGrade = studentGrade;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}