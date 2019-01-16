package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="wanted_person",schema="crs")
public class WantedPerson {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @NotBlank(message = "Please provide your full name")
	    private String fullname;
	 
	 @NotBlank(message="Content can't be empty")
		@NotNull
		@Size(min=5,  max =5000, message="Description must be at least 5 characters long")
		private String description;
	 
	 private String picturePath;

}
