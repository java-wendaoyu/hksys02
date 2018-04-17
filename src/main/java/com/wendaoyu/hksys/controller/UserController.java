package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.QueryResult.UserLoginResult;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
       UserLoginResult userLoginResult = userService.login(userName,passwd, session);
       if(userLoginResult.getStatus() == WebConfig.SUCCESS){
           return new ResultApi(WebConfig.SUCCESS, userLoginResult, "登录成功");
       }else if(userLoginResult.getStatus() == WebConfig.ACCOUNT_NOT_EXIST){
           return new ResultApi(WebConfig.ACCOUNT_NOT_EXIST, userLoginResult,"用户不存在");
       } else if(userLoginResult.getStatus() == WebConfig.PASSWD_ERROR){
           return new ResultApi(WebConfig.PASSWD_ERROR, userLoginResult,"用户密码错误");
       } else{
           return new ResultApi(WebConfig.FAIL, userLoginResult,"用户登录失败");
       }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultApi addUser(HttpSession session) {
       session.invalidate();
       return new ResultApi(WebConfig.SUCCESS, "退出成功");
    }

    @RequestMapping(value = "/queryByCourse", method = RequestMethod.POST)
    public ResultApi queryByCourse(Integer courseId) {
        List<UserInfo> data = userService.findUserByCourse(courseId);
        return new ResultApi(WebConfig.SUCCESS, data, "退出成功");
    }

    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public ResultApi userDetail(HttpSession session){
        UserInfo record = (UserInfo) session.getAttribute("user");
        if(record == null){
            new ResultApi(WebConfig.FAIL, "请先登录");
        }
        UserInfo userInfo = userService.findUserInfoById(record.getUserId());
        return new ResultApi(WebConfig.SUCCESS, userInfo, "获取成功");
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResultApi updateUser(UserInfo userInfo){
        int flag = userService.alterUser(userInfo);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "修改用户成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "修改用户失败");
        }
    }
}
