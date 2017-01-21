package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.model.Student;
import com.courses.spring.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class implements {@code StudentService} interface and realize
 * its methods for {@code StudentServiceImpl} objects management.
 */

@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * Method call {@code StudentDao} to return
     * user record from DB by its id.
     */

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    /**
     * Method call {@code StudentDao} to return all
     * student records from DB.
     */

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    /**
     * Method call {@code StudentDao} to insert student record to DB.
     * @param student {@code Student} object that contains all needed
     * information for creating Student record.
     */

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    /**
     * Method call {@code StudentDao} delete
     * student record from DB by its id.
     */

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    /**
     * Method call {@code StudentDao} to delete student record from DB.
     * @param student contains information needed for delete
     */

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    /**
     * Method call {@code StudentDao} to update
     * student record from DB.
     */

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
}
