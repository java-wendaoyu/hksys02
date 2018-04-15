package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.QueryParam.CourseInfoParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CourseService {
    int addCourse(Course course);

    int removeCourse(int courseId);

    List<Course> findCoursesByCondition(CourseInfoParam param);

    Course findCourseById(Integer courseId);
}
