package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crsdevelopers.crimereportingsystem.domains.City;
import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.services.CityService;
import com.crsdevelopers.crimereportingsystem.services.UserService;

@Controller
public class LoginController {
	
	private UserService userService;
	private CityService cityService;
	@Autowired
	public LoginController(UserService userService, CityService cityService) {
		this.userService = userService;
		this.cityService = cityService;
		
	}
	
	@ModelAttribute(name="user")
	public User user() {
		return new User();
	}
	@ModelAttribute(name="cities")
	public List<City> getAll() {
		List<City> cities = cityService.getAll(); 
		return cities; 
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@GetMapping("/signup")
    public String showSignupForm(){
        return "signup";
    }
	   @PostMapping("/signup")
	    public String createNewUser(@Valid User user, BindingResult bindingResult, RedirectAttributes atts) {
	        User userExists = userService.findUserByUsername(user.getUsername());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("user", "error.user",
	                            "There is already a user registered with the username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            return "signup";
	        } else {
	        	
	            userService.save(user);
	            atts.addFlashAttribute("successMessage", "User has been registered successfully");
	            
	            return "redirect:/login";
	        }
	    }
	    
	    @GetMapping("/access-denied")
	    public String accessDenied(){
	        return "access_denied";
	    }
}
