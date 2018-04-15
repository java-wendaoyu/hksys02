package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Paper;
import com.wendaoyu.hksys.domain.QueryResult.PaperResult;

import java.util.List;

public interface PaperService {
    int addPaper(Paper record);

    int removePaper(Integer paperId);

    PaperResult findPaperDetail(Integer paperId);

    List<Paper> findPaperByCourse(Integer courseId);

}
