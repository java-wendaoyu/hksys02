package com.wendaoyu.hksys.service.impl;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.HomeworkAnswerMapper;
import com.wendaoyu.hksys.domain.HomeworkAnswer;
import com.wendaoyu.hksys.domain.QueryParam.HomeworkAnswerParam;
import com.wendaoyu.hksys.service.HomeworkAnswerService;

import javax.annotation.Resource;
import java.util.List;

public class HomeworkAnswerServiceImpl implements HomeworkAnswerService {

    @Resource
    private HomeworkAnswerMapper homeworkAnswerMapper;

    @Override
    public int addHomeworkAnswer(HomeworkAnswer homeworkAnswer) {
        int flag = homeworkAnswerMapper.insertSelective(homeworkAnswer);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public int alterHomeworkAnswer(HomeworkAnswer record) {
        int flag = homeworkAnswerMapper.updateByPrimaryKey(record);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public int removeHomeworkAnsewrById(Integer homeorkAnswerId) {
        int flag = homeworkAnswerMapper.deleteByPrimaryKey(homeorkAnswerId);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public List<HomeworkAnswer> findHomeworkAnswersByCondition(HomeworkAnswerParam homeworkAnswerParam) {
        return homeworkAnswerMapper.selectByCondition(homeworkAnswerParam);
    }
}
