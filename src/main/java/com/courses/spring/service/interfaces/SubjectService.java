package com.courses.spring.service.interfaces;

import com.courses.spring.model.Subject;

import java.util.List;

public interface SubjectService {

    Subject getSubjectById(int id);

    List<Subject> getAllSubject();

    void insertSubject(Subject subject);

    void insertListSubject(List<Subject> subjects);

    void deleteSubject(int id);

    void deleteSubject(Subject subject);

    void updateSubject(Subject subject);
}
