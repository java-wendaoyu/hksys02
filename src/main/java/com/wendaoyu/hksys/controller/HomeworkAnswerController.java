package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.HomeworkAnswer;
import com.wendaoyu.hksys.domain.QueryParam.HomeworkAnswerParam;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.HomeworkAnswerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/homeworkAnswer")
public class HomeworkAnswerController {
    @Resource
    private HomeworkAnswerService homeworkAnswerService;

    @RequestMapping(value = "/addHomeworkAnswer", method = RequestMethod.POST)
    public ResultApi addHomeworkAnswer(HomeworkAnswer record, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        record.setStudentId(userInfo.getUserId());
        int flag = homeworkAnswerService.addHomeworkAnswer(record);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "添加作业成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "添加作业失败");
        }
    }

    @RequestMapping(value = "/showHomeworkAnswer", method = RequestMethod.POST)
    public ResultApi showHomeworkAnswer(HomeworkAnswerParam param) {
        List<HomeworkAnswer> data = homeworkAnswerService.findHomeworkAnswersByCondition(param);
        return new ResultApi(0, data, "查询成功");
    }

    @RequestMapping(value = "/deleteHomeworkAnswer", method = RequestMethod.POST)
    public ResultApi deleteHomeworkAnswer(Integer homeworkAnswerId) {
        int flag = homeworkAnswerService.removeHomeworkAnsewrById(homeworkAnswerId);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "删除成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "删除失败");
        }
    }

    @RequestMapping(value = "/alterHomework", method = RequestMethod.POST)
    public ResultApi alterHomework(HomeworkAnswer record ) {
        int flag = homeworkAnswerService.alterHomeworkAnswer(record);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(WebConfig.SUCCESS, "修改成功");
        } else {
            return new ResultApi(WebConfig.FAIL, "修改失败");
        }
    }

}
