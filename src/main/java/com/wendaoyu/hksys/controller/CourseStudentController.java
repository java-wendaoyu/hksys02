package com.wendaoyu.hksys.controller;


import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CourseStudentMapper;
import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.CourseStudent;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.CourseStudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/courseStudent")
public class CourseStudentController {
    @Resource
    private CourseStudentService courseStudentService;

    @RequestMapping (value="/addCourseStudent", method = RequestMethod.POST)
    public ResultApi addCourseStudent(CourseStudent record, HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        record.setStudentId(userInfo.getUserId());
      int flag = courseStudentService.addCourseStudent(record);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(0, "添加课程成功");
        } else {
            return new ResultApi(-1, "添加课程失败");
        }
    }

    @RequestMapping (value="/showCourse", method = RequestMethod.POST)
    public ResultApi showCourse(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        List<Course> data = courseStudentService.findCourseByUser(userInfo.getUserId());
        return new ResultApi(0, data, "查询成功");
    }
}
