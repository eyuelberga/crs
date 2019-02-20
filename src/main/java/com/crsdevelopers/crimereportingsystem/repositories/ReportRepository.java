package com.crsdevelopers.crimereportingsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.domains.User;

public interface ReportRepository  extends CrudRepository<Report, Long>{
	List<Report> findBySeen(boolean seen);
	List<Report> findBySeenAndUser(boolean seen, User user);

}
