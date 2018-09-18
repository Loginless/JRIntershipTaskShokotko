package ua.com.computerconsructor.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.computerconsructor.model.ComputerParts;
import ua.com.computerconsructor.service.ComputerPartsService;

import java.io.IOException;
import java.util.List;

@Controller
public class PartsListController {

    private static final Logger logger = Logger
            .getLogger(PartsListController.class);

    private ComputerPartsService computerPartsService;

    @Autowired
    public void setComputerPartsService(ComputerPartsService computerPartsService) {
        this.computerPartsService = computerPartsService;
    }

    @RequestMapping(value = "/comparts")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {

        List<ComputerParts> allParts = computerPartsService.getAll();

        model.setViewName("comparts");
        model.addObject("partsList", allParts);
        return model;
    }


    @RequestMapping("/createoffer")
    public String createPart() {

        return "createoffer";
    }

    @RequestMapping("/deletepart")
    public String deletePart() {

        return "deletepart";
    }
}
