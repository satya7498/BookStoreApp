package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jwt.dao.FavRepository;
import jwt.dao.UserDao;
import jwt.model.DAOUser;
import jwt.model.Favorites;
import jwt.service.FavService;
import jwt.service.JWTUserDetailsService;

@Service
public class UserServiceTest {

	
	private DAOUser  j;
	@Autowired
	private UserDao urepo;
	
	@InjectMocks
	private JWTUserDetailsService service;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	

	 @Test
	    public void repoTest() {
		 UserDao urepo=Mockito.mock(UserDao.class);
	   	assertNotNull(urepo);
	     }
	 @Test
		public void serviceTest() {
		 JWTUserDetailsService service=Mockito.mock(JWTUserDetailsService.class);
			assertNotNull(service);
		  }
	 
	 @Test
		public void EntityTest() {
		 DAOUser  j=Mockito.mock(DAOUser.class);
			assertNotNull(j);
		  }

	
	@Test
	public  void saveTest() {
		
		DAOUser j=new DAOUser();
		j.setUsername("satya");
		j.setEmailid("satya@gmail.com");
		j.setPassword("12345");
		
	assertEquals("satya",j.getUsername());
	assertEquals("satya@gmail.com",j.getEmailid());
	assertEquals("12345",j.getPassword());
		
		
	
	}
	
	@After()
	public void tearDown() throws Exception {
	}
	
	
}