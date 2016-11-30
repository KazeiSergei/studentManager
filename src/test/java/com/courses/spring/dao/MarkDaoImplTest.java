package com.courses.spring.dao;


import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.model.Mark;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MarkDaoImplTest extends EntityDaoImplTest {

    @Autowired
    MarkDao markDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Mark.xml"));
        return dataSet;
    }

    @Test
    public void getMarkById() {
        Assert.assertNotNull(markDao.getMarkById(1));
        Assert.assertEquals(markDao.getMarkById(2).getMark(), 3);
    }

    @Test
    public void findAllMarks() {
        Assert.assertEquals(markDao.getAllMark().size(), 2);
    }


    @Test
    public void deleteMarkById() {
        markDao.deleteMark(1);
        Assert.assertEquals(markDao.getAllMark().size(), 1);
    }

    @Test
    public void deleteMark() {
        markDao.deleteMark(markDao.getMarkById(1));
        Assert.assertEquals(markDao.getAllMark().size(), 1);
    }

    @Test
    public void insertMark() {
        markDao.insertMark(getSampleMark());
        Assert.assertEquals(markDao.getAllMark().size(), 3);
    }


    @Test
    public void updateMarkTest() {
        markDao.updateMark(getSampleMarkForUpdate());
        Assert.assertEquals(markDao.getMarkById(2).getMark(), 5);
    }

    public Mark getSampleMark() {
        Mark mark = new Mark();
        mark.setId(3);
        mark.setMark(1);
        return mark;
    }

    public Mark getSampleMarkForUpdate() {
        Mark mark = new Mark();
        mark.setId(2);
        mark.setMark(5);
        return mark;
    }
}
