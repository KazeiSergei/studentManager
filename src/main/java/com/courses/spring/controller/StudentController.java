package com.courses.spring.controller;


import com.courses.spring.model.Mark;
import com.courses.spring.model.Student;
import com.courses.spring.service.interfaces.MarkService;
import com.courses.spring.service.interfaces.StudentService;
import com.courses.spring.service.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/createStudent.html", method = RequestMethod.GET)
    public ModelAndView createStudentPage() {
        return new ModelAndView("editStudent", "student", new Student());
    }

    @RequestMapping(value = "/createStudent.html", method = RequestMethod.POST)
    public String addStudentToDB(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        }
        studentService.insertStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateStudent.html", method = RequestMethod.GET)
    public ModelAndView pageForUpdate(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || studentService.getStudentById(id) == null) {
            modelAndView.addObject("message", "There is no student with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        Student student = studentService.getStudentById(id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("editStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudent.html", method = RequestMethod.POST)
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        } else if (null == studentService.getStudentById(student.getId())) {
            return "redirect:/";
        }
        studentService.updateStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteStudent.html", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || studentService.getStudentById(id) == null) {
            modelAndView.addObject("message", "There is no student with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        } else {
            Student student = studentService.getStudentById(id);
            Set<Mark> marks = student.getMarks();
            for (Mark mark : marks) {
                markService.deleteMark(mark.getId());
            }
            studentService.deleteStudent(id);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/infoStudent.html", method = RequestMethod.GET)
    public ModelAndView infoStudent(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || studentService.getStudentById(id) == null) {
            modelAndView.addObject("message", "There is no student with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        modelAndView.addObject("student", studentService.getStudentById(id));
        modelAndView.addObject("id", id);
        modelAndView.addObject("subjects", subjectService.getAllSubject());
        modelAndView.setViewName("infoStudent");
        return modelAndView;
    }
}
