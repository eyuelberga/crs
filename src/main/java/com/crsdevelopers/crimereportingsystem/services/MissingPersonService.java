package com.crsdevelopers.crimereportingsystem.services;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.repositories.MissingPersonRepository;

@Service
public class MissingPersonService {
	
	@Autowired
	private MissingPersonRepository repository;


	public MissingPerson save (MissingPerson mp) {
		return repository.save(mp);
	}


	public MissingPerson update(MissingPerson mp) {
		return repository.save(mp);
	}


	public void delete(MissingPerson mp) {
		repository.delete(mp);

	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


	public MissingPerson getById(Long id) {
		return repository.findById(id).get();
	}


	public List<MissingPerson> getAll() {
		 List<MissingPerson> all = (List<MissingPerson>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}

}
