package cn.edu.tynu.service.impl;

import cn.edu.tynu.dao.UserDao;
import cn.edu.tynu.domain.User;
import cn.edu.tynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        System.out.println("业务层：添加用户信息...");
        userDao.addUser(user);
    }

    @Override
    public List<User> findAll() {
        //System.out.println("业务层：查询所有的用户...");
        return userDao.findAll();
    }
}
