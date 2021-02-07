package com.ray.dao;

import com.ray.pojo.pojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapperAnnotation {

    @Select("select * from mybatis.user")
    List<pojo> getUser();
}
