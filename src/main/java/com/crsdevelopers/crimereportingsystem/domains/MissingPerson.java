package com.crsdevelopers.crimereportingsystem.domains;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="missingPerson",schema="crs")
public class MissingPerson{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2, message="Name must be at least 2 characters long")
	private String name;
	@NotNull
	private int age;
	@NotNull
	private boolean gender;
	@NotNull
	@Size(min=5,  max =5000, message="Description must be at least 5 characters long")
	private String description;
	@NotNull
	private Date dateMising;
	
	private Date createdAt;
	
	@ManyToOne
	private  User user;
	
	private String picturePath;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	


}