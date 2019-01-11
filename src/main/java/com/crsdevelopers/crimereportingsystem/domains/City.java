package com.crsdevelopers.crimereportingsystem.domains;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="city",schema="crs")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	private final String name;


}
