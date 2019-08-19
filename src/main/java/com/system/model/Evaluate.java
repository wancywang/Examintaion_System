package com.system.model;

import java.util.Date;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Evaluate {
    private Integer evaluateId;

    private Integer studentId;

    private Integer courseId;

    private Date evaluateTime;

    private String evaluatContent;

    public Evaluate(Integer evaluateId, Integer studentId, Integer courseId, Date evaluateTime, String evaluatContent) {
        this.evaluateId = evaluateId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.evaluateTime = evaluateTime;
        this.evaluatContent = evaluatContent;
    }

    public Evaluate() {
        super();
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getEvaluatContent() {
        return evaluatContent;
    }

    public void setEvaluatContent(String evaluatContent) {
        this.evaluatContent = evaluatContent == null ? null : evaluatContent.trim();
    }
}