package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.restclient.MissingPersonRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.NewsRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.StolenVehicleRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.WantedPersonRestClient;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;

@Controller
@RequestMapping("public")
public class PublicContentController {
	
	private NewsRestClient newsRestClient;
	private WantedPersonRestClient wantedPersonRestClient;
	private MissingPersonRestClient missingPersonRestClient;
	private StolenVehicleRestClient stolenVehicleRestClient;
	
	
	@Autowired
	public PublicContentController(NewsRestClient newsRestClient, StolenVehicleRestClient stolenVehicleRestClient,MissingPersonRestClient missingPersonRestClient,WantedPersonRestClient wantedPersonRestClient){
		this.newsRestClient = newsRestClient;
		this.wantedPersonRestClient = wantedPersonRestClient;
		this.missingPersonRestClient = missingPersonRestClient;
		this.stolenVehicleRestClient = stolenVehicleRestClient;
	}

	
	@ModelAttribute(name="recent_news")
	public List<News> recentNews() {
		return newsRestClient.getRecentNews();
	}
	@ModelAttribute(name="recent_mp")
	public List<MissingPerson> recentMp() {
		return missingPersonRestClient.getRecentMissingPerson();
	}
	@ModelAttribute(name="recent_wp")
	public List<WantedPerson> recentWp() {
		return wantedPersonRestClient.getRecentWantedPerson();
	}
	
	@ModelAttribute(name="recent_sv")
	public List<StolenVehicle> recentSv() {
		return stolenVehicleRestClient.getRecentStolenVehicle();
	}
	
	@GetMapping("/missingPerson")
	public String showMissingPerson() {
		return "public_missingPerson";
	}
	
	@GetMapping
	public String showRecent() {
		return "public_recent";
	}

}
