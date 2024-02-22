package com.example.medOptix.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.example.medOptix.model.ClinicModel;
import com.example.medOptix.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping("/clinicDetails")
    public String clinicDetails(Model model){
        model.addAttribute("clinicDetails",searchService.getAllClinicDetails());
        return "clinicDetails";
    }

}
