package com.crsdevelopers.crimereportingsystem.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crsdevelopers.crimereportingsystem.domains.Report;
import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.repositories.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository repository;
	

	public Report save (Report report) {
		return repository.save(report);
	}


	public Report update(Report report) {
		return repository.save(report);
	}


	public void delete(Report report) {
		repository.delete(report);

	}


	public Report getById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Report> getBySeen(boolean seen) {
		 List<Report> all = repository.findBySeen(seen);
		 Collections.reverse(all);
		return all;
	}
	public List<Report> getBySeenAndUsername(boolean seen, User user) {
		 List<Report> all = repository.findBySeenAndUser(seen, user);
		 Collections.reverse(all);
		return all;
	}

	public List<Report> getAll() {
		 List<Report> all = (List<Report>) repository.findAll();
		 Collections.reverse(all);
		return all;
	}

}
