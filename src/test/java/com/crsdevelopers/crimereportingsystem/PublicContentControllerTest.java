package com.crsdevelopers.crimereportingsystem;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crsdevelopers.crimereportingsystem.controllers.PublicContentController;
import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.domains.StolenVehicle;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.services.CommentService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import com.crsdevelopers.crimereportingsystem.services.NewsService;
import com.crsdevelopers.crimereportingsystem.services.StolenVehicleService;
import com.crsdevelopers.crimereportingsystem.services.WantedPersonService;

public class PublicContentControllerTest {
	
	@Mock
	private NewsService newsService;
	@Mock
	private MissingPersonService missingPersonService;
	@Mock
	private WantedPersonService wantedPersonService;
	@Mock
	private StolenVehicleService stolenVehicleService;
	@Mock
	private CommentService commentService;
	
	@InjectMocks
	private PublicContentController publicContentController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(publicContentController).build();
	}
	
	@Test
	public void testNewsPage() throws Exception {
		List<News> news = new ArrayList<>();
		news.add(new News());
		news.add(new News());
		
		when(newsService.getAll()).thenReturn((List<News>)news);
		
		mockMvc.perform(get("/public/news"))
		.andExpect(status().isOk())
		.andExpect(view().name("public_news"))
		.andExpect(model().attributeExists("all_news"));
	}
	
	@Test
	public void testMissingPersonPage() throws Exception {
		List<MissingPerson> missingPerson = new ArrayList<>();
		missingPerson.add(new MissingPerson());
		missingPerson.add(new MissingPerson());
		
		when(missingPersonService.getAll()).thenReturn((List<MissingPerson>)missingPerson);
		
		mockMvc.perform(get("/public/missingPerson"))
		.andExpect(status().isOk())
		.andExpect(view().name("public_missingPerson"))
		.andExpect(model().attributeExists("all_mp"));
	}
	
	@Test
	  public void testWantedPersonPage() throws Exception {
	    List<WantedPerson> wantedPerson = new ArrayList<>();
	    wantedPerson.add(new WantedPerson());
	    wantedPerson.add(new WantedPerson());
	    
	    when(wantedPersonService.getAll()).thenReturn((List<WantedPerson>)wantedPerson);
	    
	    mockMvc.perform(get("/public/wantedPerson"))
	    .andExpect(status().isOk())
	    .andExpect(view().name("public_wantedPerson"))
	    .andExpect(model().attributeExists("all_wp"));
	  }
	
	@Test
	  public void testStolenVehiclePage() throws Exception {
	    List<StolenVehicle> stolenVehicle = new ArrayList<>();
	    stolenVehicle.add(new StolenVehicle());
	    stolenVehicle.add(new StolenVehicle());
	    
	    when(stolenVehicleService.getAll()).thenReturn((List<StolenVehicle>)stolenVehicle);
	    
	    mockMvc.perform(get("/public/stolenVehicle"))
	    .andExpect(status().isOk())
	    .andExpect(view().name("public_stolenVehicle"))
	    .andExpect(model().attributeExists("all_sv"));
	  }

}
