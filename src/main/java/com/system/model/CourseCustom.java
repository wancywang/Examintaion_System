package com.system.model;

/**
 * @Author: Alex
 * @Date: 2019/7/2 23:00
 */
public class CourseCustom extends Course {
    /**
     * 所属院系名
     */
    private String collegeName;

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }


}
