package com.courses.spring.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @RequestMapping("403")
    public String error403() {
        return "errors/403";
    }

    @RequestMapping("404")
    public String error404() {
        return "errors/404";
    }

    @RequestMapping("500")
    public String error500() {
        return "errors/500";
    }
}
