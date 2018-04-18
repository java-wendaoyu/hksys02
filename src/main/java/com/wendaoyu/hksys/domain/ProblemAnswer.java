package com.wendaoyu.hksys.domain;

public class ProblemAnswer {
    private Integer problemAnswerId;

    private Integer problemId;

    private Integer studentId;

    private Integer score;

    private String content;
    private String paperId;

    public Integer getProblemAnswerId() {
        return problemAnswerId;
    }

    public void setProblemAnswerId(Integer problemAnswerId) {
        this.problemAnswerId = problemAnswerId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    @Override
    public String toString() {
        return "ProblemAnswer{" +
                "problemAnswerId=" + problemAnswerId +
                ", problemId=" + problemId +
                ", studentId=" + studentId +
                ", score=" + score +
                ", content='" + content + '\'' +
                '}';
    }
}