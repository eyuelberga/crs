package com.crsdevelopers.crimereportingsystem.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;

public interface StolenVehicleRepository extends PagingAndSortingRepository<StolenVehicle, Long> {

}
