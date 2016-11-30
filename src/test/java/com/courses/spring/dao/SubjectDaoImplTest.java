package com.courses.spring.dao;


import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubjectDaoImplTest extends EntityDaoImplTest {

    @Autowired
    SubjectDao subjectDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Subject.xml"));
        return dataSet;
    }

    @Test
    public void getSubjectById() {
        Assert.assertNotNull(subjectDao.getSubjectById(1));
        Assert.assertEquals(subjectDao.getSubjectById(2).getName(), "ENGLISH");
    }

    @Test
    public void findAllSubject() {
        Assert.assertEquals(subjectDao.getAllSudject().size(), 2);
    }


    @Test
    public void deleteSubjectById() {
        subjectDao.deleteSubject(1);
        Assert.assertEquals(subjectDao.getAllSudject().size(), 1);
    }

    @Test
    public void deleteSubject() {
        subjectDao.deleteSubject(subjectDao.getSubjectById(1));
        Assert.assertEquals(subjectDao.getAllSudject().size(), 1);
    }

    @Test
    public void insertSubject() {
        subjectDao.insertSubject(getSampleSubject());
        Assert.assertEquals(subjectDao.getAllSudject().size(), 3);
    }


    @Test
    public void updateSubjectTest() {
        subjectDao.updateSubject(getSampleSubjectForUpdate());
        Assert.assertEquals(subjectDao.getSubjectById(2).getName(), "PHYSICS");
    }

    public Subject getSampleSubject() {
        Subject subject = new Subject();
        subject.setId(3);
        subject.setName("HISTORY");
        return subject;
    }

    public Subject getSampleSubjectForUpdate() {
        Subject subject = new Subject();
        subject.setId(2);
        subject.setName("PHYSICS");
        return subject;
    }

}
