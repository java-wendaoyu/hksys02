package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.QueryParam.CourseInfoParam;
import com.wendaoyu.hksys.domain.QueryResult.CourseResult;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public ResultApi addCourse(Course course, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        course.setTeacherId(userInfo.getUserId());
        int flag = courseService.addCourse(course);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "添加课程成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "添加课程失败");
        }
    }

    @RequestMapping(value = "/removeCourse", method = RequestMethod.POST)
    public ResultApi removeCourse(Integer courseId) {
        int flag = courseService.removeCourse(courseId);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "删除课程成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "删除课程失败");
        }
    }

    @RequestMapping(value = "/queryCourse", method = RequestMethod.POST)
    public ResultApi queryCourse(CourseInfoParam courseInfoParam) {
        List<Course> data = courseService.findCoursesByCondition(courseInfoParam);
        if (data.size() > 0) {
            return new ResultApi(WebConfig.SUCCESS, data, "查询成功");
        } else {
            return new ResultApi(WebConfig.SUCCESS, "查询失败");
        }
    }
    @RequestMapping(value = "/queryCourseByUser", method = RequestMethod.POST)
    public ResultApi queryCourseByUser(HttpSession session) {
        UserInfo record = (UserInfo) session.getAttribute("user");
        List<Course> data = courseService.findCourseByUser(record.getUserId());
        return new ResultApi(WebConfig.SUCCESS, data, "查询成功");
    }

    @RequestMapping(value = "/courseDetail", method = RequestMethod.POST)
    public ResultApi courseDetail(Integer courseId) {
        CourseResult data = courseService.findCourseById(courseId);
        return new ResultApi(0, data, "查询成功");
    }
}
