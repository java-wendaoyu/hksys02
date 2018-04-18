package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.Paper;
import com.wendaoyu.hksys.domain.QueryResult.PaperInfo;
import com.wendaoyu.hksys.domain.QueryResult.PaperResult;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.service.PaperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Resource
    private PaperService paperService;

    @RequestMapping(value = "/addPaper", method = RequestMethod.POST)
    public ResultApi addPaper(Paper paper) {
        int flag = paperService.addPaper(paper);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(0, "添加试卷成功");
        } else {
            return new ResultApi(-1, "添加试卷失败");
        }
    }

    @RequestMapping(value = "/deletePaper", method = RequestMethod.POST)
    public ResultApi deletePaper(Integer paperId) {
        int flag = paperService.removePaper(paperId);
        if (flag == WebConfig.SUCCESS) {
            return new ResultApi(0, "删除试卷成功");
        } else {
            return new ResultApi(-1, "删除试卷失败");
        }
    }

    @RequestMapping(value = "/paperList", method = RequestMethod.POST)
    public ResultApi paperList(Integer courseId) {
        List<PaperInfo> data = paperService.findPaperByCourse(courseId);
        return new ResultApi(0, data, "查询成功");
    }
    @RequestMapping(value = "/findPaper", method = RequestMethod.POST)
    public ResultApi findPaper(Integer paperId) {
        Paper data = paperService.findPaperById(paperId);
        return new ResultApi(0, data, "查询成功");
    }

    @RequestMapping(value = "/paperDetail", method = RequestMethod.POST)
    public ResultApi paperDetail(Integer paperId) {
        PaperResult data = paperService.findPaperDetail(paperId);
        return new ResultApi(0, data, "查询成功");
    }
}
