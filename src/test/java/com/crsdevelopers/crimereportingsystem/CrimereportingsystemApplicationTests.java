package com.crsdevelopers.crimereportingsystem;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrimereportingsystemApplicationTests {
	@Autowired
	MockMvc mockMvc;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testPublicLandingPage() throws Exception {
	mockMvc.perform(get("/public"))
	.andExpect(status().isOk())
	.andExpect(view().name("public_recent"))
	.andExpect(content().string(
			containsString("Recent")));
	}
	


}

