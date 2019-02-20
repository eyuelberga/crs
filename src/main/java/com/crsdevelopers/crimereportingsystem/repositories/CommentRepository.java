package com.crsdevelopers.crimereportingsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crsdevelopers.crimereportingsystem.domains.Comment;
import com.crsdevelopers.crimereportingsystem.domains.News;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	public List<Comment> findByNews(News news);

}
