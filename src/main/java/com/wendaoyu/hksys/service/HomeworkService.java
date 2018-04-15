package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Homework;

import java.util.List;

public interface HomeworkService {
    int addHomework(Homework record, Integer studentId);

    List<Homework> findHomeworkByCourse(Integer courseId);

    int removeHomework(Integer homeworkId);

    int alterHomework(Homework record);

}
