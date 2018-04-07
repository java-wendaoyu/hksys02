package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.HomeworkAnswer;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkAnswerMapper {
    int deleteByPrimaryKey(Integer homeworkAnswerId);

    int insert(HomeworkAnswer record);

    int insertSelective(HomeworkAnswer record);

    HomeworkAnswer selectByPrimaryKey(Integer homeworkAnswerId);

    int updateByPrimaryKeySelective(HomeworkAnswer record);

    int updateByPrimaryKeyWithBLOBs(HomeworkAnswer record);

    int updateByPrimaryKey(HomeworkAnswer record);
}