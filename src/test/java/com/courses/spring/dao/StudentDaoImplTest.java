package com.courses.spring.dao;


import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.model.Student;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentDaoImplTest extends EntityDaoImplTest {

    @Autowired
    StudentDao studentDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Student.xml"));
        return dataSet;
    }

    @Test
    public void getStudentById() {
        Assert.assertNotNull(studentDao.getStudentById(1));
        Assert.assertEquals(studentDao.getStudentById(2).getFirstName(), "Artem");
        Assert.assertEquals(studentDao.getStudentById(2).getSecondName(), "Pozniak");
    }

    @Test
    public void findAllStudents() {
        Assert.assertEquals(studentDao.getAllStudent().size(), 2);
    }


    @Test
    public void deleteStudentById() {
        studentDao.deleteStudent(1);
        Assert.assertEquals(studentDao.getAllStudent().size(), 1);
    }

    @Test
    public void deleteStudent() {
        studentDao.deleteStudent(studentDao.getStudentById(1));
        Assert.assertEquals(studentDao.getAllStudent().size(), 1);
    }

    @Test
    public void insertStudent() {
        studentDao.insertStudent(getSampleStudent());
        Assert.assertEquals(studentDao.getAllStudent().size(), 3);
    }


    @Test
    public void updateStudentTest() {
        studentDao.updateStudent(getSampleStudentForUpdate());
        Assert.assertEquals(studentDao.getStudentById(2).getFirstName(), "Pasha");
    }

    public Student getSampleStudent() {
        Student student = new Student();
        student.setId(3);
        student.setSecondName("Pasha");
        student.setSecondName("Kovalev");
        return student;
    }

    public Student getSampleStudentForUpdate() {
        Student student = new Student();
        student.setId(2);
        student.setFirstName("Pasha");
        student.setSecondName("Kovalev");
        return student;
    }
}
