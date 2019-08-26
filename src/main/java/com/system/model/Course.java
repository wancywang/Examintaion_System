package com.system.model;

import java.util.Date;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Course {
    private Integer courseId;

    private String courseName;

    private Integer teacherId;

    private String courseTime;

    private Date courseYear;

    private String courseClassoom;

    private Integer coursePeriod;

    private String courseType;

    private Integer collegeId;

    private Integer courseScore;

    private String courseVideourl;

    private List<TeacherCustom> teacherCustomList;

    public List<TeacherCustom> getTeacherCustomList() {
        return teacherCustomList;
    }

    public void setTeacherCustomList(List<TeacherCustom> teacherCustomList) {
        this.teacherCustomList = teacherCustomList;
    }

    public Course(Integer courseId, String courseName, Integer teacherId, String courseTime, Date courseYear, String courseClassoom, Integer coursePeriod, String courseType, Integer collegeId, Integer courseScore, String courseVideourl) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.courseTime = courseTime;
        this.courseYear = courseYear;
        this.courseClassoom = courseClassoom;
        this.coursePeriod = coursePeriod;
        this.courseType = courseType;
        this.collegeId = collegeId;
        this.courseScore = courseScore;
        this.courseVideourl = courseVideourl;
    }

    public Course() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public Date getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Date courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseClassoom() {
        return courseClassoom;
    }

    public void setCourseClassoom(String courseClassoom) {
        this.courseClassoom = courseClassoom == null ? null : courseClassoom.trim();
    }

    public Integer getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(Integer coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Integer courseScore) {
        this.courseScore = courseScore;
    }

    public String getCourseVideourl() {
        return courseVideourl;
    }

    public void setCourseVideourl(String courseVideourl) {
        this.courseVideourl = courseVideourl == null ? null : courseVideourl.trim();
    }
}