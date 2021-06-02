package jwt.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import jwt.dao.BooksRepository;
import jwt.dao.FavRepository;
import jwt.model.Books;
import jwt.model.Favorites;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavControllerTest {
	//MockMvc call
		private MockMvc mockMvc;
		
		//autowiring of webapplicationcontext
		@Autowired
		private WebApplicationContext context;
		
		@Autowired
		private FavRepository frepo;
		
		@Autowired
		private BooksRepository brepo;
		
		
		//Setup for Mock mvc with a authorized user before every test case
		@Before
		public void setUp() {
			mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		}
		
		//MyFav positive test case with 200 status code
		@WithMockUser("/user3")
		@Test
		public void getMyFavTest() throws Exception {
			
			MvcResult result =	mockMvc.perform(get("/myfav").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn();
			assertEquals(200, result.getResponse().getStatus());
			}
		
		//MyFav negative test case with 401 status code
		@Test
		public void getMyFavTestNegative() throws Exception {
			
			MvcResult result =	mockMvc.perform(get("/myfav").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isUnauthorized())
					.andReturn();
			assertEquals(401, result.getResponse().getStatus());
			}
		
		//AllFav positive test case with 200 status code
		@WithMockUser("/user3")
		@Test
		public void getAllFavTest() throws Exception {
			
			MvcResult result =	mockMvc.perform(get("/allfavs").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn();
			assertEquals(200, result.getResponse().getStatus());
			}
		
		//AllFav negative test case with 401 status code
		@Test
		public void getAllFavNegativeTest() throws Exception {
			
			MvcResult result =	mockMvc.perform(get("/allfavs").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isUnauthorized())
					.andReturn();
			assertEquals(401, result.getResponse().getStatus());
			}
		
		//addtoFav positive test case 
		@WithMockUser("/user3")
		@Test
		public void addtofav() throws Exception{
			Books b = new Books(1, "", "", "", "", "", "");
			Books books = brepo.save(b);
			Favorites f=new Favorites();
			f.setTitle(b.getTitle());
			f.setSubtitle(b.getSubtitle());
			f.setIsbn13(b.getIsbn13());
			f.setPrice(b.getPrice());
			f.setImage(b.getImage());
			f.setUrl(b.getUrl());
			f.setUserName("user3");
			f.setId(b.getId());
			Favorites fav = frepo.save(f);
			MvcResult result =mockMvc.perform(post("/addtoFav/{id}", f.getId()))
		                .andExpect(status().isOk()).andReturn();
		        assertEquals(200, result.getResponse().getStatus());
		}
		
		//addtofav nested Exception test case
		@WithMockUser("/user3")
		@Test(expected = NestedServletException.class)
		public void addtoFavExceptionTest() throws Exception{
			MvcResult result =mockMvc.perform(post("/addtoFav/{id}", 10000))
	                .andExpect(status().isOk()).andReturn();
	        assertEquals(200, result.getResponse().getStatus());

			System.out.println("Junit Message is printing ");
			
		}
		
		
		//add to fav unauthorized test case
		@Test
		public void addtofavNegativeUnauth() throws Exception {
			MvcResult result =mockMvc.perform(post("/addtoFav/{id}", 1))
		                .andExpect(status().isUnauthorized()).andReturn();
		        assertEquals(401, result.getResponse().getStatus());
		}
		
		//delete from fav positive test case with 200 status code
		@WithMockUser("/user3")
		@Test
		public void deleteByIdTest() throws Exception{
			Favorites f = new Favorites("1","1", "1", "1", "1");
			frepo.save(f);
			
			MvcResult result =mockMvc.perform(delete("/deletefav/{id}", f.getId()))
		                .andExpect(status().isOk()).andReturn();
		        assertEquals(200, result.getResponse().getStatus());
		}
		
		//delete from fav exception test case
//		@WithMockUser("/user3")
//		@Test(expected = NestedServletException.class)
//		public void deletebyIdException() throws Exception{
//			MvcResult result =mockMvc.perform(delete("/deletefav/{id}", 2))
//	                .andExpect(status().isOk()).andReturn();
//	        assertEquals(200, result.getResponse().getStatus());
//
//			System.out.println("Junit Message is printing ");
//			
//		}
		
		//delete from fav unauthorized test case
		@Test
		public void deleteByIdNegative() throws Exception{
			Favorites f = new Favorites(null, "1","1", "1", "1", "1", null);
			frepo.save(f);
			
			MvcResult result =mockMvc.perform(delete("/deletefav/{id}", f.getId()))
		                .andExpect(status().isUnauthorized()).andReturn();
		        assertEquals(401, result.getResponse().getStatus());
		}
}