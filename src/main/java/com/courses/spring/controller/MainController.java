package com.courses.spring.controller;

import com.courses.spring.dao.interfaces.MarkDao;
import com.courses.spring.dao.interfaces.StudentDao;
import com.courses.spring.dao.interfaces.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional(rollbackFor = Exception.class)
public class MainController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
        return new ModelAndView("redirect:/index.html");
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentDao.getAllStudent());
        modelAndView.addObject("subjects", subjectDao.getAllSubject());
        modelAndView.addObject("user", getPrincipal());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
