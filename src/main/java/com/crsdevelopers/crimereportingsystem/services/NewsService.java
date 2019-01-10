package com.crsdevelopers.crimereportingsystem.services;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.repositories.NewsRepository;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository repository;


	public News save (News news) {
		return repository.save(news);
	}


	public News update(News news) {
		return repository.save(news);
	}


	public void delete(News news) {
		repository.delete(news);

	}


	public News getById(Long id) {
		return repository.findById(id).get();
	}


	public List<News> getAll() {
		 List<News> all = (List<News>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}

}
