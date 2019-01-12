package com.crsdevelopers.crimereportingsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/missing")
public class AdminMissingPersonController {
	@GetMapping
	public String showLoginSignupForm(Model model) {
		return "missing";
	}
	
	
}
