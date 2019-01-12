package com.crsdevelopers.crimereportingsystem.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crsdevelopers.crimereportingsystem.domains.CrimeType;
import com.crsdevelopers.crimereportingsystem.repositories.CrimeTypeRepository;

@Service
public class CrimeTypeService {
	
	@Autowired
	private CrimeTypeRepository repository;


	public CrimeType save (CrimeType crimeType) {
		return repository.save(crimeType);
	}


	public CrimeType update(CrimeType crimeType) {
		return repository.save(crimeType);
	}


	public void delete(CrimeType crimeType) {
		repository.delete(crimeType);

	}


	public CrimeType getById(Long id) {
		return repository.findById(id).get();
	}


	public List<CrimeType> getAll() {
		 List<CrimeType> all = (List<CrimeType>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}

}
