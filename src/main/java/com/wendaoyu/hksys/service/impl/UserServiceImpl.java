package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CourseStudentMapper;
import com.wendaoyu.hksys.dao.UserInfoMapper;
import com.wendaoyu.hksys.domain.CourseStudent;
import com.wendaoyu.hksys.domain.QueryParam.UserInfoParam;
import com.wendaoyu.hksys.domain.QueryResult.UserLoginResult;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private CourseStudentMapper courseStudentMapper;

    @Override
    public int addUser(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo, "用户不能为空");
        //查用户名是否已存在
        UserInfoParam userInfoParam = new UserInfoParam();
        userInfoParam.setUserName(userInfo.getUserName());
        if (userInfoMapper.selectByCondition(userInfoParam).size() > 0) {
            return WebConfig.ACCOUNT_EXIST;
        }
        userInfoParam.setUserName(null);

        //查询邮箱是否已注册
        userInfoParam.setEmail(userInfo.getEmail());
        if (userInfoMapper.selectByCondition(userInfoParam).size() > 0) {
            return WebConfig.EMAIL_REGISTED;
        }
        int flag = userInfoMapper.insertSelective(userInfo);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public int removeUserById(Integer userId) {
        return 0;
    }

    @Override
    public int alterUser(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo, "用户不能为空");
        Preconditions.checkArgument(userInfo.getUserId() > 0, "修改用户不能为空");
        int flag = userInfoMapper.updateByPrimaryKey(userInfo);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public UserLoginResult login(String userName, String passwd, HttpSession session) {
        UserLoginResult userLoginResult = new UserLoginResult();
        UserInfoParam param = new UserInfoParam();
        param.setUserName(userName);
        param.setPasswd(passwd);
        List<UserInfo> userInfos = userInfoMapper.selectByCondition(param);
        if (userInfos.size() > 0) {
            session.setAttribute("user", userInfos.get(0));
            userLoginResult.setStatus(WebConfig.SUCCESS);
            userLoginResult.setIsTeacher(userInfos.get(0).getIsTeacher());
        } else {
            param.setPasswd(null);
            userInfos = userInfoMapper.selectByCondition(param);
            if (userInfos.size() > 0) {
                userLoginResult.setStatus(WebConfig.PASSWD_ERROR);
            } else {
                userLoginResult.setStatus(WebConfig.ACCOUNT_NOT_EXIST);
            }
        }
        return userLoginResult;
    }

    @Override
    public UserInfo findUserInfoById(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<UserInfo> findUserByCourse(Integer courseId) {
        List<UserInfo> userInfos = new ArrayList<>();
        List<CourseStudent> courseStudentList = courseStudentMapper.selectCourseStudentByCourse(courseId);
        for (CourseStudent courseStudent : courseStudentList) {
            userInfos.add(userInfoMapper.selectByPrimaryKey(courseStudent.getStudentId()));
        }
        return userInfos;
    }
}
