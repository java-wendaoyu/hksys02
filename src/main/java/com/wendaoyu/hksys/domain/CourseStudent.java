package com.wendaoyu.hksys.domain;

public class CourseStudent {
    private Integer courseStuId;

    private Integer courseId;

    private Integer studentId;

    public Integer getCourseStuId() {
        return courseStuId;
    }

    public void setCourseStuId(Integer courseStuId) {
        this.courseStuId = courseStuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "courseStuId=" + courseStuId +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                '}';
    }
}