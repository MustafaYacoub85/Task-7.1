package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.dao.UserDao;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public User readUser(Long id) {
        return userDao.readUser(id);
    }
    @Transactional
    @Override
    public void createOrUpdateUser(User user) {
        if (user.getId() != null) {
            userDao.updateUser(user);
        } else {
            userDao.createUser(user);
        }

    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
        try {
            userDao.deleteUser(id);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }


}
