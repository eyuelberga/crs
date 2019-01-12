package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.domains.City;
import com.crsdevelopers.crimereportingsystem.domains.CrimeType;
import com.crsdevelopers.crimereportingsystem.domains.News;
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
	public void addIngredientsToModel(Model model) {
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
	
	
	@GetMapping()
    public String showForm(Model model) {
		model.addAttribute("report", new Report());
        return "user_report";
    }

    @PostMapping()
    public String checkPersonInfo(@ModelAttribute @Valid Report report, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user_report";
        }
        reportService.save(report);

        return "redirect:/admin/news";
    }
    
    private List<CrimeType> filterByType(List<CrimeType> ingredients, Type type){
		return ingredients
				.stream()
				.filter(x->x.getType().equals(type))
				.collect(Collectors.toList());
	}


}
