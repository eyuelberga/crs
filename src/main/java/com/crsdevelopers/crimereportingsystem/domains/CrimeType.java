package com.crsdevelopers.crimereportingsystem.domains;




import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name="crime_type",schema="crs")
public class CrimeType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	private final String name;
	
	@Enumerated(EnumType.STRING)
	private final Type type;
	
	public static enum Type {
		ABUSE, ARSON, BURGLARY,HARASMENT,FRAUD, MURDER

}
	
}