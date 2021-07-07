import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.UserDao;
import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.User;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(3);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.addUser(new User(2, "我是2号", "111111"));

        System.out.println("添加后结果：" + res);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getTeachers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = mapper.getTeacherList();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test
    public void getTeacherWithAllStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = mapper.getTeacherWithAllStudent(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getTeacherWithAllStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = mapper.getTeacherWithAllStudent2(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getStudentList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = mapper.getStudentWithTeacher();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void getStudentList2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = mapper.getStudentWithTeacher2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
