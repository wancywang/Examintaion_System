package com.system.model;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class College {
    private Integer collegeId;

    private String collegeName;

    public College(Integer collegeId, String collegeName) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
    }

    public College() {
        super();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}