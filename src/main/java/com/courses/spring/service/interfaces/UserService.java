package com.courses.spring.service.interfaces;

import com.courses.spring.model.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getAllUser();

    void insertUser(User user);

    void deleteUser(int id);

    void deleteUser(User user);

    void updateUser(User user);

    User getByLogin(String login);
}
