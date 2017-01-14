package com.courses.spring.controller;

import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Mark;
import com.courses.spring.model.Student;
import com.courses.spring.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional(rollbackFor = Exception.class)
public class MarkController {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MarkDao markDao;

    @RequestMapping(value = "/insertMark.html", method = RequestMethod.POST)
    public String insertMark(@RequestParam("id") int id, @RequestParam("subject") int subjectId, @RequestParam("mark") int mark ) {
        Subject subject = subjectDao.getSubjectById(subjectId);
        Student student = studentDao.getStudentById(id);
        Mark mark1 = new Mark();
        mark1.setMark(mark);
        mark1.setStudent(student);
        mark1.setSubject(subject);
        markDao.insertMark(mark1);
        return "redirect:/infoStudent.html?id=" + id;
    }


    @RequestMapping(value = "/deleteMark.html", method = RequestMethod.GET)
    public ModelAndView deleteMark(@RequestParam(value = "id", required = false) Integer id,
                                   @RequestParam(value="markId", required = false) Integer markId) {
        ModelAndView modelAndView = new ModelAndView();
        if (markId == null || markDao.getMarkById(markId) == null) {
            modelAndView.addObject("message", "There is no mark with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        markDao.deleteMark(markId);
        modelAndView.setViewName("redirect:/infoStudent.html?id=" + id);
        return modelAndView;
    }
}
