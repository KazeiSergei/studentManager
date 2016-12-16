package com.courses.spring.controller;

import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Mark;
import com.courses.spring.model.Student;
import com.courses.spring.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentDao.getAllStudent());
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    public ModelAndView getStudentById(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", studentDao.getStudentById(id));
        modelAndView.setViewName("student");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createStudentPage() {
        return new ModelAndView("createStudent", "student", new Student());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addStudentToDB(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createStudent";
        }
        studentDao.insertStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/pageForUpdating", method = RequestMethod.GET)
    public ModelAndView pageForUpdate(@RequestParam("id") Integer id) {
        Student student = studentDao.getStudentById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("pageForUpdating");
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pageForUpdating";
        }
        studentDao.updateStudent(student);
        return "redirect:/getStudentById?id=" + student.getId();
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id") Integer id) {
        studentDao.deleteStudent(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/getStudentWithMarkAndSubject", method = RequestMethod.GET)
    public ModelAndView getStudentWithMarkAndSudject(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", studentDao.getStudentById(id));
        modelAndView.addObject("id", id);
        modelAndView.addObject("subjects", subjectDao.getAllSubject());
        modelAndView.setViewName("getStudentWithMarkAndSubject");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteMark/{id}", method = RequestMethod.POST)
    public String deleteMark(@PathVariable("id") int id, HttpServletRequest request) {
        String[] marksId = request.getParameterValues("markId");
        for (String markId : marksId) {
            markDao.deleteMark(Integer.parseInt(markId));
        }
        return "redirect:/getStudentWithMarkAndSubject?id=" + id;
    }

    @RequestMapping(value = "/insertMark/{student.id}", method = RequestMethod.POST)
    public String insertMark(@PathVariable("student.id") int id, @RequestParam("subject") int subjectId, @RequestParam("mark") int mark ) {
        Subject subject = subjectDao.getSubjectById(subjectId);
        Student student = studentDao.getStudentById(id);
        Mark mark1 = new Mark();
        mark1.setMark(mark);
        mark1.setStudent(student);
        mark1.setSubject(subject);
        markDao.insertMark(mark1);
        return "redirect:/getStudentWithMarkAndSubject?id=" + id;
    }

}
