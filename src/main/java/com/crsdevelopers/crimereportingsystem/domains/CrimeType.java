package com.crsdevelopers.crimereportingsystem.domains;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class CrimeType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	private final String name;
	
	@Enumerated(EnumType.STRING)
	private final Type type;
	
	public static enum Type {
		ABUSE, ARSON, BURGLARY,FRAUD, MURDER, STALKING

}
	
}