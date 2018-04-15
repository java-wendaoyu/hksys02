package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.Correct;
import com.wendaoyu.hksys.domain.QueryResult.CorrectResult;

import java.util.List;

public interface CorrectService {
     int addCorrect(Correct record);

     List<CorrectResult> findCorrectByUser(Integer userId);

}
