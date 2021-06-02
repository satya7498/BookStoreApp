package jwt.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;


import jwt.controller.BookController;
import jwt.dao.BooksRepository;
import jwt.model.Books;
import jwt.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControlerTest {
	//MockMvc call
	@Autowired
	private MockMvc mockMvc;
	
	//autowiring of webapplicationcontext
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private BooksRepository repo;
	
	//@Autowired 
	@MockBean
	private BookService service;
	private static ObjectMapper mapper=new ObjectMapper();
	
	//Setup for Mock mvc with a authorized user before every test case
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	 //Testing Model class
	  @Test	
	  public void testModel() {
		  Books p= Mockito.mock(Books.class);
		  assertNotNull(p);
	  }
	  
	//Testing controller class 
	  @Test	
	  public void testController() {
		  BookController p1= Mockito.mock(BookController.class);
		  assertNotNull(p1);
	  }
	  
	
	//welcome page 200 status code test case
	@WithMockUser("/user1")
	@Test
	public void welcomePageTest() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/welcomePage").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
	assertEquals(200, result.getResponse().getStatus());
	}

	//welcome page 401 status code test case
	@Test
	public void welcomePageTestNegative() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/welcomePage").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized())
			.andReturn();
	assertEquals(401, result.getResponse().getStatus());
	}
	
	//searchbyid positive testcase
	@WithMockUser("/user3")
	@Test
	public void getBookByIdTest() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/byid/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
	assertEquals(200, result.getResponse().getStatus());
	}
//	
	//searchbyid negative testcase none existing id given
	/*
	 * @WithMockUser("/user3")
	 * 
	 * @Test public void getBookByIdTestNegative() throws Exception {
	 * 
	 * MvcResult result =
	 * mockMvc.perform(get("/byid/4000").contentType(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isUnauthorized()) .andReturn(); assertEquals(401,
	 * result.getResponse().getStatus()); }
	 */
	
	//searchbyid negative testcase for unauthorized user 
	@Test
	public void getBookByIdTestWithoutUserNegative() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/byid/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized())
			.andReturn();
	assertEquals(401, result.getResponse().getStatus());
	}
	
	//all books positive testcase
	@WithMockUser("/user3")
	@Test
	public void showBooKstest() throws Exception {
		
		 List <Books> books=new ArrayList<Books>();
		   books.add(new Books(101, "java","core java","123456","40","java.png", "www.java.com"));
		   books.add(new Books(102, "java","advanced","123456","40","java.png", "www.java.com"));
		   
		   // Mocking the service level data
		   Mockito.when(service.getBooks()).thenReturn(books);
		   
		     // Mocking the Http Call
		   MvcResult result = mockMvc.perform(get("/allbooks").contentType(MediaType.APPLICATION_JSON))
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("$",Matchers.hasSize(2)))
		   .andExpect(jsonPath("$[0].title",Matchers.equalTo("java")))
		   .andExpect(jsonPath("$[1].title",Matchers.equalTo("java"))).andReturn();
		  
		
	assertEquals(200, result.getResponse().getStatus());
		
	}
	//all books negative testcase
	@Test
	public void showBooKstestNegative() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/allbooks").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized())
			.andReturn();
	assertEquals(401, result.getResponse().getStatus());
		
	}
	
}