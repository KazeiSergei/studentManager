package com.courses.spring.service.interfaces;

import com.courses.spring.model.User;

import java.util.List;

/**
 * This interface define methods for working with {@code User}
 * objects.
 */

public interface UserService {

    /**
     * Method gives user bean by id.
     */

    User getUserById(int id);

    /**
     * Method gives list of {@code User} objects. {@code User}
     * contains information from several tables in a DB.
     */

    List<User> getAllUser();

    /**
     * Method occur inserting of {@code User} record.
     *
     * @param user {@code User} object that contains all needed
     * information for creating user record.
     */

    void insertUser(User user);

    /**
     * Method occur deleting of {@code User} record in a DB
     * by user id.
     */

    void deleteUser(int id);

    /**
     * Method provides deleting of {@code User} record in a DB.
     * @param user contains information needed for delete
     */

    void deleteUser(User user);

    /**
     * Method provides update of user record.
     * @param user contains information needed for update
     */

    void updateUser(User user);

    /**
     * Method gives user bean by login.
     */

    User getByLogin(String login);
}
