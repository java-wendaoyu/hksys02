package com.wendaoyu.hksys.domain;

public class Paper {
    private Integer paperId;

    private String paperName;

    private Integer courseId;

    private Integer score;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
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

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", courseId=" + courseId +
                ", score=" + score +
                '}';
    }
}