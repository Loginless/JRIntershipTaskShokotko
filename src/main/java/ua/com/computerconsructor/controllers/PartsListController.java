package ua.com.computerconsructor.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.computerconsructor.dao.ComputerPartsDao;

import java.io.IOException;

@Controller
public class PartsListController {

    private static final Logger logger = Logger
            .getLogger(PartsListController.class);

    public PartsListController() {
        System.out.println("PartsListController");
    }

    @Autowired
    private ComputerPartsDao computerPartsDao;


    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        model.setViewName("home");
        return model;
    }
}
