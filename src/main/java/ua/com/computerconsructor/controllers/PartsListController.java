package ua.com.computerconsructor.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.computerconsructor.model.ComputerParts;
import ua.com.computerconsructor.service.ComputerPartsService;

import java.util.List;

@Controller
public class PartsListController {

    private static String currentParam = "all";
    private static Integer currentPage = 1;

    private static final Logger logger = Logger
            .getLogger(PartsListController.class);

    private ComputerPartsService computerPartsService;

    @Autowired
    public void setComputerPartsService(ComputerPartsService computerPartsService) {
        this.computerPartsService = computerPartsService;
    }

    @RequestMapping("/createoffer")
    public String createPart() {

        return "createoffer";
    }

    @RequestMapping("/deletepart")
    public String deletePart() {

        return "deletepart";
    }

    @RequestMapping(value = "/comparts")
    public ModelAndView listOfParts(@RequestParam(required = false) Integer page, @RequestParam(required = false) String param) {
        ModelAndView modelAndView = new ModelAndView("comparts");

        if (page != null) {
            currentPage = page;
        }

        if (param != null) {
            if (param.equals("")) {
                param = "all";
            }
            currentParam = param;
            currentPage = 1;
        }
        int availableComputers = computerPartsService.getComputersCount();
        modelAndView.addObject("availableComputers", availableComputers);

        List<ComputerParts> parts = computerPartsService.listParts(param);
        PagedListHolder<ComputerParts> pagedListHolder = new PagedListHolder<>(parts);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
        if (currentPage == null || currentPage < 1 || currentPage > pagedListHolder.getPageCount()) {
            currentPage = 1;
        }
        modelAndView.addObject("page", currentPage);
        if (currentPage == null || currentPage < 1 || currentPage > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("listParts", pagedListHolder.getPageList());
        } else if (currentPage <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(currentPage - 1);
            modelAndView.addObject("listParts", pagedListHolder.getPageList());
        }

        return modelAndView;
    }

}
