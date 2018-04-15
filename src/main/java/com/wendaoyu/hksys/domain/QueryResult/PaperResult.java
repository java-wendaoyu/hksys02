package com.wendaoyu.hksys.domain.QueryResult;

import com.wendaoyu.hksys.domain.Paper;
import com.wendaoyu.hksys.domain.ProblemWithBLOBs;

import java.util.List;

public class PaperResult extends Paper{

    private List<ProblemWithBLOBs> problems;

    public List<ProblemWithBLOBs> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemWithBLOBs> problems) {
        this.problems = problems;
    }
}
