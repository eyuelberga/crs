package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.Report;

public interface ReportRepository  extends CrudRepository<Report, Long>{

}
