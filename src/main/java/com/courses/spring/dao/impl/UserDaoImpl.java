package com.courses.spring.dao.impl;


import com.courses.spring.dao.interfaces.UserDao;
import com.courses.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getUserById(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public void insertUser(User user) {
        getSession().save(user);
    }

    @Override
    public void deleteUser(int id) {
        getSession().delete(getSession().get(User.class, id));
    }

    @Override
    public void deleteUser(User user) {
        getSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public User getByLogin(String login) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }
}
