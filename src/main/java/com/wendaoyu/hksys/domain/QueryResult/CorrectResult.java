package com.wendaoyu.hksys.domain.QueryResult;

public class CorrectResult {
    private String userName;
    private String courseName;
    private Integer homeworkAnswerId;
    private String homeworkName;
    private Integer status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getHomeworkAnswerId() {
        return homeworkAnswerId;
    }

    public void setHomeworkAnswerId(Integer homeworkAnswerId) {
        this.homeworkAnswerId = homeworkAnswerId;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
