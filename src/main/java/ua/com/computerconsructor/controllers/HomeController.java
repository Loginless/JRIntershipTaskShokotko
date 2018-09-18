package ua.com.computerconsructor.controllers;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger logger = Logger
            .getLogger(PartsListController.class);

    @RequestMapping("/")
    public String showHome() {
        return "home";
    }

}
