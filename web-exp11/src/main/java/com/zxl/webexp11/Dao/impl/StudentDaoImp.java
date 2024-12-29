package com.zxl.webexp11.Dao.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.zxl.webexp11.Dao.StudentDao;
import com.zxl.webexp11.pojo.Student;
import com.zxl.webexp11.util.MyBatisUtil;
import com.zxl.webexp11.mappers.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImp implements StudentDao {
    // 使用LogFactory获取日志记录器
    private static Log logger = LogFactory.getLog(StudentDaoImp.class);

    @Override
    public List<Student> findStudents(Student student) {
            logger.info(student); // 记录学生信息
        SqlSession session = MyBatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> result = null;
        try {
            result = mapper.findStudent1(student); // 调用mapper方法查询学生
            if (result == null) {
                System.out.println("查无此记录");
            }
        } catch (Exception e) {
            System.out.println(e); // 打印异常信息
        } finally {
            session.commit(); // 提交事务
            session.close(); // 关闭SqlSession
        }
        return result; // 返回查询结果
    }
}