package com.ray.dao;

import com.ray.pojo.teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface teacherMapper {

    List<teacher> getTeacher(@Param("tid")int id);
}
