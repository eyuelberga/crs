package com.crsdevelopers.crimereportingsystem.restclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;

@Service
public class WantedPersonRestClient {
	
	private RestTemplate restTemplate;

	@Autowired
	public WantedPersonRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<WantedPerson> getRecentWantedPerson(){
		return restTemplate.exchange("http://localhost:8080/api/wantedPerson/recent",HttpMethod.GET,null,
				new ParameterizedTypeReference<List<WantedPerson>>() {}).getBody();
	}

}
