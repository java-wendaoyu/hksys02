package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.HomeworkAnswer;
import com.wendaoyu.hksys.domain.QueryParam.HomeworkAnswerParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkAnswerMapper {
    int deleteByPrimaryKey(Integer homeworkAnswerId);

    int insert(HomeworkAnswer record);

    int insertSelective(HomeworkAnswer record);

    HomeworkAnswer selectByPrimaryKey(Integer homeworkAnswerId);

    int updateByPrimaryKeySelective(HomeworkAnswer record);

    int updateByPrimaryKeyWithBLOBs(HomeworkAnswer record);

    int updateByPrimaryKey(HomeworkAnswer record);

    List<HomeworkAnswer> selectByCourse(Integer courseId);

    List<HomeworkAnswer> selectByCondition(HomeworkAnswerParam homeworkAnswerParam);
}