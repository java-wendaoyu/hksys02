package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.ProblemAnswer;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemAnswerMapper {
    int deleteByPrimaryKey(Integer problemAnswerId);

    int insert(ProblemAnswer record);

    int insertSelective(ProblemAnswer record);

    ProblemAnswer selectByPrimaryKey(Integer problemAnswerId);

    int updateByPrimaryKeySelective(ProblemAnswer record);

    int updateByPrimaryKeyWithBLOBs(ProblemAnswer record);

    int updateByPrimaryKey(ProblemAnswer record);

    int selectSubmitNumberByPaper(Integer paperId);
}