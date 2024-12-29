package com.zxl.webexp11.mappers;

import com.zxl.webexp11.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> findAllStudents2();
    
    // 根据学生ID查询学生信息的方法，目前没有被使用
    Student findStudentById2(Integer studId);
    
    // 查询所有学生信息的方法，
    List<Student> findAllStudents();
    
    // 根据学生ID查询学生信息的方法
    Student findStudentById(Integer studId);
    
    // 插入学生信息的方法，返回插入的行数
    int insertStudent(Student student);
    
    // 更新学生信息的方法，返回更新的行数
    int updateStudent(Student student);
    
    // 根据参数删除学生信息的方法，返回删除的行数，参数是一个Map，
    int deleteStudent(Map<String, Integer> param);
    
    // 根据学生对象查询学生信息的方法
    List<Student> findStudent1(Student student);
}