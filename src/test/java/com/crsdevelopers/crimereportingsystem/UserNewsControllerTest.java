package com.crsdevelopers.crimereportingsystem;

import static org.hamcrest.CoreMatchers.any;
import  org.hamcrest.Matchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.crsdevelopers.crimereportingsystem.controllers.UserNewsController;
import com.crsdevelopers.crimereportingsystem.domains.Comment;
import com.crsdevelopers.crimereportingsystem.domains.News;
import com.crsdevelopers.crimereportingsystem.services.CommentService;
import com.crsdevelopers.crimereportingsystem.services.NewsService;

public class UserNewsControllerTest {
	
	@Mock
	private NewsService newsService;
	@Mock
	private CommentService commentService;
	
	@InjectMocks
	private UserNewsController userNewsController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userNewsController).setViewResolvers(viewResolver()).build();
	}
	
	@Test
	public void testCommentWithoutIDPage() throws Exception {
		mockMvc.perform(get("/user/comment"))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void testCommentWithIDPage() throws Exception {
	when(newsService.getById((long) 1)).thenReturn(new News());
		mockMvc.perform(get("/user/comment/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("user_comment"));
	}
	
	@Test
	public void testPostComment() throws Exception{
		Long ID =(long) 1;
		String comment = "Test comment";
		Comment returnComment  = new Comment();
		returnComment.setId(ID);
		returnComment.setContent(comment);
		when(newsService.getById((long) 1)).thenReturn(new News());	
		mockMvc.perform(post("/user/comment/1")
				.param("id", "1")
				.param("content", comment))
		.andExpect(status().is3xxRedirection());
		
	}
	
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}

}
