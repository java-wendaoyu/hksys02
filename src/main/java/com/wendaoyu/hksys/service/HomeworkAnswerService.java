package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.HomeworkAnswer;
import com.wendaoyu.hksys.domain.QueryParam.HomeworkAnswerParam;

import java.util.List;

public interface HomeworkAnswerService {
    int addHomeworkAnswer(HomeworkAnswer homeworkAnswer);

    int alterHomeworkAnswer(HomeworkAnswer record);

    int removeHomeworkAnsewrById(Integer homeorkAnswerId);

    List<HomeworkAnswer> findHomeworkAnswersByCondition(HomeworkAnswerParam homeworkAnswerParam);

}
