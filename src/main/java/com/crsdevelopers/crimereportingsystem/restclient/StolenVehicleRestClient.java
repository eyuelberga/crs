package com.crsdevelopers.crimereportingsystem.restclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;

@Service
public class StolenVehicleRestClient {
	
	private RestTemplate restTemplate;

	@Autowired
	public StolenVehicleRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<StolenVehicle> getRecentStolenVehicle(){
		return restTemplate.exchange("http://localhost:8080/api/stolenVehicle/recent",HttpMethod.GET,null,
				new ParameterizedTypeReference<List<StolenVehicle>>() {}).getBody();
	}

}
