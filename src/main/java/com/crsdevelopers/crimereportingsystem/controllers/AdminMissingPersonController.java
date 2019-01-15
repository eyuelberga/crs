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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin/missing-person")
@SessionAttributes("mp")
public class AdminMissingPersonController {

		private MissingPersonService mpService;
		
		@Autowired
		public AdminMissingPersonController(MissingPersonService mpService) {
			this.mpService = mpService;
			}
		
		@ModelAttribute(name="mp")
		public MissingPerson mp(Model model) {
			return new MissingPerson();
		}
		
		@ModelAttribute(name="all_mp")
		public List<MissingPerson> getAll() {
			List<MissingPerson> allMp = mpService.getAll(); 
			return allMp; 
		}
		
		@GetMapping
		public String showForm() {
			return "admin_mp";
		}
		
		@RequestMapping("deleteMp")
		public String deleteMp(@RequestParam("id") Long id) {
			MissingPerson mp = new MissingPerson();
			mp.setId(id);
			mpService.delete(mp);
			return "redirect:/admin/missing-person/#mp_list";
			}
		
		@PostMapping
		public String processPost( @Valid MissingPerson mp, Errors errors,SessionStatus sessionStatus){
			if (errors.hasErrors()) {
				return "admin_mp";
			}
			MissingPerson savedMp = mpService.save(mp);
			log.info("News object after persisting: " + savedMp);
			sessionStatus.setComplete();
			
			return "redirect:/admin/missing-person/#mp_list";	
		}
		
		@GetMapping("/edit/{id}")
		public String ShowEditForm(@PathVariable("id") Long id, Model model) {
			MissingPerson mpEdit = mpService.getById(id);
			model.addAttribute("mp",mpEdit);
			return "admin_edit_mp";	
		}
		
		@PostMapping("/update/{id}")
		public String processUpdate(@PathVariable("id") Long id, @Valid MissingPerson mpEdit, Errors errors,SessionStatus sessionStatus) {
			if (errors.hasErrors()) {
				mpEdit.setId(id);
				return "admin_edit_mp";
			}
			mpService.update(mpEdit);
			sessionStatus.setComplete();	
			return "redirect:/admin/missing-person/#mp_list";	
		}
	}

