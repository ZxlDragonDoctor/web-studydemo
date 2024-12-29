package com.zxl.webexp11.Dao;

import com.zxl.webexp11.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudents(Student student);
}
