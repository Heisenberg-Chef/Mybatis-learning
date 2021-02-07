package com.ray.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    // 跟sql不一样的字段,但是通过映射我们可以让Java数据类型保持驼峰格式
    private Date createTime;
    private int views;

    public Blog() {
    }

    public Blog(String id, String title, String author, Date createTime, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createTime = createTime;
        this.views = views;
    }
}
