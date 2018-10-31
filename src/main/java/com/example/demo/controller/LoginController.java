package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/")
    public ModelAndView loginFtl(){
        return new ModelAndView("index");
    }
    @RequestMapping("login")
    @ResponseBody
    public String login(String loginName,String password){
        loginService.checkPassword(loginName,password);
        return "ok";
    }
    @RequestMapping("findPassword")
    public ModelAndView findPassword(){
        return new ModelAndView("login/find_password");
    }
    @RequestMapping("regist")
    public ModelAndView regist(){
        return new ModelAndView("login/regist");
    }
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(Login login){
        loginService.adduser(login);
        return "ok";
    }
}
