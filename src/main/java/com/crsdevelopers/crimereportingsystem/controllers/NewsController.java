package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.NewsService;

@Controller
@RequestMapping("/News")
public class NewsController {
	
	
	private NewsService newsService;
	@Autowired
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
		
	}
	@ModelAttribute(name="all_news")
	public List<News> getAll() {
		List<News> allNews = newsService.getAll(); 
		return allNews; 
	}
@GetMapping
	
	public String showLoginSignupForm(Model model) {
		return "News";
	}
	
}
