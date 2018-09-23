package ua.com.computerconsructor.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.computerconsructor.model.ComputerParts;
import ua.com.computerconsructor.service.ComputerPartsService;

import java.util.List;

@Controller
public class PartsListController {

    private static String currentParam = "all";
    private static Integer currentPage = 1;

    private ComputerPartsService computerPartsService;

    @Autowired
    public void setComputerPartsService(ComputerPartsService computerPartsService) {
        this.computerPartsService = computerPartsService;
    }

    @RequestMapping(value = "/comparts/")
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

    //Add a new part

    @RequestMapping(value = "/addpart", method = RequestMethod.GET)
    public String addPart() {
        return "addpart";
    }

    @RequestMapping(value = "/createPart", method = RequestMethod.POST)
    public String addPart(@RequestParam(required = false) String partName,
                          @RequestParam(required = false) boolean paramMandatory,
                          @RequestParam(required = false) Integer partsQuantity) {
        if (!partName.equals(null) && !partsQuantity.equals(null)) {
            ComputerParts newPart = new ComputerParts();
            newPart.setPartName(partName);
            newPart.setMandatory(paramMandatory);
            newPart.setQuantity(partsQuantity);
            computerPartsService.addPart(newPart);
        }
        return "redirect:/comparts/";
    }


    //Delete part from a database
    @RequestMapping(value = "/delete/{id}")
    public String removePart(@PathVariable("id") int id) {
        computerPartsService.deleteById(id);
        return "redirect:/comparts/";
    }

    //Edit part in a list
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editPart(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        if (id != 0) {
            modelAndView.addObject("computerParts", computerPartsService.getById(id));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/editPart", method = RequestMethod.POST)
    public String updatePart(@ModelAttribute("editedPart") ComputerParts editedPart) {
        if (editedPart.getId() != 0) {
            computerPartsService.editPart(editedPart);
            System.out.println("Part was edited");
        }
        return "redirect:/comparts/";
    }

}
