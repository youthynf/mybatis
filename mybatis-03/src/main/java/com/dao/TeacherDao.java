package com.dao;

import com.pojo.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeacherList();

    // 一对多：按结果集映射
    Teacher getTeacherWithAllStudent(int id);

    // 一对多：按查询映射
    Teacher getTeacherWithAllStudent2(int id);
}
