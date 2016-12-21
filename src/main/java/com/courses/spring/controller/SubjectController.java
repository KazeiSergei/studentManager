package com.courses.spring.controller;


import com.courses.spring.dao.interfaces.SubjectDao;
import com.courses.spring.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SubjectController {

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(value = "/createSubject.html", method = RequestMethod.GET)
    public ModelAndView createSubject() {
        return new ModelAndView("editSubject", "subject", new Subject());
    }

    @RequestMapping(value = "/createSubject.html", method = RequestMethod.POST)
    public String addSubjectsToDB(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSubject";
        }
        subjectDao.insertSubject(subject);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateSubject.html", method = RequestMethod.GET)
    public ModelAndView updateSubject(@RequestParam("id") Integer id) {
        Subject subject = subjectDao.getSubjectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subject", subject);
        modelAndView.setViewName("editSubject");
        return modelAndView;
    }

    @RequestMapping(value = "/updateSubject.html", method = RequestMethod.POST)
    public String updateSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSubject";
        }
        subjectDao.updateSubject(subject);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteSubject.html", method = RequestMethod.GET)
    public String deleteSubject(@RequestParam("id") Integer id) {
        Subject subject = subjectDao.getSubjectById(id);
        subjectDao.deleteSubject(id);
        return "redirect:/";
    }
}
