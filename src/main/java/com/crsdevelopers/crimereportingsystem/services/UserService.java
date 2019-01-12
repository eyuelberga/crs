package com.crsdevelopers.crimereportingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crsdevelopers.crimereportingsystem.domains.User;
import com.crsdevelopers.crimereportingsystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;


	public User save (User user) {
		return repository.save(user);
	}


	public User update(User user) {
		return repository.save(user);
	}


	public void delete(User user) {
		repository.delete(user);

	}


	public User getById(Long id) {
		return repository.findById(id).get();
	}


	public List<User> getAll() {
		 List<User> all = (List<User>) repository.findAll();
		return all;
	}

}
