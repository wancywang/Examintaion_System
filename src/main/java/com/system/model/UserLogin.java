package com.system.model;

public class UserLogin {
    private Integer userloginId;

    private String userName;

    private String userPassword;

    private Integer role;

    public UserLogin(Integer userloginId, String userName, String userPassword, Integer role) {
        this.userloginId = userloginId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
    }

    public UserLogin() {
        super();
    }

    public Integer getUserloginId() {
        return userloginId;
    }

    public void setUserloginId(Integer userloginId) {
        this.userloginId = userloginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}