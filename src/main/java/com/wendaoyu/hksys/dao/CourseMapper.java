package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Course;
import com.wendaoyu.hksys.domain.QueryParam.CourseInfoParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectByCondition(CourseInfoParam param);

    List<Course> selectByUser(Integer userId);
}