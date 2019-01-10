package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;

public interface StolenVehicleRepository extends CrudRepository<StolenVehicle, Long> {

}
