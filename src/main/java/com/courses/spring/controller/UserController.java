package com.courses.spring.controller;

import com.courses.spring.model.User;
import com.courses.spring.service.interfaces.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration.html", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/createUser.html", method = RequestMethod.POST)
    public String addStudentToDB(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else if (null == user.getRole()) {
            user.setRole("USER");
        }
        userService.insertUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateUser.html", method = RequestMethod.GET)
    public ModelAndView pageForUser(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || userService.getUserById(id) == null) {
            modelAndView.addObject("message", "There is no user with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        }
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/updateUser.html", method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        } else if (null == userService.getUserById(user.getId())) {
            modelAndView.addObject("message", "There is no user with such id");
            modelAndView.setViewName("incorrectId");
        }
        userService.updateUser(user);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteUser.html", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null || userService.getUserById(id) == null) {
            modelAndView.addObject("message", "There is no user with such id");
            modelAndView.setViewName("incorrectId");
            return modelAndView;
        } else {
            userService.deleteUser(id);
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
    }

}
