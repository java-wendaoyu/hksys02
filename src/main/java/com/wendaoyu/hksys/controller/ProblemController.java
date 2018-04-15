package com.wendaoyu.hksys.controller;

import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.domain.ProblemWithBLOBs;
import com.wendaoyu.hksys.domain.ResultApi;
import com.wendaoyu.hksys.service.ProblemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Resource
    private ProblemService problemService;

    @RequestMapping(value = "/addProblem", method = RequestMethod.POST)
    public ResultApi addProblem(ProblemWithBLOBs record) {
          int flag = problemService.addProblem(record);
          if(flag == WebConfig.SUCCESS){
              return new ResultApi(0, "添加问题成功");
          }else{
              return new ResultApi(-1, "添加问题失败");
          }
    }
    @RequestMapping(value = "/deleteProblem", method = RequestMethod.POST)
    public ResultApi addProblem(Integer problemId) {
        int flag = problemService.removeProblem(problemId);
        if(flag == WebConfig.SUCCESS){
            return new ResultApi(0, "删除问题成功");
        }else{
            return new ResultApi(-1, "删除问题失败");
        }
    }
    @RequestMapping(value = "/alterProblem", method = RequestMethod.POST)
    public ResultApi alterProblem(ProblemWithBLOBs record) {
        int flag = problemService.alterProblem(record);
        if(flag == WebConfig.SUCCESS){
            return new ResultApi(0, "修改问题成功");
        }else{
            return new ResultApi(-1, "修改问题失败");
        }
    }
}
