package com.wendaoyu.hksys.domain;

public class UserInfo {
    private Integer userId;

    private String imgPath;

    private String userName;

    private String passwd;

    private Integer gender;

    private String stuNum;

    private String email;

    private String school;

    private String discription;

    private Integer isTeacher;

    private String className;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }

    public Integer getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Integer isTeacher) {
        this.isTeacher = isTeacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", imgPath='" + imgPath + '\'' +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", gender=" + gender +
                ", stuNum='" + stuNum + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", discription='" + discription + '\'' +
                ", isTeacher=" + isTeacher +
                ", className='" + className + '\'' +
                '}';
    }
}