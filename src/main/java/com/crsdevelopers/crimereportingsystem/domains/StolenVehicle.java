package com.crsdevelopers.crimereportingsystem.domains;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
@Entity
@Table(name="stolen_vehicle",schema="crs")
public class StolenVehicle{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank( message="Name must be not be blank")
	private String name;
	@NotNull
	@NotBlank( message="Model must be not be blank")
	private String model;
	@NotNull
	@NotBlank( message="Color must be not be blank")
	private String color;
	@NotNull
	@NotBlank( message="LicensePlate must be not be blank")
	private String licensePlate;

	private Date createdAt = new Date();
	
	


}