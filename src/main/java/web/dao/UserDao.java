package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void createUser(User user);

    User readUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
