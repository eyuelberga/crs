package com.crsdevelopers.crimereportingsystem.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.crsdevelopers.crimereportingsystem.domains.News;

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

}
