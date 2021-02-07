package com.ray.pojo;

import lombok.Data;

@Data
public class student {
    private int id;
    private String name;
    //private int tid;
    // 用户需要关联一个老师
    private teacher teacher;
}
