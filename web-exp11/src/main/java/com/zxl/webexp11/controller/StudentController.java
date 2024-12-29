package com.zxl.webexp11.controller;

import com.zxl.webexp11.Dao.impl.StudentDaoImp;
import com.zxl.webexp11.pojo.Student;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentDaoImp sdi; // 注入StudentDaoImp实现类

    // 使用LogFactory获取日志记录器
    private static Log logger = LogFactory.getLog(StudentController.class);

    // 处理映射到URL /find-mystudent的POST请求
    @PostMapping("/find-mystudent")
    public String studentFinder(@RequestParam("name") String name, @RequestParam("gender") String gender, Model model, ModelAndView modelAndView) {
        Student stu = new Student();
        stu.setName(name);
        stu.setGender(gender);
        model.addAttribute("stu", stu); // 将单个学生对象添加到模型中

        List<Student> stus = new ArrayList<>(); // 创建学生列表
        stus = sdi.findStudents(stu); // 调用数据访问对象的方法查找学生
        model.addAttribute("stus", stus); // 将学生列表添加到模型中

        return "showStudent.jsp"; // 返回视图名称，通常对应于一个HTML页面
    }
}