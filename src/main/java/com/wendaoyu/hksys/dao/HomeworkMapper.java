package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Homework;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer homeworkId);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer homeworkId);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);
}