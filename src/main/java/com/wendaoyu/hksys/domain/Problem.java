package com.wendaoyu.hksys.domain;

public class Problem {
    private Integer problemId;

    private Integer score;

    private Integer paperId;

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", score=" + score +
                ", paperId=" + paperId +
                '}';
    }
}