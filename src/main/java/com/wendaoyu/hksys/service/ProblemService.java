package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.ProblemWithBLOBs;

import java.util.List;

public interface ProblemService {
    int addProblem(ProblemWithBLOBs record);

    int removeProblem(Integer problemId);

    int alterProblem(ProblemWithBLOBs record);

}
