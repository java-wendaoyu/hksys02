package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.Correct;
import com.wendaoyu.hksys.domain.QueryResult.CorrectResult;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.domain.UserInfo;
import com.wendaoyu.hksys.service.CorrectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/correct")
public class CorrectController {
    private CorrectService correctService;

    @RequestMapping(value = "/addCorrect", method = RequestMethod.POST)
    public ResultApi addCorrect(Correct record) {
        int flag = correctService.addCorrect(record);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(0, "设置批改人成功");
        } else {
            return new ResultApi(-1, "设置批改人失败");
        }
    }

    @RequestMapping(value = "/showCorrect", method = RequestMethod.POST)
    public ResultApi showCorrect(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        List<CorrectResult> data = correctService.findCorrectByUser(userInfo.getUserId());
        return new ResultApi(0, data, "查询成功");
    }


}
