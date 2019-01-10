package com.crsdevelopers.crimereportingsystem.services;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.repositories.StolenVehicleRepository;

@Service
public class StolenVehicleService {
	
	@Autowired
	private StolenVehicleRepository repository;


	public StolenVehicle save (StolenVehicle sv) {
		return repository.save(sv);
	}


	public StolenVehicle update(StolenVehicle sv) {
		return repository.save(sv);
	}


	public void delete(StolenVehicle sv) {
		repository.delete(sv);

	}


	public StolenVehicle getById(Long id) {
		return repository.findById(id).get();
	}


	public List<StolenVehicle> getAll() {
		 List<StolenVehicle> all = (List<StolenVehicle>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}

}
