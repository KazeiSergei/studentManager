package com.courses.spring.service.interfaces;

import com.courses.spring.model.Subject;

import java.util.List;

/**
 * This interface define methods for working with {@code Subject}
 * objects.
 */

public interface SubjectService {

    /**
     * Method gives subject bean by id.
     */

    Subject getSubjectById(int id);

    /**
     * Method gives list of {@code Subject} objects. {@code Subject}
     * contains information from several tables in a DB.
     */

    List<Subject> getAllSubject();

    /**
     * Method occur inserting of {@code Subject} record.
     * @param subject {@code Subject} object that contains all needed
     * information for creating subject record.
     */

    void insertSubject(Subject subject);

    /**
     * Method occur inserting list of {@code Subject} record.
     */

    void insertListSubject(List<Subject> subjects);

    /**
     * Method occur deleting of {@code Subject} record in a DB
     * by subject id.
     */

    void deleteSubject(int id);

    /**
     * Method provides deleting of {@code Subjec} record in a DB.
     * @param subject contains information needed for delete
     */

    void deleteSubject(Subject subject);

    /**
     * Method provides update of subject record.
     * @param subject contains information needed for update
     */

    void updateSubject(Subject subject);
}
