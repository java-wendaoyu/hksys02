package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.QueryParam.CourseInfoParam;
import com.wendaoyu.hksys.domain.QueryResult.CourseResult;

import java.util.List;

public interface CourseService {
    int addCourse(Course course);

    int removeCourse(int courseId);

    List<Course> findCoursesByCondition(CourseInfoParam param);

    CourseResult findCourseById(Integer courseId);

    List<Course> findCourseByUser(Integer userId);
}
