package com.courses.spring.service.impl;

import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import com.courses.spring.service.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subjectService")
@Transactional(rollbackFor = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject getSubjectById(int id) {
        return subjectDao.getSubjectById(id);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public void insertSubject(Subject subject) {
        subjectDao.insertSubject(subject);
    }

    @Override
    public void insertListSubject(List<Subject> subjects) {
        subjectDao.insertListSubject(subjects);
    }

    @Override
    public void deleteSubject(int id) {
        subjectDao.deleteSubject(id);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectDao.deleteSubject(subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }
}
