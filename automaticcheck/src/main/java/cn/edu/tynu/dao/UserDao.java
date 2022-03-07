package cn.edu.tynu.dao;

import cn.edu.tynu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user(mobile,username,province,city,district,address,title) values(#{mobile},#{username},#{province},#{city},#{district},#{address},#{title})")
    public void addUser(User user);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
