package jwt.controller;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwt.config.JwtTokenUtil;

import jwt.dao.BooksRepository;
import jwt.dao.FavRepository;
import jwt.model.Books;

import jwt.model.Favorites;
import jwt.service.BookService;
import jwt.service.FavService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private BooksRepository repo;
	
	
	//Welcome Page
	
	@RequestMapping({ "/welcomePage" })
	public ResponseEntity<?> firstPage() {
		String s = "Welcome to Book Store";
			return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	

	// Endpoint for getting all the books in the store
	
//	@GetMapping("/allbooks")
//	public List<Books> getBookList() {
//		return service.getBooks();	
//	}
	
	//Endpoint for searching the book by its id
	
//	@GetMapping("/byid/{id}")
//	public Optional<Books> getBooksById(@PathVariable int id) {
//		return service.getsingleBook(id);
//	}
//	
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<?> getBooksById(@PathVariable int id){
		Optional<Books> book = service.getsingleBook(id);
		
			return new ResponseEntity<Optional>(book,HttpStatus.OK);
		
	}
	
	
//Endpoint for searching the book by its title
	
//		@GetMapping("/bytitle/{title}")
//		public Optional<Books> getBooksByTitle(@PathVariable String title) {
//			return service.getsingleBookByTitle(title);
//		}
	
	
		
		
		
		@GetMapping("/allbooks")
		public ResponseEntity<?> getBookList(){
			List<Books> books = service.getBooks();
						return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
		}
	
		

		
	 
	
	 
}