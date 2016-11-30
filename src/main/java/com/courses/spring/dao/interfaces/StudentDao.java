package com.courses.spring.dao.interfaces;


import com.courses.spring.model.Student;

import java.util.List;

public interface StudentDao {

    Student getStudentById(int id);

    List<Student> getAllStudent();

    void insertStudent(Student student);

    void insertListStudent(List<Student> students);

    void deleteStudent(int id);

    void deleteStudent(Student student);

    void updateStudent(Student student);

}
