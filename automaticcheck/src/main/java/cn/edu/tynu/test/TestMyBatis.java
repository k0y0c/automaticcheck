package cn.edu.tynu.test;

import cn.edu.tynu.dao.UserDao;
import cn.edu.tynu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    /**
     * 测试查询所有
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //查询所有数据
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //保存
        User user = new User();
        user.setMobile("123456789");
        user.setUsername("asdffds");
        userDao.addUser(user);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
