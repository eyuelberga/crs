/**
 * 
 */
package com.crsdevelopers.crimereportingsystem.controllers;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.services.StolenVehicleService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin/stolenVehicle")
public class AdminStolenVehicleController {
	
	private StolenVehicleService svService;
	
	@Autowired
	public AdminStolenVehicleController(StolenVehicleService svService) {
		this.svService = svService;
		
	}
	
//	@ModelAttribute(name="sv")
//	public StolenVehicle sv(Model model) {
//		return new StolenVehicle();
//	}
	
	@ModelAttribute(name="all_sv")
	public List<StolenVehicle> getAll() {
		List<StolenVehicle> allSv = svService.getAll(); 
		return allSv; 
	}
	
	@GetMapping
	public String showSvForm(Model model) {
		model.addAttribute("stolenVehicle", new StolenVehicle());
		return "admin_sv";
	}
	
	@RequestMapping("deleteSv")
	public String deleteSv(@RequestParam("id") Long id) {
		StolenVehicle sv = new StolenVehicle();
		sv.setId(id);
		svService.delete(sv);
		return "redirect:/admin/stolenVehicle/#sv_list";
		
	}
	
	@PostMapping
	public String processSvPost(@ModelAttribute @Valid StolenVehicle stolenVehicle, Errors errors, Model model){
		if (errors.hasErrors()) {
			return "admin_sv";
		}
		StolenVehicle savedSv = svService.save(stolenVehicle);
		log.info("Service object after persisting: " + savedSv);
		
		return "redirect:/admin/stolenVehicle/#sv_list";
		
	}
	
	@GetMapping("/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		StolenVehicle svEdit = svService.getById(id);
		model.addAttribute("stolenVehicle",svEdit);
		return "admin_edit_sv";
		
	}
	@PostMapping("/update/{id}")
	public String processUpdate(@PathVariable("id") Long id, @Valid StolenVehicle stolenVehicle, Errors errors) {
		if (errors.hasErrors()) {
			stolenVehicle.setId(id);
			return "admin_edit_sv";
		}
		svService.update(stolenVehicle);
		
		return "redirect:/admin/stolenVehicle/#sv_list";
		
	}

}