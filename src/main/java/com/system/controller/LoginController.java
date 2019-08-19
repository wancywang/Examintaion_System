package com.system.controller;

import com.system.model.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Alex
 * @Date: 2019/7/1 23:53
 */
@Controller
@SessionAttributes("userLogin")
public class LoginController {


    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../templates/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserLogin userLogin) throws Exception{
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserName(),userLogin.getUserPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        if(subject.hasRole("admin")){
            return "../templates/login";
           // return "admin/showStudent";
        }else if(subject.hasRole("teacher")){
            return "teacher/showCourse";
        }else if(subject.hasRole("student")){
            return "admin/showStudent";
        }
        return "/login.html";
    }
}
