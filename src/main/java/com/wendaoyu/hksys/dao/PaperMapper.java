package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperMapper {
    int deleteByPrimaryKey(Integer paperId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<Paper> selectByCourse(Integer courseId);
}