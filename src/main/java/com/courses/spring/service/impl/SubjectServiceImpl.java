package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import com.courses.spring.service.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class implements {@code SubjectService} interface and realize
 * its methods for {@code SubjectServiceImpl} objects management.
 */

@Service("subjectService")
@Transactional(rollbackFor = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    /**
     * Method call {@code SubjectDao} to return
     * user record from DB by its id.
     */

    @Override
    public Subject getSubjectById(int id) {
        return subjectDao.getSubjectById(id);
    }

    /**
     * Method call {@code SubjectDao} to return all
     * subject records from DB.
     */

    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    /**
     * Method call {@code SubjectDao} to insert subject record to DB.
     * @param subject {@code Subject} object that contains all needed
     * information for creating subject record.
     */

    @Override
    public void insertSubject(Subject subject) {
        subjectDao.insertSubject(subject);
    }

    /**
     * Method call {@code SubjectDao} to insert list subject record to DB.
     */

    @Override
    public void insertListSubject(List<Subject> subjects) {
        subjectDao.insertListSubject(subjects);
    }

    /**
     * Method call {@code SubjectDao} to delete
     * subject record from DB by its id.
     */

    @Override
    public void deleteSubject(int id) {
        subjectDao.deleteSubject(id);
    }

    /**
     * Method call {@code SubjectDao} to delete subject record from DB.
     * @param subject contains information needed for delete
     */

    @Override
    public void deleteSubject(Subject subject) {
        subjectDao.deleteSubject(subject);
    }

    /**
     * Method call {@code SubjectDao} to update
     * subject record from DB.
     */

    @Override
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }
}
