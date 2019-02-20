package com.crsdevelopers.crimereportingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.NewsService;

@Controller
@RequestMapping("user/comment")
public class UserNewsController {
	
	
	private NewsService newsService;
	@Autowired
	public UserNewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@GetMapping("/{id}")
	public String goToComment(@PathVariable("id") Long id) {
		return "user_comment";
	}
	
}
