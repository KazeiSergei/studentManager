package com.courses.spring.service.interfaces;


import com.courses.spring.model.Student;

import java.util.List;

/**
 * This interface define methods for working with {@code Student}
 * objects.
 */

public interface StudentService {

    /**
     * Method gives student bean by id.
     */

    Student getStudentById(int id);

    /**
     * Method gives list of {@code Student} objects. {@code Student}
     * contains information from several tables in a DB.
     */

    List<Student> getAllStudent();

    /**
     * Method occur inserting of {@code Student} record.
     * @param student {@code Student} object that contains all needed
     * information for creating student record.
     */

    void insertStudent(Student student);

    /**
     * Method occur deleting of {@code Student} record in a DB
     * by student id.
     */

    void deleteStudent(int id);

    /**
     * Method provides deleting of {@code Student} record in a DB.
     * @param student contains information needed for delete
     */
    void deleteStudent(Student student);

    /**
     * Method provides update of student record.
     * @param student contains information needed for update
     */

    void updateStudent(Student student);

}
