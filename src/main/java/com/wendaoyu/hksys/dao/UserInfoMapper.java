package com.wendaoyu.hksys.dao;


import com.wendaoyu.hksys.domain.QueryParam.UserInfoParam;
import com.wendaoyu.hksys.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> selectByCondition(UserInfoParam record);
}