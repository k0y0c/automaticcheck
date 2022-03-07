package cn.edu.tynu.service;
import cn.edu.tynu.domain.User;
import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> findAll();
}
