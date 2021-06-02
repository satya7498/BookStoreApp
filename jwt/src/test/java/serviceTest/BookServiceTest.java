package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import jwt.dao.BooksRepository;
import jwt.dao.FavRepository;
import jwt.model.Books;
import jwt.model.Favorites;
import jwt.service.BookService;
import jwt.service.FavService;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	@MockBean
	 private BooksRepository repo;
	
	@InjectMocks
	private BookService service; 
	
	
	@Before
   public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
   }
		  
	//-------------------Testing Repository class------------------------
  
	 @Test
    public void repoTest() {
   	BooksRepository repo=Mockito.mock(BooksRepository.class);
   	assertNotNull(repo);
     } 
   
   //--------------------Testing Service class------------------------------
	 
	 @Test
		public void serviceTest() {
			BookService service=Mockito.mock(BookService.class);
			assertNotNull(service);
		  }
			


	 @Test
		public void saveTest() {
			
			List<Books> blist=new ArrayList<>();
			Books b=new Books();
			b.setId(1);
			b.setTitle("java");
			b.setSubtitle("Core Java");
			b.setIsbn13("1234567");
			b.setImage("java.png");
			b.setPrice("40");
			b.setUrl("www.java.com");
			
			
			
			assertEquals(1,b.getId());
			assertEquals("java",b.getTitle());
			assertEquals("Core Java",b.getSubtitle());
			assertEquals("1234567",b.getIsbn13());
			assertEquals("java.png",b.getImage());
			assertEquals("40",b.getPrice());
			assertEquals("www.java.com",b.getUrl());
			
			}
		@Test
		public void EntityTest() {
		Books b=Mockito.mock(Books.class);
			assertNotNull(b);
		  }
		

		
		@After()
		public void tearDown() throws Exception {
		}
		 
}
