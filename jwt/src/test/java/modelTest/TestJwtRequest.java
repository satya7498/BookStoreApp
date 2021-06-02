package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;


import jwt.model.JwtRequest;

public class TestJwtRequest {
private  JwtRequest j;
	
	@Before
	public void setUp() throws Exception {
		j=new JwtRequest();
		j.setUsername("nancy");
		j.setPassword("wheeler123");
	}
	
	@Test
	public void testConstructor() {
		j=new JwtRequest("nancy","nancy123");
		assertEquals("nancy",j.getUsername());
		assertEquals("nancy123",j.getPassword());
	}
	@Test
	public void Beantest() {
		
		new BeanTester().testBean(JwtRequest.class);

	}
}
