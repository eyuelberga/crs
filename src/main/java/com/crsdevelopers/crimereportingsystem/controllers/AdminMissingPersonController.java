package com.crsdevelopers.crimereportingsystem.controllers;


import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;

@Controller
@RequestMapping("admin/missingPerson")
public class AdminMissingPersonController {

		private MissingPersonService missingPersonService;
		private FileStorageService fileStorageService;
		
		@Autowired
		public AdminMissingPersonController(MissingPersonService missingPersonService, FileStorageService fileStorageService) {
			this.missingPersonService = missingPersonService;
			this.fileStorageService = fileStorageService;
			}
		
		
		@ModelAttribute(name="all_mp")
		public List<MissingPerson> getAll() {
			List<MissingPerson> allMp = missingPersonService.getAll(); 
			return allMp; 
		}
		
		@GetMapping()
	    public String showForm(Model model) {
			model.addAttribute("missingPerson", new MissingPerson());
	        return "admin_missingPerson";
	    }
		
		@RequestMapping("deleteMp")
		public String deleteMp(@RequestParam("id") Long id) {
			MissingPerson mp = new MissingPerson();
			mp.setId(id);
			missingPersonService.delete(mp);
			return "redirect:/admin/missingPerson/#mp_list";
			}
		
		@PostMapping()
	    public String submitMissingPersonForm(@RequestParam("file") MultipartFile f, @ModelAttribute @Valid MissingPerson missingPerson, BindingResult bindingResult,@AuthenticationPrincipal User user) throws IOException {

	        if (bindingResult.hasErrors()) {
	            return "admin_missingPerson";
	        }
	        String fileName = fileStorageService.storeFile(f);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/missingPerson/downloadFile/").path(fileName).toUriString();
			missingPerson.setPicturePath(fileDownloadUri);
			
	        missingPerson.setUser(user);
	        missingPersonService.save(missingPerson);

	        return "redirect:/admin/missingPerson/#mp_list";
	    }
	}

