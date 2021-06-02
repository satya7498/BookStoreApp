package jwt.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import jwt.controller.JwtAuthenticationController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private JwtAuthenticationController authentication;

	

    @Autowired
    private AuthenticationManager authenticationManager;

	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		}
		

	@Test
	public void userAuthTest() throws Exception {
	    String username = "nonexistentuser";
	    String password = "password";

	    String body = "{\"username\":\"" + username + "\", \"password\":\""  + password + "\"}";

	    MvcResult result =	mockMvc.perform(post("/register").content(body).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@WithMockUser("/user1")
	@Test
	public void byUsernameTest() throws Exception {
		
	MvcResult result =	mockMvc.perform(get("/name/{name}","user1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
	assertEquals(200, result.getResponse().getStatus());
	}
	
	
	@WithMockUser("/user1")
	@Test
	public void authenticateUserTest() throws Exception{
		authentication.authenticate("user1", "password");
		Authentication S = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user1", "password"));
	
	}
	
	@Test
	public void RequestTest() throws Exception {
		
		String username = "user1";
	    String password = "password";

	    String body = "{\"username\":\"" + username + "\", \"password\":\""  + password + "\"}"; 
	    
	    MvcResult result =	mockMvc.perform(post("/authenticate").content(body).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
