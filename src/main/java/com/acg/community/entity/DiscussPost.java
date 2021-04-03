package com.acg.community.entity;

import lombok.Data;

import java.util.Date;

//帖子类
@Data
public class DiscussPost {

    private int id;
    private int userId;
    private String title;   //标题
    private String content; //内容
    private int type;       //类型 0：普通，1：加精
    private int status;     //状态 0：正常，1：精华，2：拉黑
    private Date createTime;
    private int commentCount; //评论数量
    private double score;     //帖子分数
}
