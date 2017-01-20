package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.UserDao;
import com.courses.spring.model.User;
import com.courses.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class implements {@code UserService} interface and realize
 * its methods for {@code UserServiceImpl} objects management.
 */

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Method call {@code UserDao} to return
     * user record from DB by its id.
     */

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    /**
     * Method call {@code UserDao} to return all
     * user records from DB.
     */

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    /**
     * Method call {@code UserDao} to insert
     * user record to DB.
     */

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    /**
     * Method provide deleting a user record from DB
     * by its id.
     */

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    /**
     * Method provide deleting a user record from DB.
     * @param user contains information needed for delete
     */

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    /**
     * Method call {@code UserDao} to update
     * user record from DB.
     */

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * Method call {@code UserDao} to return
     * user record from DB by its login.
     */

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
