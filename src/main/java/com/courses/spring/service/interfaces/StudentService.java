package com.courses.spring.service.interfaces;


import com.courses.spring.model.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(int id);

    List<Student> getAllStudent();

    void insertStudent(Student student);

    void deleteStudent(int id);

    void deleteStudent(Student student);

    void updateStudent(Student student);

}
