package com.crsdevelopers.crimereportingsystem.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;

public interface WantedPersonRepository extends PagingAndSortingRepository<WantedPerson, Long>{

}
