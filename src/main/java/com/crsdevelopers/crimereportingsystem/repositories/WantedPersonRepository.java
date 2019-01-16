package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;

public interface WantedPersonRepository extends CrudRepository<WantedPerson, Long>{

}
