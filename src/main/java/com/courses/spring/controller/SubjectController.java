package com.courses.spring.controller;


import com.courses.spring.model.Subject;
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

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/createSubject.html", method = RequestMethod.GET)
    public ModelAndView createSubject() {
        return new ModelAndView("editSubject", "subject", new Subject());
    }

    @RequestMapping(value = "/createSubject.html", method = RequestMethod.POST)
    public String addSubjectsToDB(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSubject";
        }
        subjectService.insertSubject(subject);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateSubject.html", method = RequestMethod.GET)
    public ModelAndView updateSubject(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || subjectService.getSubjectById(id) == null) {
            modelAndView.addObject("message", "There is no subject with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        Subject subject = subjectService.getSubjectById(id);
        modelAndView.addObject("subject", subject);
        modelAndView.setViewName("editSubject");
        return modelAndView;
    }

    @RequestMapping(value = "/updateSubject.html", method = RequestMethod.POST)
    public String updateSubject(@Valid @ModelAttribute("subject") Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSubject";
        }
        subjectService.updateSubject(subject);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteSubject.html", method = RequestMethod.GET)
    public ModelAndView deleteSubject(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || subjectService.getSubjectById(id) == null) {
            modelAndView.addObject("message", "There is no subject with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        Subject subject = subjectService.getSubjectById(id);
        subjectService.deleteSubject(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
