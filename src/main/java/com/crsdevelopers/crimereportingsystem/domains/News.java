
package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="news",schema="crs")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Title can't be empty")
	@NotNull
	@Size(min=5, message="Title must be at least 5 characters long")
	private String title;
	
	@NotBlank(message="Content can't be empty")
	@NotNull
	@Size(min=5,  max =5000, message="Content must be at least 5 characters long")
	private String content;
	

	private Date createdAt;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}	


}
