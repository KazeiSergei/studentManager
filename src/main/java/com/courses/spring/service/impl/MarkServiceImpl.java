package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.model.Mark;
import com.courses.spring.service.interfaces.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("markService")
@Transactional(rollbackFor = Exception.class)
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;

    @Override
    public Mark getMarkById(int id) {
        return markDao.getMarkById(id);
    }

    @Override
    public List<Mark> getAllMark() {
        return markDao.getAllMark();
    }

    @Override
    public void insertMark(Mark mark) {
        markDao.insertMark(mark);
    }

    @Override
    public void insertListMark(List<Mark> marks) {
        markDao.insertListMark(marks);
    }

    @Override
    public void deleteMark(int id) {
        markDao.deleteMark(id);
    }

    @Override
    public void deleteMark(Mark mark) {
        markDao.deleteMark(mark);
    }

    @Override
    public void updateMark(Mark mark) {
        markDao.updateMark(mark);
    }
}
