package com.crsdevelopers.crimereportingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.services.ReportService;

@Controller
@RequestMapping("user/report")
public class UserReportController {
	
	private ReportService reportService;
	@Autowired
	public UserReportController(ReportService reportService) {
		this.reportService = reportService;
		
	}
	
	@GetMapping()
    public String showForm(Model model) {
		model.addAttribute("report", new Report());
        return "user_report";
    }

    @PostMapping()
    public String checkPersonInfo(@ModelAttribute @Valid Report report, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        reportService.save(report);

        return "redirect:/admin/news";
    }

}
