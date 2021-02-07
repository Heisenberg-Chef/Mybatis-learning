package com.ray.dao;

import com.ray.pojo.student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface studentMapper {
    List<student> getstudent();

    List<student> getstudent2(@Param("tid")int id);
}
