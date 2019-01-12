package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="report",schema="crs")
public class Report {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(targetEntity=CrimeType.class)
	//@Size(min=1, message="You must choose at least 1 incident type")
	private Set<CrimeType> crimeType = new HashSet<>();
	
	@NotBlank(message="Date can't be empty")
	@NotNull
	private String date;
	
	@NotBlank(message="Address can't be empty")
	@NotNull
	private String address;
	
	@OneToOne
	@MapsId
	private City city;
	
	@NotBlank(message="Description can't be empty")
	@NotNull
	@Size(max = 5000)
	private String description;
	
	private Integer peopleInvolved;
	
	private  Boolean isAffected;
	
	private Date createdAt = new Date();

}
