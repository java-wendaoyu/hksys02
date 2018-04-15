package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.CourseStudent;

import java.util.List;

public interface CourseStudentService {

    int addCourseStudent(CourseStudent courseStudent);

    /**
     * 展示某个学生的所有课程
     * @param userId
     * @return
     */
    List<Course> findCourseByUser(Integer userId);

}
