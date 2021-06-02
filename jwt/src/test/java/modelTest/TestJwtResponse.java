package modelTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import jwt.model.Books;
import jwt.model.JwtResponse;



public class TestJwtResponse {
private JwtResponse j;
private static final long serialVersionUID = -8091879091924046844L;


@Before
public void setUp() throws Exception {
	j=new JwtResponse(null);
}
	
	@Test
	public void setUp1() throws Exception {
		j=new JwtResponse("123456sat");
		assertEquals("123456sat",j.getToken());
	}
	
	

}