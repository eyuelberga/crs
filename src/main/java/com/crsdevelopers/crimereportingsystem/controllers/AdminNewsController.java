/**
 * 
 */
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

import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.NewsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin/news")
@SessionAttributes("news")
public class AdminNewsController {
	
	private NewsService newsService;
	
	@Autowired
	public AdminNewsController(NewsService newsService) {
		this.newsService = newsService;
		
	}
	
	@ModelAttribute(name="news")
	public News news(Model model) {
		return new News();
	}
	
	@ModelAttribute(name="all_news")
	public List<News> getAll() {
		List<News> allNews = newsService.getAll(); 
		return allNews; 
	}
	
	@GetMapping
	public String showNewsForm() {
		return "admin_news";
	}
	
	@RequestMapping("deleteNews")
	public String deleteNews(@RequestParam("id") Long id) {
		News news = new News();
		news.setId(id);
		newsService.delete(news);
		return "redirect:/admin/news/#news_list";
		
	}
	
	@PostMapping
	public String processNewsPost( @Valid News news, Errors errors,SessionStatus sessionStatus){
		if (errors.hasErrors()) {
			return "admin_news";
		}
		News savedNews = newsService.save(news);
		log.info("News object after persisting: " + savedNews);
		sessionStatus.setComplete();
		
		return "redirect:/admin/news/#news_list";
		
	}
	
	@GetMapping("/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		//News news = new News();
		News newsEdit = newsService.getById(id);
		//news.setId(id);
		model.addAttribute("news",newsEdit);
		return "admin_edit_news";
		
	}
	@PostMapping("/update/{id}")
	public String processUpdate(@PathVariable("id") Long id, @Valid News newsEdit, Errors errors,SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			newsEdit.setId(id);
			return "admin_edit_news";
		}
		newsService.update(newsEdit);
		sessionStatus.setComplete();
		
		return "redirect:/admin/news/#news_list";
		
	}

}
