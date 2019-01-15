package com.crsdevelopers.crimereportingsystem.services;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.repositories.WantedPersonRepository;

@Service

public class WantedPersonService {

@Autowired
private WantedPersonRepository repository;

public WantedPerson save (WantedPerson wp) {
	return repository.save(wp);
}


public WantedPerson update(WantedPerson wp) {
	return repository.save(wp);
}


public void delete(WantedPerson wp) {
	repository.delete(wp);

}
//by id
public WantedPerson getById(Long id) {
	return repository.findById(id).get();
}


public List<WantedPerson> getAll() {
	 List<WantedPerson> all = (List<WantedPerson>) repository.findAll();
	 Collections.reverse(all);
	return all;
}

}
