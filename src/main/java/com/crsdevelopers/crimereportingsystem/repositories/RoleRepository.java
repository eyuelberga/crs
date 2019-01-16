package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByRole(String role);

}
