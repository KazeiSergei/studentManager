package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.model.Mark;
import com.courses.spring.service.interfaces.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class implements {@code MarkService} interface and realize
 * its methods for {@code MarkServiceImpl} objects management.
 */

@Service("markService")
@Transactional(rollbackFor = Exception.class)
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;

    /**
     * Method call {@code MarkDao} to return
     * user record from DB by its id.
     */

    @Override
    public Mark getMarkById(int id) {
        return markDao.getMarkById(id);
    }

    /**
     * Method call {@code MarkDao} to return all
     * mark records from DB.
     */

    @Override
    public List<Mark> getAllMark() {
        return markDao.getAllMark();
    }

    /**
     * Method call {@code MarkDao} to insert mark record to DB.
     * @param mark {@code Mark} object that contains all needed
     * information for creating mark record.
     */

    @Override
    public void insertMark(Mark mark) {
        markDao.insertMark(mark);
    }

    /**
     * Method call {@code MarkDao} to insert list mark record to DB.
     */

    @Override
    public void insertListMark(List<Mark> marks) {
        markDao.insertListMark(marks);
    }

    /**
     * Method call {@code MarkDao} to delete
     * mark record from DB by its id.
     */

    @Override
    public void deleteMark(int id) {
        markDao.deleteMark(id);
    }

    /**
     * Method call {@code MarkDao} to delete mark record from DB.
     * @param mark contains information needed for delete
     */

    @Override
    public void deleteMark(Mark mark) {
        markDao.deleteMark(mark);
    }

    /**
     * Method call {@code MarkDao} to update
     * Mark record from DB.
     */

    @Override
    public void updateMark(Mark mark) {
        markDao.updateMark(mark);
    }
}
