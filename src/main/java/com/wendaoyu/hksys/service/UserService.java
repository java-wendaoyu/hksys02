package com.wendaoyu.hksys.service;

import com.wendaoyu.hksys.domain.UserInfo;

/**
 * 对于用户的管理操作
 */
public interface UserService {
    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 移除一位用户
     * @param userId
     * @return
     */
    int removeUserById(Integer userId);

    /**
     * 修改用户基本信息
     * @param userInfo
     * @return
     */
    int alterUser(UserInfo userInfo);

    /**
     * 登录接口
     * @param userName
     * @param passwd
     * @return
     */
    int login(String userName, String passwd);
}
