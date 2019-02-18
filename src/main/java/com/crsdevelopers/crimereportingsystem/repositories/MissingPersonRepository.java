package com.crsdevelopers.crimereportingsystem.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;

public interface MissingPersonRepository extends PagingAndSortingRepository<MissingPerson, Long> {

}
