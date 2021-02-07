package com.ray.dao;

import com.ray.pojo.pojo;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<pojo> getUserList();
    //定义通过id进行查找
    List<pojo> getUserById(int id);
    // 添加用户
    int addUser(pojo user);
    // 修改用户
    int modifyUser(pojo user);
    // 删除用户
    int deleteUser(int id);

    // 使用map传输数据
    int modifyUser2(Map<String,Object> map);

    // 分页操作
    List<pojo> getUserByLimit(Map<String,Integer> map);

    List<pojo> getUserByLimit2();
}
