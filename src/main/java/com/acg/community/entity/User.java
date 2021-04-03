package com.acg.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;                 //id
    private String username;        //用户名
    private String password;        //密码
    private String salt;            //盐值
    private String email;           //邮箱
    private int type;               //类型
    private int status;             //状态
    private String activationCode;  //激活码
    private String headerUrl;         //头像的访问路径
    private Date createTime;        //用户注册时间

}
