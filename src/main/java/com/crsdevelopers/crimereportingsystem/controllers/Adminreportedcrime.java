package com.crsdevelopers.crimereportingsystem.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.services.ReportService;

@Controller
@RequestMapping("admin/reported/crime")
public class Adminreportedcrime {
	private ReportService reportservice;
	public Adminreportedcrime(ReportService reportservice) {
		this.reportservice=reportservice;
	}
	@ModelAttribute(name="all_report")
	public List<Report> getAll() {
		 List<Report> allReport = (List<Report>)reportservice.getAll();
		 return allReport;
	}
@GetMapping
	public String showLoginSignupForm(Model model) {
		return "admin_reported_crime";
	}
	

}
