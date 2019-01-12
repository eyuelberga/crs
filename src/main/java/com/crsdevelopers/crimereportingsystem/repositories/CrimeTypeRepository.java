package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.CrimeType;

public interface CrimeTypeRepository extends CrudRepository<CrimeType, Long> {

}
