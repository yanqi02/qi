package upcnews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upcnews.bean.User;
import upcnews.dao.UserDao;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserById(int id){
        return userDao.getUserById(id);
    }
    public boolean addUser(User user) { return (userDao.addUser(user)==1); }
    public User loginCheck(String userName,String password) { return userDao.loginCheck(userName,password); }
    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }
}
