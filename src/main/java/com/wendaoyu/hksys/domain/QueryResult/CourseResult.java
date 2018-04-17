package com.wendaoyu.hksys.domain.QueryResult;

import com.wendaoyu.hksys.domain.Course;

public class CourseResult extends Course {
    private String teacherName;

    public CourseResult(Course course) {
        this.setClassName(course.getClassName());
        this.setCourseId(course.getCourseId());
        this.setCourseName(course.getCourseName());
        this.setDiscription(course.getDiscription());
        this.setMeans(course.getMeans());
        this.setTeacherId(course.getTeacherId());
        this.setTerm(course.getTerm());
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
