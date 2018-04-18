package com.wendaoyu.hksys.domain.QueryResult;

import com.wendaoyu.hksys.domain.Paper;

public class PaperInfo extends Paper {
    public PaperInfo(Paper paper) {
       this.setCourseId(paper.getCourseId());
       this.setCreateTime(paper.getCreateTime());
       this.setEndTime(paper.getEndTime());
       this.setPaperId(paper.getPaperId());
       this.setPaperName(paper.getPaperName());
       this.setScore(paper.getScore());
    }

    private Integer personTotal;
    private Integer submitTotal;
    private Integer problemTotal;

    public Integer getPersonTotal() {
        return personTotal;
    }

    public void setPersonTotal(Integer personTotal) {
        this.personTotal = personTotal;
    }

    public Integer getSubmitTotal() {
        return submitTotal;
    }

    public void setSubmitTotal(Integer submitTotal) {
        this.submitTotal = submitTotal;
    }

    public Integer getProblemTotal() {
        return problemTotal;
    }

    public void setProblemTotal(Integer problemTotal) {
        this.problemTotal = problemTotal;
    }
}
