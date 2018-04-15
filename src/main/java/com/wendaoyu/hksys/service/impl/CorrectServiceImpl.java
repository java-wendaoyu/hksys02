package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.CorrectMapper;
import com.wendaoyu.hksys.dao.CourseMapper;
import com.wendaoyu.hksys.dao.HomeworkAnswerMapper;
import com.wendaoyu.hksys.dao.HomeworkMapper;
import com.wendaoyu.hksys.dao.UserInfoMapper;
import com.wendaoyu.hksys.domain.Correct;
import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.Homework;
import com.wendaoyu.hksys.domain.HomeworkAnswer;
import com.wendaoyu.hksys.domain.QueryResult.CorrectResult;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.CorrectService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CorrectServiceImpl implements CorrectService {
    @Resource
    private CorrectMapper correctMapper;

    @Resource
    private HomeworkMapper homeworkMapper;

    @Resource
    private HomeworkAnswerMapper homeworkAnswerMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int addCorrect(Correct record) {
        Preconditions.checkNotNull(record, "数据不能为空");
        int flag = correctMapper.insertSelective(record);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public List<CorrectResult> findCorrectByUser(Integer userId) {
        List<Correct> correctList = correctMapper.findCoursesByUser(userId);
        List<CorrectResult> results = new ArrayList<CorrectResult>();
        for (Correct correct : correctList) {
            Homework homework = homeworkMapper.selectByPrimaryKey(correct.getHomeworkId());
            Course course = courseMapper.selectByPrimaryKey(homework.getCourseId());
            List<HomeworkAnswer> homeworkAnswers = homeworkAnswerMapper.selectByCourse(course.getCourseId());
            for (HomeworkAnswer homeworkAnswer : homeworkAnswers) {
                CorrectResult correctResult = new CorrectResult();
                correctResult.setHomeworkName(homework.getHomeworkName());
                correctResult.setCourseName(course.getCourseName());
                UserInfo userInfo = userInfoMapper.selectByPrimaryKey(homeworkAnswer.getStudentId());
                correctResult.setUserName(userInfo.getUserName());
                correctResult.setStatus(homeworkAnswer.getStatus());
                correctResult.setHomeworkAnswerId(homeworkAnswer.getHomeworkAnswerId());
                results.add(correctResult);
            }
        }
        return results;
    }
}
