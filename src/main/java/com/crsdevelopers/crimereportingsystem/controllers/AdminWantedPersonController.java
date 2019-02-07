package com.crsdevelopers.crimereportingsystem.controllers;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.WantedPersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin/wantedPerson")
public class AdminWantedPersonController {
	private WantedPersonService wpService;
	private FileStorageService fileStorageService;
	
	@Autowired
	public AdminWantedPersonController(WantedPersonService wpService, FileStorageService fileStorageService) {
		this.wpService = wpService;
		this.fileStorageService = fileStorageService;
		}
	
	@ModelAttribute(name="wp")
	public WantedPerson wp(Model model) {
		return new WantedPerson();
	}
	
	@ModelAttribute(name="all_wp")
	public List<WantedPerson> getAll() {
		List<WantedPerson> allWp = wpService.getAll(); 
		return allWp; 
	}
	
	@GetMapping
	public String showForm() {
		return "admin_wp";
	}
	
	@RequestMapping("deleteWp")
	public String deleteWp(@RequestParam("id") Long id) {
		WantedPerson wp = new WantedPerson();
		wp.setId(id);
		wpService.delete(wp);
		return "redirect:/admin/wantedPerson/#wp_list";
		}
	
	@PostMapping
	public String processPost( @RequestParam("file") MultipartFile f, @Valid WantedPerson wp, Errors errors) throws IOException{
		if (errors.hasErrors()) {
			return "admin_wp";
		}
		String fileName = fileStorageService.storeFile(f);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/wantedPerson/downloadFile/").path(fileName).toUriString();
		wp.setPicturePath(fileDownloadUri);
		WantedPerson savedWp = wpService.save(wp);
		log.info("News object after persisting: " + savedWp);
		
		return "redirect:/admin/wantedPerson/#wp_list";	
	}
	
	@GetMapping("/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		WantedPerson wpEdit = wpService.getById(id);
		model.addAttribute("wp",wpEdit);
		return "admin_edit_wp";	
	}
	
	@PostMapping("/update/{id}")
	public String processUpdate(@PathVariable("id") Long id, @Valid WantedPerson wpEdit, Errors errors) {
		if (errors.hasErrors()) {
			wpEdit.setId(id);
			return "admin_edit_wp";
		}
		wpService.update(wpEdit);
		return "redirect:/admin/wantedPerson/#wp_list";	
	}
}

