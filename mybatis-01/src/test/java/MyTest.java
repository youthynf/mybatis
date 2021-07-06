import com.dao.UserDao;
import com.pojo.User;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        int res = userMapper.deleteOne(2);
        System.out.println(res);

        // 增删改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.update(new User(4, "hh", "123123"));
        System.out.println(res);

        // 增删改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.addOne(new User(4, "hello", "123456"));
        System.out.println(res);

        // 增删改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}
