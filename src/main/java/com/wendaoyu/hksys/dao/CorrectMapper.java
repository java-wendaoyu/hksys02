package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Correct;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectMapper {
    int deleteByPrimaryKey(Integer correctId);

    int insert(Correct record);

    int insertSelective(Correct record);

    Correct selectByPrimaryKey(Integer correctId);

    int updateByPrimaryKeySelective(Correct record);

    int updateByPrimaryKey(Correct record);
}