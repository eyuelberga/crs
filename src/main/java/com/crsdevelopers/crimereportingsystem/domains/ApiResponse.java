package com.crsdevelopers.crimereportingsystem.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
	private String code;
	private String message;

}
