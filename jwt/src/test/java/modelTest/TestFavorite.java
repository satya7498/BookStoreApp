package modelTest;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;


import jwt.model.Favorites;

public class TestFavorite {
private Favorites f;
	
	@Before
	public void setUp() throws Exception {
		f=new Favorites();
		f.setId(1);
		f.setTitle("java");
		f.setSubtitle("Core Java");
		f.setIsbn13("1234567");
		f.setImage("java.png");
		f.setPrice("40");
		f.setUrl("www.java.com");
	}
	@Test
	public void Beantest() {

		new BeanTester().testBean(Favorites.class);

	}
}
