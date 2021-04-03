package com.acg.community.entity;

import lombok.Data;

/**
 * 封装分页相关的信息
 */
@Data
public class PageParams {
    private Integer pageNum;    //当前页第一条
    private Integer pageSize;   //每页显示条数
}

