package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Problem;
import com.wendaoyu.hksys.domain.ProblemWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer problemId);

    int insert(ProblemWithBLOBs record);

    int insertSelective(ProblemWithBLOBs record);

    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);

    int updateByPrimaryKeySelective(ProblemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProblemWithBLOBs record);

    int updateByPrimaryKey(Problem record);
}