package com.courses.spring.dao.impl;


import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("studentDao")
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Student getStudentById(int id) {
        return (Student) getSession().load(Student.class, new Integer(id));
    }

    @Override
    public List<Student> getAllStudent() {
        Criteria criteria = getSession().createCriteria(Student.class);
        return (List<Student>) criteria.list();
    }

    @Override
    public void insertStudent(Student student) {
        getSession().save(student);
    }

    @Override
    public void insertListStudent(List<Student> students) {
        for (Student student : students) {
            insertStudent(student);
        }
    }

    @Override
    public void deleteStudent(int id) {
        getSession().delete(getSession().load(Student.class, new Integer(id)));
    }

    @Override
    public void deleteStudent(Student student) {
        getSession().delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        getSession().update(student);
    }
}
