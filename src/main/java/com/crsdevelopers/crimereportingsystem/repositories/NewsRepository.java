package com.crsdevelopers.crimereportingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.News;

public interface NewsRepository extends CrudRepository<News, Long> {

}
