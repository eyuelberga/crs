package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="comment",schema="crs")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	@NotBlank(message="Content should not be blank")
	private String content;
	private Date createdAt = new Date();
	@ManyToOne
	private News news;
	@ManyToOne
	private  User user;


}
