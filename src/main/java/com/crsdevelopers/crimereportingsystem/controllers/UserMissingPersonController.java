package com.crsdevelopers.crimereportingsystem.controllers;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.domains.City;
import com.crsdevelopers.crimereportingsystem.domains.CrimeType;
import com.crsdevelopers.crimereportingsystem.domains.CrimeType.Type;
import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.services.CityService;
import com.crsdevelopers.crimereportingsystem.services.CrimeTypeService;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import com.crsdevelopers.crimereportingsystem.services.ReportService;
import com.crsdevelopers.crimereportingsystem.services.UserService;

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
    public String submitMissingPersonForm(@RequestParam("file") MultipartFile f, @ModelAttribute @Valid MissingPerson missingPerson, BindingResult bindingResult,@AuthenticationPrincipal User user ) throws IOException {

        if (bindingResult.hasErrors()) {
            return "user_missingPerson";
        }
        //File file = new File(missingPerson.getFile());
        //file.getAbsoluteFile();
//        DiskFileItem fileItem = new DiskFileItem("file","application/octet-stream",false,file.getName(),(int) file.length(),file.getParentFile());
//        fileItem.getOutputStream();
        //FileInputStream input = new FileInputStream(file);
        //MultipartFile f = new MockMultipartFile("file",input);
        //MultipartFile f = missingPerson.getFile();
        
        
        //MultipartFile f = new MultipartFile("file",file.getName(),"text/plain",IOUtils.toByteArray(input));
        //MultipartFile f = (MultipartFile) missingPerson.getFile();
        String fileName = fileStorageService.storeFile(f);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/wantedPerson/downloadFile/").path(fileName).toUriString();
		missingPerson.setPicturePath(fileDownloadUri);
		
        missingPerson.setUser(user);
        missingPersonService.save(missingPerson);

        return "redirect:/";
    }
    
    

}
