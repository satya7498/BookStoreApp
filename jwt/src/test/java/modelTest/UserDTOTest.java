package modelTest;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;


import jwt.model.UserDTO;

public class UserDTOTest {
private UserDTO u;
	
	@Before
	public void setUp() throws Exception {
		u=new UserDTO();
		
		u.setUsername("mike");
		u.setPassword("wheeler123");
		
	}
	@Test
	public void Beantest() {

		new BeanTester().testBean(UserDTO.class);

	}
}
