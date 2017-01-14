package com.courses.spring.dao.impl;


import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("subjectDao")
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Subject getSubjectById(int id) {
        return (Subject) getSession().get(Subject.class, id);
    }

    @Override
    public List<Subject> getAllSubject() {
        Criteria criteria = getSession().createCriteria(Subject.class);
        return (List<Subject>) criteria.list();
    }

    @Override
    public void insertSubject(Subject subject) {
        getSession().save(subject);
    }

    @Override
    public void insertListSubject(List<Subject> subjects) {
        for (Subject subject : subjects) {
            insertSubject(subject);
        }
    }

    @Override
    public void deleteSubject(int id) {
        getSession().delete(getSession().load(Subject.class, new Integer(id)));
    }

    @Override
    public void deleteSubject(Subject subject) {
        getSession().delete(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        getSession().update(subject);
    }
}
