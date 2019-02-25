package com.crsdevelopers.crimereportingsystem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.crsdevelopers.crimereportingsystem.controllers.AdminMissingPersonController;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;


public class AdminMissingPersonControllerTest {
	@Mock
	private MissingPersonService mssingPersonService;
	
	@InjectMocks
	AdminMissingPersonController adminMissingPersonController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminMissingPersonController).setViewResolvers(viewResolver()).build();
	}
	
	@Test
	public void testMissingPersonPage() throws Exception {
		mockMvc.perform(get("/admin/missingPerson"))
		.andExpect(status().isOk())
		.andExpect(view().name("admin_missingPerson"))
		;
	}
	
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}

}
