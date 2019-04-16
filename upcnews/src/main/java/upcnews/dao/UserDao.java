package upcnews.dao;

import org.apache.ibatis.annotations.Param;
import upcnews.bean.User;

import java.util.List;


public interface UserDao {
    int addUser(User user);
    public List<User> findAll() ;
    User getUserById(int id);
    User getUserByUserName(String userName);
    User loginCheck(@Param("userName") String userName,@Param("password") String password);
}
