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

    public Student getStudentById(int id) {
        return (Student) getSession().load(Student.class, new Integer(id));
    }

    public List<Student> getAllStudent() {
        Criteria criteria = getSession().createCriteria(Student.class);
        return (List<Student>) criteria.list();
    }

    public void insertStudent(Student student) {
        getSession().save(student);
    }

    public void insertListStudent(List<Student> students) {
        for (Student student : students) {
            insertStudent(student);
        }
    }

    public void deleteStudent(int id) {
        getSession().delete(getSession().load(Student.class, new Integer(id)));
    }

    public void deleteStudent(Student student) {
        getSession().delete(student);
    }

    public void updateStudent(Student student) {
        getSession().update(student);
    }
}
