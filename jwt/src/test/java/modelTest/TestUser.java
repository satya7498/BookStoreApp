package modelTest;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;


import jwt.model.DAOUser;

public class TestUser {
private DAOUser u;
	
	@Before
	public void setUp() throws Exception {
		u=new DAOUser();
		u.setUsername("William");
		u.setPassword("Byers1234");
	}
	@Test
	public void Beantest() {

		new BeanTester().testBean(DAOUser.class);

	}
}
