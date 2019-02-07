package com.crsdevelopers.crimereportingsystem.domains;



import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.Lob;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




import lombok.Data;

@Data
@Entity
@Table(name="missingPerson",schema="crs")
public class MissingPerson{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank( message="Full Name must be not be blank")
	private String fullname;
	@NotNull
	private int age;
	@NotNull
	private String gender;
	@NotNull
	@Lob
	@NotBlank( message="Description must be not be blank")
	private String description;
	@NotNull
	private String dateMissing;

	
	private Date createdAt;
	
	@ManyToOne
	private  User user;
	
	private String picturePath;

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	


}