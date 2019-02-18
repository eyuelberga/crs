package com.crsdevelopers.crimereportingsystem.restclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;

@Service
public class MissingPersonRestClient {
	
	private RestTemplate restTemplate;

	@Autowired
	public MissingPersonRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<MissingPerson> getRecentMissingPerson(){
		return restTemplate.exchange("http://localhost:8080/api/missingPerson/recent",HttpMethod.GET,null,
				new ParameterizedTypeReference<List<MissingPerson>>() {}).getBody();
	}

}
