package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.restclient.MissingPersonRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.NewsRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.StolenVehicleRestClient;
import com.crsdevelopers.crimereportingsystem.restclient.WantedPersonRestClient;
import com.crsdevelopers.crimereportingsystem.services.CommentService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import com.crsdevelopers.crimereportingsystem.services.NewsService;
import com.crsdevelopers.crimereportingsystem.services.StolenVehicleService;
import com.crsdevelopers.crimereportingsystem.services.WantedPersonService;

@Controller
@RequestMapping("public")
public class PublicContentController {
	private NewsService newsService;
	private MissingPersonService missingPersonService;
	private WantedPersonService wantedPersonService;
	private StolenVehicleService stolenVehicleService;
	private CommentService commentService;
	
	
	@Autowired
	public PublicContentController(CommentService commentService,StolenVehicleService stolenVehicleService, NewsService newsService, MissingPersonService missingPersonService, WantedPersonService wantedPersonService){
		this.newsService = newsService;
		this.missingPersonService = missingPersonService;
		this.wantedPersonService = wantedPersonService;
		this.stolenVehicleService = stolenVehicleService;
		this.commentService = commentService;
	}

	
	@ModelAttribute(name="recent_news")
	public List<News> recentNews() {
		return newsService.getRecent();
	}
	
	@ModelAttribute(name="recent_mp")
	public List<MissingPerson> recentMp() {
		return missingPersonService.getRecent();
	}
	
	@ModelAttribute(name="recent_wp")
	public List<WantedPerson> recentWp() {
		return wantedPersonService.getRecent();
	}
	@ModelAttribute(name="all_mp")
	public List<MissingPerson> allMp() {
		return missingPersonService.getAll();
	}
	
	@ModelAttribute(name="all_wp")
	public List<WantedPerson> allWp() {
		return wantedPersonService.getAll();
	}
	
	@ModelAttribute(name="all_news")
	public List<News> allNews() {
		return newsService.getAll();
	}
	
	@ModelAttribute(name="all_sv")
	public List<StolenVehicle> allSv() {
		return stolenVehicleService.getAll();
	}

	
	@GetMapping("/missingPerson")
	public String showMissingPerson() {
		return "public_missingPerson";
	}
	
	@GetMapping("/missingPerson/{id}")
	public String showMissingPersonID(@PathVariable("id") Long id, Model model) {
		model.addAttribute("report", missingPersonService.getById(id));
		return "public_missingPerson_info";
	}
	
	@GetMapping("/wantedPerson")
	public String showWantedPerson() {
		return "public_wantedPerson";
	}
	
	@GetMapping("/wantedPerson/{id}")
	public String showWantedPersonID(@PathVariable("id") Long id, Model model) {
		model.addAttribute("report", wantedPersonService.getById(id));
		return "public_wantedPerson_info";
	}
	
	@GetMapping("/news")
	public String showNews() {
		return "public_news";
	}
	
	@GetMapping("/news/{id}")
	public String shownewsID(@PathVariable("id") Long id, Model model) {
		model.addAttribute("news", newsService.getById(id));
		model.addAttribute("comments", commentService.getByNews(newsService.getById(id)));
		return "public_news_info";
	}
	
	@GetMapping("/stolenVehicle")
	public String showSv() {
		return "public_stolenVehicle";
	}
	
	@GetMapping
	public String showRecent() {
		return "public_recent";
	}

}
