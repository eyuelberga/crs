package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;

@Controller
@RequestMapping("public")
public class PublicContentController {
	
	private MissingPersonService missingPersonService;
	
	public PublicContentController(MissingPersonService missingPersonService){
		this.missingPersonService = missingPersonService;
	}
	@ModelAttribute(name="all_mp")
	public List<MissingPerson> getAllMP() {
		List<MissingPerson> allMP = missingPersonService.getAll(); 
		return allMP; 
	}
	
	@GetMapping("/missingPerson")
	public String showMissingPerson() {
		return "public_missingPerson";
	}

}
