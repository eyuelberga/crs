package com.crsdevelopers.crimereportingsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.crsdevelopers.crimereportingsystem.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserService userService;
	
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userService)
	          .passwordEncoder(bCryptPasswordEncoder);
	  } 
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/user/report","/user/missingPerson").hasAuthority("USER")
            .anyRequest()
            .permitAll()
	        .and()
		     	.formLogin()
		     			.loginPage("/login")
		     			.failureUrl("/login?error=true")
		     			.defaultSuccessUrl("/user/report")
		    .and()
		     	.logout()
		     			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		     			.logoutSuccessUrl("/")
		 	.and()
		     	.exceptionHandling()
		     	.accessDeniedPage("/access-denied");
    }

}
