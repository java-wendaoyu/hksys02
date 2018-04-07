package com.wendaoyu.hksys.domain;

public class HomeworkAnswer {
    private Integer homeworkAnswerId;

    private String filePath;

    private Integer studentId;

    private Integer homeworkId;

    private Integer courseId;

    private Integer score;

    private String content;

    public Integer getHomeworkAnswerId() {
        return homeworkAnswerId;
    }

    public void setHomeworkAnswerId(Integer homeworkAnswerId) {
        this.homeworkAnswerId = homeworkAnswerId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
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
        return "HomeworkAnswer{" +
                "homeworkAnswerId=" + homeworkAnswerId +
                ", filePath='" + filePath + '\'' +
                ", studentId=" + studentId +
                ", homeworkId=" + homeworkId +
                ", courseId=" + courseId +
                ", score=" + score +
                ", content='" + content + '\'' +
                '}';
    }
}