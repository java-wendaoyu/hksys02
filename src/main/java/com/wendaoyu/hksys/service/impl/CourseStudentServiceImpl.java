package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CourseMapper;
import com.wendaoyu.hksys.dao.CourseStudentMapper;
import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.CourseStudent;
import com.wendaoyu.hksys.service.CourseStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    @Resource
    private CourseStudentMapper courseStudentMapper;

    @Resource
    private CourseMapper courseMapper;
    @Override
    public int addCourseStudent(CourseStudent courseStudent) {
        Preconditions.checkNotNull(courseStudent, "数据不能为空");
        int flag = courseStudentMapper.insertSelective(courseStudent);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public List<Course> findCourseByUser(Integer userId) {
        List<Course> result = new ArrayList<Course>();
        List<CourseStudent> courseStudentList = courseStudentMapper.selectCourseStudentByUser(userId);
        for (CourseStudent courseStudent : courseStudentList) {
            result.add(courseMapper.selectByPrimaryKey(courseStudent.getCourseId()));
        }
        return result;
    }
}
