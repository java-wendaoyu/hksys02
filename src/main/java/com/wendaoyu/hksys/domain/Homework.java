package com.wendaoyu.hksys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Homework {
    private Integer homeworkId;

    private String homeworkName;

    private String filePath;

    private Date startTime;
    private Date endTime;

    private Integer courseId;

    private Integer score;

    private String content;

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homeworkId=" + homeworkId +
                ", homwworkName='" + homeworkName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", courseId=" + courseId +
                ", score=" + score +
                ", content='" + content + '\'' +
                '}';
    }
}