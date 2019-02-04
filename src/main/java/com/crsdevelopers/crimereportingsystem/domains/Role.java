package com.crsdevelopers.crimereportingsystem.domains;

import javax.persistence.Entity;
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
@Table(name="role",schema="crs")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private final Long id;
	private String role;

}
