package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CorrectMapper;
import com.wendaoyu.hksys.dao.HomeworkMapper;
import com.wendaoyu.hksys.domain.Correct;
import com.wendaoyu.hksys.domain.Homework;
import com.wendaoyu.hksys.service.HomeworkService;

import javax.annotation.Resource;
import java.util.List;

public class HomeworkServiceImpl implements HomeworkService {

    @Resource
    private HomeworkMapper homeworkMapper;

    @Resource
    private CorrectMapper correctMapper;

    @Override
    public int addHomework(Homework record, Integer studentId) {
        Preconditions.checkNotNull(record,"数据不能为空");
        int flag = homeworkMapper.insertSelective(record);
        if(flag > 0){
            if(studentId != null) {
                Correct correct = new Correct();
                correct.setUserId(studentId);
                correct.setCorrectId(record.getCourseId());
                int result = correctMapper.insertSelective(correct);
                if(result > 0){
                    return WebConfig.SUCCESS;
                }else{
                    return WebConfig.FAIL;
                }
            }else{
                return WebConfig.SUCCESS;
            }
        }else{
            return WebConfig.FAIL;
        }
    }

    @Override
    public List<Homework> findHomeworkByCourse(Integer courseId) {
        return homeworkMapper.selectHomeworkByCourse(courseId);
    }

    @Override
    public int removeHomework(Integer homeworkId) {
        int flag = homeworkMapper.deleteByPrimaryKey(homeworkId);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public int alterHomework(Homework record) {
        int flag = homeworkMapper.updateByPrimaryKey(record);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else {
            return WebConfig.FAIL;
        }
    }
}
