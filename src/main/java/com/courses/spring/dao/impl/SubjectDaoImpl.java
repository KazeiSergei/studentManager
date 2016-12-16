package com.courses.spring.dao.impl;


import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("subjectDao")
@Transactional
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Subject getSubjectById(int id) {
        return (Subject) getSession().load(Subject.class, new Integer(id));
    }

    public List<Subject> getAllSubject() {
        Criteria criteria = getSession().createCriteria(Subject.class);
        return (List<Subject>) criteria.list();
    }

    public void insertSubject(Subject subject) {
        getSession().save(subject);
    }

    public void insertListSubject(List<Subject> subjects) {
        for (Subject subject : subjects) {
            insertSubject(subject);
        }
    }

    public void deleteSubject(int id) {
        getSession().delete(getSession().load(Subject.class, new Integer(id)));
    }

    public void deleteSubject(Subject subject) {
        getSession().delete(subject);
    }

    public void updateSubject(Subject subject) {
        getSession().update(subject);
    }
}
