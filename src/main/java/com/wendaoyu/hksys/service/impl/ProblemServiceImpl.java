package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.ProblemMapper;
import com.wendaoyu.hksys.domain.ProblemWithBLOBs;
import com.wendaoyu.hksys.service.ProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private ProblemMapper problemMapper;
    @Override
    public int addProblem(ProblemWithBLOBs record) {
        Preconditions.checkNotNull(record, "添加题目不能为空");
        int flag = problemMapper.insertSelective(record);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else{
            return WebConfig.FAIL;
        }
    }

    @Override
    public int removeProblem(Integer problemId) {
        Preconditions.checkNotNull(problemId, "删除题目id不能为空");
        int flag = problemMapper.deleteByPrimaryKey(problemId);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else{
            return WebConfig.FAIL;
        }
    }

    @Override
    public int alterProblem(ProblemWithBLOBs record) {
        Preconditions.checkNotNull(record, "修改题目不能为空");
        int flag = problemMapper.updateByPrimaryKey(record);
        if(flag > 0){
            return WebConfig.SUCCESS;
        }else{
            return WebConfig.FAIL;
        }
    }
}
