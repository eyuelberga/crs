package com.crsdevelopers.crimereportingsystem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.NewsService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/news", produces="application/json" )
public class NewsRestController {
	@Autowired
	private NewsService newsService;
	
	@GetMapping
	public List<News> getAllNews(){
		return newsService.getAll();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<News> getById(@PathVariable("id") Long id){
		News news  = newsService.getById(id);
		
		if(news != null) {
			return new ResponseEntity<>(news, HttpStatus.OK);
		}
		return new ResponseEntity<>(news, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public News save(@RequestBody News news) {
		return newsService.save(news);
	}
	
	@GetMapping("/recent")
	public Iterable<News> recentNews(@RequestParam(name="page",defaultValue="0") int page, @RequestParam(name="size", defaultValue="3") int size) {
		
		PageRequest pageRequest = PageRequest.of(page,size,Sort.by("createdAt").descending());
		return newsService.findAll(pageRequest).getContent();
	}

}
