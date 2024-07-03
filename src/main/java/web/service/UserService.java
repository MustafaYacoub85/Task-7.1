package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User readUser(Long id);
    void createOrUpdateUser(User user);
    void deleteUser(Long id);
}
