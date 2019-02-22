package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.domains.City;
import com.crsdevelopers.crimereportingsystem.domains.CrimeType;
import com.crsdevelopers.crimereportingsystem.domains.CrimeType.Type;
import com.crsdevelopers.crimereportingsystem.services.CityService;
import com.crsdevelopers.crimereportingsystem.services.CrimeTypeService;
import com.crsdevelopers.crimereportingsystem.services.ReportService;

@Controller
@RequestMapping("user/report")
public class UserReportController {
	
	private ReportService reportService;
	private CrimeTypeService crimeTypeService;
	private CityService cityService;
	@Autowired
	public UserReportController(ReportService reportService, CrimeTypeService crimeTypeService, CityService cityService) {
		this.reportService = reportService;
		this.crimeTypeService = crimeTypeService;
		this.cityService = cityService;
		
		
	}
	
	@ModelAttribute
	public void addCrimeTypeToModel(Model model) {
		List<CrimeType> crimeType = new ArrayList<>();
		crimeTypeService.getAll()
							.forEach(i->crimeType.add(i));
		
		Type[] types = CrimeType.Type.values();
		
		for (Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(crimeType, type));
		}
	}
	
	@ModelAttribute(name="cities")
	public List<City> getAll() {
		List<City> cities = cityService.getAll(); 
		return cities; 
	}
	
	public User getUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@ModelAttribute(name="user_reports")
	public List<Report> getAllReports() {
		return  reportService.getBySeenAndUsername(true,getUser()); 
		 
	}
	@ModelAttribute(name="user_unseen_reports")
	public List<Report> getUnseen() {
		return  reportService.getBySeenAndUsername(false, getUser()); 
		 
	}
	
	
	@GetMapping()
    public String showForm(Model model) {
		model.addAttribute("report", new Report());
        return "user_report";
    }

    @PostMapping()
    public String submitReportForm(@RequestParam(value="crime", required = false) Long [] crimeTypes, @ModelAttribute @Valid Report report, BindingResult bindingResult,@AuthenticationPrincipal User user,  RedirectAttributes atts ) {

        if (bindingResult.hasErrors()) {
            return "user_report";
        }
        if(crimeTypes != null) {
        	for(int i = 0; i < crimeTypes.length; i++) {
        		if(crimeTypeService.isFound(crimeTypes[i])) {
        			report.getCrimeType().add(crimeTypeService.getById(crimeTypes[i]));
        			
        		}
        	}
        }
        report.setUser(user);
        reportService.save(report);
        atts.addFlashAttribute("successMessage", "Crime Report Sent");

        return "redirect:/user";
    }
    
    private List<CrimeType> filterByType(List<CrimeType> ingredients, Type type){
		return ingredients
				.stream()
				.filter(x->x.getType().equals(type))
				.collect(Collectors.toList());
	}
    
    @GetMapping("/status")
    public String getStaus() {
    	return "user_report_status";
    }


}
