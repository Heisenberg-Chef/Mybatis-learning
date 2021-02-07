package com.ray.pojo;

import lombok.Data;

import java.util.List;

@Data
public class teacher {
    private int id;
    private String name;
    //  一个老师拥有多个学生
    public List<student> studentList;

    @Override
    public String toString() {
        String str1 =  "teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=";
        String str2 = null;
        for (student student:studentList
             ) {
            str2 += student.toString()+", ";
        }
        str2 += "}";
        return str1+str2;
    }
}
