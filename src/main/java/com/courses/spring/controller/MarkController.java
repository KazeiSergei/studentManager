package com.courses.spring.controller;

import com.courses.spring.model.Mark;
import com.courses.spring.model.Student;
import com.courses.spring.model.Subject;
import com.courses.spring.service.interfaces.MarkService;
import com.courses.spring.service.interfaces.StudentService;
import com.courses.spring.service.interfaces.SubjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarkController {

    private static final Logger log = Logger.getLogger(MarkController.class);

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @RequestMapping(value = "/insertMark.html", method = RequestMethod.POST)
    public String insertMark(@RequestParam("id") int id, @RequestParam("subject") int subjectId, @RequestParam("mark") int mark ) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(id);
        log.info("Добавление оценки");
        Mark mark1 = new Mark();
        mark1.setMark(mark);
        mark1.setStudent(student);
        mark1.setSubject(subject);
        markService.insertMark(mark1);
        return "redirect:/infoStudent.html?id=" + id;
    }


    @RequestMapping(value = "/deleteMark.html", method = RequestMethod.GET)
    public ModelAndView deleteMark(@RequestParam(value = "id", required = false) Integer id,
                                   @RequestParam(value="markId", required = false) Integer markId) {
        log.info("Удаление оценки");
        ModelAndView modelAndView = new ModelAndView();
        if (markId == null || markService.getMarkById(markId) == null) {
            modelAndView.addObject("message", "There is no mark with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        markService.deleteMark(markId);
        modelAndView.setViewName("redirect:/infoStudent.html?id=" + id);
        return modelAndView;
    }
}
