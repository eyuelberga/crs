package com.crsdevelopers.crimereportingsystem.restclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crsdevelopers.crimereportingsystem.domains.News;

@Service
public class NewsRestClient {
	
	private RestTemplate restTemplate;

	@Autowired
	public NewsRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<News> getRecentNews(){
		return restTemplate.exchange("http://localhost:8080/api/news/recent",HttpMethod.GET,null,
				new ParameterizedTypeReference<List<News>>() {}).getBody();
	}

}
