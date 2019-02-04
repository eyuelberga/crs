package com.crsdevelopers.crimereportingsystem.domains;



import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data; 

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String streetAddress;
	private City city;
    private String phoneNumber;
    private boolean enabled = true;
    public User toUser(PasswordEncoder passwordEncoder) {
    	return new User();
    	}

}
