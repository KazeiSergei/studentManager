package com.courses.spring.dao.impl;


import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.model.Mark;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("markDao")
public class MarkDaoImpl implements MarkDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Mark getMarkById(int id) {
        return (Mark) getSession().get(Mark.class, id);
    }

    @Override
    public List<Mark> getAllMark() {
        Criteria criteria = getSession().createCriteria(Mark.class);
        return (List<Mark>) criteria.list();
    }

    @Override
    public void insertMark(Mark mark) {
        getSession().save(mark);
    }

    @Override
    public void insertListMark(List<Mark> marks) {
        for (Mark mark : marks) {
            insertMark(mark);
        }
    }

    @Override
    public void deleteMark(int id) {
        getSession().delete(getSession().load(Mark.class,new Integer(id)));
    }

    @Override
    public void deleteMark(Mark mark) {
        getSession().delete(mark);
    }

    @Override
    public void updateMark(Mark mark) {
        getSession().update(mark);
    }
}
