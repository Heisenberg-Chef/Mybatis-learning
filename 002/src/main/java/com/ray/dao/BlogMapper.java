package com.ray.dao;

import com.ray.pojo.Blog;
import org.apache.ibatis.cache.Cache;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    Cache
    // 动态SQL查询语句
    List<Blog> queryBlogIF(Map map);
}
