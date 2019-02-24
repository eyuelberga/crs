package com.crsdevelopers.crimereportingsystem;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.crsdevelopers.crimereportingsystem.controllers.LoginController;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.CityService;
import com.crsdevelopers.crimereportingsystem.services.RoleService;
import com.crsdevelopers.crimereportingsystem.services.UserService;

public class LoginControllerTest {
	@Mock
	private UserService userService;
	@Mock
	private CityService cityService;
	@Mock
	private RoleService roleService;
	
	@InjectMocks
	LoginController loginController;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(viewResolver()).build();
	}
	
	@Test
	public void testSignupPage() throws Exception {
		mockMvc.perform(get("/signup"))
		.andExpect(status().isOk())
		.andExpect(view().name("signup"))
		.andExpect(model().attributeExists("cities"));
	}
	
	@Test
	public void testLoginPage() throws Exception {
		mockMvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}
	
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}

}
