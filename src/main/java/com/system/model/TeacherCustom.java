package com.system.model;

/**
 * teacher扩展类
 */
public class TeacherCustom extends Teacher {
    //所属院系名
    private College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
