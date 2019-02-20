package com.crsdevelopers.crimereportingsystem.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		if(repository.existsById(id)) {
			return repository.findById(id).get();
		}
		return null;
	}


	public List<News> getAll() {
		 List<News> all = (List<News>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}
	public Iterable<News> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public Page<News> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public List<News> getRecent(){
		ArrayList<Long> ids = new ArrayList<Long>();
		Long count = repository.count();
		for (int i = 0; i <3 ; i++) {
			ids.add(count);
			count -=1;
		}
		List<News> recent = (List<News>) repository.findAllById(ids); 
		Collections.reverse(recent);
		return recent;
		
	}
	
	public Iterable<News> getWithPageAndSize(int page, int size){
		PageRequest pageRequest = PageRequest.of(page,size,Sort.by("createdAt").descending());
		return this.findAll(pageRequest).getContent();
	}

}
