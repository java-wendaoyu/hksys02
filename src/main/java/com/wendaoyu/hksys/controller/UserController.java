package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResultApi addUser(UserInfo userInfo) {
        int flag = userService.addUser(userInfo);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "添加用户成功");
        } else if(flag == WebConfig.FAIL) {
            return new ResultApi(WebConfig.FAIL, "添加用户失败");
        } else if(flag == WebConfig.ACCOUNT_EXIST){
            return new ResultApi(WebConfig.ACCOUNT_EXIST, "该用户已存在");
        } else if(flag == WebConfig.EMAIL_REGISTED){
            return new ResultApi(WebConfig.EMAIL_REGISTED, "该邮箱已被注册");
        } else{
            return new ResultApi(WebConfig.UNKNOW_ERROR, "注册时发生未知错误");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultApi addUser(String userName, String passwd, HttpSession session) {
       int flag = userService.login(userName,passwd, session);
       if(flag == WebConfig.SUCCESS){
           return new ResultApi(WebConfig.SUCCESS, "登录成功");
       }else if(flag == WebConfig.ACCOUNT_NOT_EXIST){
           return new ResultApi(WebConfig.ACCOUNT_NOT_EXIST, "用户不存在");
       } else if(flag == WebConfig.PASSWD_ERROR){
           return new ResultApi(WebConfig.PASSWD_ERROR, "用户密码错误");
       } else{
           return new ResultApi(WebConfig.FAIL, "用户登录失败");
       }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultApi addUser(HttpSession session) {
       session.invalidate();
       return new ResultApi(WebConfig.SUCCESS, "退出成功");
    }

}
