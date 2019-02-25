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
import com.crsdevelopers.crimereportingsystem.controllers.AdminWantedPersonController;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import com.crsdevelopers.crimereportingsystem.services.WantedPersonService;


public class AdminWantedPersonControllerTest {
	@Mock
	private WantedPersonService wantedPersonService;
	
	@InjectMocks
	AdminWantedPersonController adminWantedPersonController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminWantedPersonController).setViewResolvers(viewResolver()).build();
	}
	
	@Test
	public void testWantedPersonPage() throws Exception {
		mockMvc.perform(get("/admin/wantedPerson"))
		.andExpect(status().isOk())
		.andExpect(view().name("admin_wp"))
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
