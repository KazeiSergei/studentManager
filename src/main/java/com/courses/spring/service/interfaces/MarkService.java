package com.courses.spring.service.interfaces;

import com.courses.spring.model.Mark;

import java.util.List;

/**
 * This interface define methods for working with {@code Mark}
 * objects.
 */

public interface MarkService {

    /**
     * Method gives mark bean by id.
     */

    Mark getMarkById(int id);

    /**
     * Method gives list of {@code (Mark} objects. {@code (Mark}
     * contains information from several tables in a DB.
     */

    List<Mark> getAllMark();

    /**
     * Method occur inserting of {@code Mark} record.
     * @param mark {@code Mark} object that contains all needed
     * information for creating mark record.
     */

    void insertMark(Mark mark);

    /**
     * Method occur inserting list of {@code Mark} record.
     */

    void insertListMark(List<Mark> marks);

    /**
     * Method occur deleting of {@code Mark} record in a DB
     * by mark id.
     */

    void deleteMark(int id);

    /**
     * Method provides deleting of {@code Mark} record in a DB.
     * @param mark contains information needed for delete
     */

    void deleteMark(Mark mark);

    /**
     * Method provides update of mark record.
     * @param mark contains information needed for update
     */

    void updateMark(Mark mark);
}
