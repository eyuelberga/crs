package com.crsdevelopers.crimereportingsystem.controllers;



import java.io.IOException;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;

@Controller
@RequestMapping("user/missingPerson")
public class UserMissingPersonController {
	private MissingPersonService missingPersonService;
	private FileStorageService fileStorageService;
	@Autowired
	public UserMissingPersonController(MissingPersonService missingPersonService, FileStorageService fileStorageService) {
		this.missingPersonService = missingPersonService;
		this.fileStorageService = fileStorageService;
	}
	
	
	
	@GetMapping()
    public String showForm(Model model) {
		model.addAttribute("missingPerson", new MissingPerson());
        return "user_missingPerson";
    }

    @PostMapping()
    public String submitMissingPersonForm(@RequestParam("file") MultipartFile f, @ModelAttribute @Valid MissingPerson missingPerson, BindingResult bindingResult,@AuthenticationPrincipal User user, RedirectAttributes atts ) throws IOException {

        if (bindingResult.hasErrors()) {
            return "user_missingPerson";
        }
        String fileName = fileStorageService.storeFile(f);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/missingPerson/downloadFile/").path(fileName).toUriString();
		missingPerson.setPicturePath(fileDownloadUri);
		
        missingPerson.setUser(user);
        missingPersonService.save(missingPerson);
        atts.addFlashAttribute("successMessage", "Missing Person Report Sent");

        return "redirect:/user";
    }
    
    

}
