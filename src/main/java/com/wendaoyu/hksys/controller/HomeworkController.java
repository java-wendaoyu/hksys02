package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.Homework;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.service.HomeworkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @Resource
    private HomeworkService homeworkService;
    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    public ResultApi addCourse(Homework record, Integer studentId) {
        int flag = homeworkService.addHomework(record, studentId);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "添加作业成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "添加作业失败");
        }
    }

    @RequestMapping(value = "/showHomework", method = RequestMethod.POST)
    public ResultApi showHomework(Integer courseId) {
       List<Homework> data = homeworkService.findHomeworkByCourse(courseId);
       return new ResultApi(0, data, "查询成功");
    }

    @RequestMapping(value = "/deleteHomework", method = RequestMethod.POST)
    public ResultApi deleteHomework(Integer homeworkId) {
        int flag = homeworkService.removeHomework(homeworkId);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "删除作业成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "删除作业失败");
        }
    }

    @RequestMapping(value = "/alterHomework", method = RequestMethod.POST)
    public ResultApi alterHomework(Homework record) {
        int flag = homeworkService.alterHomework(record);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "修改作业成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "修改作业失败");
        }
    }


}
