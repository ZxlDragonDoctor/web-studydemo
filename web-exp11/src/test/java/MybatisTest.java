import com.zxl.webexp11.pojo.Student;
import com.zxl.webexp11.util.MyBatisUtil;
import com.zxl.webexp11.mappers.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> lists = mapper.findAllStudents();
        for (Student student : lists) {
            System.out.println(student);
        }
        session.commit();
        session.close();
    }
    @Test
    public void findStudentByIdTest() {
        SqlSession session = MyBatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            Student student = mapper.findStudentById2(20220009);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("查无此记录");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.commit();
            session.close();
        }
    }
    @Test
    public void updateStudentTest() {
        SqlSession session = MyBatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            Student student = new Student(20221020, "张明宇", "女", LocalDate.of(2000, 5, 10), "987654321");
            int rows = mapper.updateStudent(student);
            if (rows == 1) {
                System.out.println("记录更新成功");
            } else {
                System.out.println("记录更新失败");
            }
        } finally {
            session.commit();
            session.close();
        }
    }
    @Test
    public void deleteStudentTest() {
        SqlSession session = MyBatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("studId", 20221020);
            int rows = mapper.deleteStudent(params);
            if (rows == 1) {
                System.out.println("成功删除" + rows + "条记录");
            } else {
                System.out.println("删除记录失败");
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
