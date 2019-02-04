package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;

public interface MissingPersonRepository extends CrudRepository<MissingPerson, Long> {

}
