package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}