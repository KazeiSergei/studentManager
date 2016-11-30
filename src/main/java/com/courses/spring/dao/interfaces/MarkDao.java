package com.courses.spring.dao.interfaces;


import com.courses.spring.model.Mark;

import java.util.List;

public interface MarkDao {

    Mark getMarkById(int id);

    List<Mark> getAllMark();

    void insertMark(Mark mark);

    void insertListMark(List<Mark> marks);

    void deleteMark(int id);

    void deleteMark(Mark mark);

    void updateMark(Mark mark);
}
