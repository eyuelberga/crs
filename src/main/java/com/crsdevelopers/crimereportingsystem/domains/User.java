package com.crsdevelopers.crimereportingsystem.domains;



import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="user",schema="crs")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 228223283460503633L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotBlank(message = "Please provide a username")
    private String username;
   
    @Size(min = 8, message = "Your password must have at least 8 characters")
    @NotBlank(message = "Please provide your password")
    private String password;
    
    @NotBlank(message = "Please provide your full name")
    private String fullname;
    
    @NotBlank(message="Street Address is required")
    private String streetAddress;
    
    @ManyToOne
	@MapsId
	private City city;
    //@Pattern(regexp="^[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{3}$", message="Must be formatted XXX-XXX-XXX-XXX")
    @NotBlank(message="Phone number is required")
    private String phoneNumber;
    
    @Column(name = "enabled")
    private int enabled;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_role", 
    			joinColumns= {@JoinColumn(name="user_id")},
    			inverseJoinColumns= {@JoinColumn(name="role_id")})
    private Set<Role> roles;
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<GrantedAuthority> authorities = roles
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet());
		
		return authorities;
	}


	
    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
