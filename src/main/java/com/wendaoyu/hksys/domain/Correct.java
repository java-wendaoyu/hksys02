package com.wendaoyu.hksys.domain;

/**
 * 指定批改作业实体类
 */
public class Correct {
    private Integer correctId;

    private Integer homeworkId;

    private Integer userId;

    public Integer getCorrectId() {
        return correctId;
    }

    public void setCorrectId(Integer correctId) {
        this.correctId = correctId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Correct{" +
                "correctId=" + correctId +
                ", homeworkId=" + homeworkId +
                ", userId=" + userId +
                '}';
    }
}