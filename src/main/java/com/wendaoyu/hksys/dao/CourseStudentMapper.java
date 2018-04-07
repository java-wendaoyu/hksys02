package com.wendaoyu.hksys.dao;

import com.wendaoyu.hksys.domain.CourseStudent;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentMapper {
    int deleteByPrimaryKey(Integer courseStuId);

    int insert(CourseStudent record);

    int insertSelective(CourseStudent record);

    CourseStudent selectByPrimaryKey(Integer courseStuId);

    int updateByPrimaryKeySelective(CourseStudent record);

    int updateByPrimaryKey(CourseStudent record);
}