package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CourseMapper;
import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.QueryParam.CourseInfoParam;
import com.wendaoyu.hksys.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public int addCourse(Course course) {
        Preconditions.checkNotNull(course, "添加的课程不能为空");
        int flag = courseMapper.insertSelective(course);
        if (flag > 0){
            return WebConfig.SUCCESS;
        }else{
            return WebConfig.FAIL;
        }
    }

    @Override
    public int removeCourse(int courseId) {
        int flag = courseMapper.deleteByPrimaryKey(courseId);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public List<Course> findCoursesByCondition(CourseInfoParam param) {
        return courseMapper.selectByCondition(param);
    }

    @Override
    public Course findCourseById(Integer courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }
}
