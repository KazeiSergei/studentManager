package com.courses.spring.dao.interfaces;


import com.courses.spring.model.Subject;

import java.util.List;

public interface SubjectDao {

    Subject getSubjectById(int id);

    List<Subject> getAllSudject();

    void insertSubject(Subject subject);

    void insertListSubject(List<Subject> subjects);

    void deleteSubject(int id);

    void deleteSubject(Subject subject);

    void updateSubject(Subject subject);

}
