package com.wendaoyu.hksys.dao;

import com.wendaoyu.hksys.BaseTest;
import com.wendaoyu.hksys.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class UserInfoTest extends BaseTest {
    @Resource
    UserInfoMapper userInfoMapper ;
    @Test
    public void test_insert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setDiscription("王昆，西南科技大学教授，专注于计算机网络以及计算机硬件研究方向");
        userInfo.setEmail("1520094399@qq.com");
        userInfo.setGender(0);
        userInfo.setIsTeacher(1);
        userInfo.setStuNum("cs20085124");
        userInfo.setPasswd("123456");
        userInfo.setSchool("西南科技大学");
        userInfo.setUserName("wangkun");
        Assert.assertEquals(1, userInfoMapper.insert(userInfo));
    }
}
