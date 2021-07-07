package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentDao {
    // 多对一：按结果映射
    List<Student> getStudentWithTeacher();

    // 多对一：按查询映射
    List<Student> getStudentWithTeacher2();
}
