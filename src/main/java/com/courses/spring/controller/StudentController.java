package com.courses.spring.controller;


import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Mark;
import com.courses.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(value = "/createStudent.html", method = RequestMethod.GET)
    public ModelAndView createStudentPage() {
        return new ModelAndView("editStudent", "student", new Student());
    }

    @RequestMapping(value = "/createStudent.html", method = RequestMethod.POST)
    public String addStudentToDB(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        }
        studentDao.insertStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateStudent.html", method = RequestMethod.GET)
    public ModelAndView pageForUpdate(@RequestParam("id") Integer id) {
        Student student = studentDao.getStudentById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("editStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudent.html", method = RequestMethod.POST)
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        } else if (null == studentDao.getStudentById(student.getId())) {
            return "redirect:/";
        }
        studentDao.updateStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id") Integer id) {
        if (null == studentDao.getStudentById(id)) {
            return "redirect:/";
        } else {
            Student student = studentDao.getStudentById(id);
            Set<Mark> marks = student.getMarks();
            for (Mark mark : marks) {
                markDao.deleteMark(mark.getId());
            }
            studentDao.deleteStudent(id);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/infoStudent.html", method = RequestMethod.GET)
    public ModelAndView infoStudent(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentDao.getAllStudent();
        boolean isStudent = false;
        for(Student student: studentList){
            if(student.getId()==id){
                isStudent = true;
            }
        }
        if(!isStudent){
            modelAndView.addObject("message","There is no student with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        modelAndView.addObject("student", studentDao.getStudentById(id));
        modelAndView.addObject("id", id);
        modelAndView.addObject("subjects", subjectDao.getAllSubject());
        modelAndView.setViewName("infoStudent");
        return modelAndView;
    }
}
