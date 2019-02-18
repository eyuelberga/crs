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

import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.services.StolenVehicleService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/stolenVehicle", produces="application/json" )
public class StolenVehicleRestController {
	@Autowired
	private StolenVehicleService stolenVehicleService;
	
	@GetMapping
	public List<StolenVehicle> getAllStolenVehicle(){
		return stolenVehicleService.getAll();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<StolenVehicle> getById(@PathVariable("id") Long id){
		StolenVehicle stolenVehicle  = stolenVehicleService.getById(id);
		
		if(stolenVehicle != null) {
			return new ResponseEntity<>(stolenVehicle, HttpStatus.OK);
		}
		return new ResponseEntity<>(stolenVehicle, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public StolenVehicle save(@RequestBody StolenVehicle stolenVehicle) {
		return stolenVehicleService.save(stolenVehicle);
	}
	
	@GetMapping("/recent")
	public Iterable<StolenVehicle> recentStolenVehicle(@RequestParam(name="page",defaultValue="0") int page, @RequestParam(name="size", defaultValue="3") int size) {
		
		PageRequest pageRequest = PageRequest.of(page,size,Sort.by("createdAt").descending());
		return stolenVehicleService.findAll(pageRequest).getContent();
	}

}
