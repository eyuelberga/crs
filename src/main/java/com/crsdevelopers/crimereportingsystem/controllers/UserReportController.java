package com.crsdevelopers.crimereportingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/report")
public class UserReportController {
	
	@GetMapping
	public String showReportForm() {
		
		return "user_report";
	}

}
