package com.wendaoyu.hksys.service.impl;

import com.google.common.base.Preconditions;
import com.wendaoyu.hksys.config.WebConfig;
import com.wendaoyu.hksys.dao.PaperMapper;
import com.wendaoyu.hksys.dao.ProblemMapper;
import com.wendaoyu.hksys.domain.Paper;
import com.wendaoyu.hksys.domain.ProblemWithBLOBs;
import com.wendaoyu.hksys.domain.QueryResult.PaperResult;
import com.wendaoyu.hksys.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ProblemMapper problemMapper;

    @Override
    public int addPaper(Paper record) {
        Preconditions.checkNotNull(record, "试卷内容不能为空");
        int flag = paperMapper.insertSelective(record);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public int removePaper(Integer paperId) {
        Preconditions.checkNotNull(paperId, "删除试卷不能为空");
        int flag = paperMapper.deleteByPrimaryKey(paperId);
        if (flag > 0) {
            return WebConfig.SUCCESS;
        } else {
            return WebConfig.FAIL;
        }
    }

    @Override
    public PaperResult findPaperDetail(Integer paperId) {
        PaperResult paperResult = new PaperResult();
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        List<ProblemWithBLOBs> problems = problemMapper.selectByPaper(paperId);
        paperResult.setProblems(problems);
        paperResult.setCourseId(paper.getCourseId());
        paperResult.setPaperId(paper.getPaperId());
        paperResult.setPaperName(paper.getPaperName());
        paperResult.setScore(paper.getScore());
        return paperResult;
    }

    @Override
    public List<Paper> findPaperByCourse(Integer courseId) {
        return paperMapper.selectByCourse(courseId);
    }
}
