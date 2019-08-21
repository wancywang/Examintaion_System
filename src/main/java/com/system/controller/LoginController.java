package com.system.controller;

import com.system.model.UserLogin;
import com.system.utils.ResponseEnvelope;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Alex
 * @Date: 2019/7/1 23:53
 */
@Controller
@SessionAttributes("userLogin")
public class LoginController {

    /**
     * 角色信息
     */
    public static final String ADMIN = "admin";

    public static final String TEACHER = "teacher";

    public static final String STUDENT = "student";


    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        return "../templates/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseEnvelope<String>> login(UserLogin userLogin) throws Exception{
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserName(),userLogin.getUserPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (AuthenticationException e){
           return new ResponseEntity<>(new ResponseEnvelope<String >(404, "not_found"), HttpStatus.NOT_FOUND);
        }
        if(subject.hasRole(ADMIN)){
            return new ResponseEntity<>(new ResponseEnvelope<String >(200, "success", "test"), HttpStatus.OK);
        }else if(subject.hasRole(TEACHER)){
            return new ResponseEntity<>(new ResponseEnvelope<String >(200, "success.", "test"), HttpStatus.OK);
        }else if(subject.hasRole(STUDENT)){
            return new ResponseEntity<>(new ResponseEnvelope<String >(200, "success.", "test"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseEnvelope<String >(400, "bad_request"), HttpStatus.BAD_REQUEST);
    }
}
