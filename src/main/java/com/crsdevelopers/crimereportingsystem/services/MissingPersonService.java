package com.crsdevelopers.crimereportingsystem.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		if(repository.existsById(id)) {
			return repository.findById(id).get();
		}
		return null;
		
	}
	public List<MissingPerson> getRecent(){
		ArrayList<Long> ids = new ArrayList<Long>();
		Long count = repository.count();
		for (int i = 0; i <3 ; i++) {
			ids.add(count);
			count -=1;
		}
		List<MissingPerson> recent = (List<MissingPerson>) repository.findAllById(ids); 
		Collections.reverse(recent);
		return recent;
	}


	public List<MissingPerson> getAll() {
		 List<MissingPerson> all = (List<MissingPerson>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}
	
	public Iterable<MissingPerson> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public Page<MissingPerson> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
