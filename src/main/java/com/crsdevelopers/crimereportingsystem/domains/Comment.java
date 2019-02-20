package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name="comment",schema="crs")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	private final String content;
	private Date createdAt = new Date();
	@OneToOne
	private News news;
	@ManyToOne
	private  User user;


}
