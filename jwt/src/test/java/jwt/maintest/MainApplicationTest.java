package jwt.maintest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jwt.MainApplication;

//Test class added ONLY to cover main() invocation not covered by application tests.
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MainApplicationTest {

    @Test
    public void contextLoads() {
    }
    
    @Test
    public void main() {
    	MainApplication.main(new String[] {});
    }
}