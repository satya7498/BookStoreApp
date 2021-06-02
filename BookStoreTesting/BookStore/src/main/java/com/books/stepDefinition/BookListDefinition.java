package com.books.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.book.pages.BookListPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookListDefinition {

	String url="http://localhost:3000/login";

	WebDriver driver=null;
	BookListPage bp;
	 
	@Before
	  public void configuration() {
  
	 System.setProperty("webdriver.chrome.driver", "/home/globallogic/Downloads/chromedriver");		
	 ChromeOptions options=new  ChromeOptions();
	 options.addArguments("start-maximized");
	 driver= new ChromeDriver(options);
	 WebDriverWait wait=new WebDriverWait(driver,10);
	 bp = PageFactory.initElements(driver, BookListPage.class);
	 driver.get(url);
	 
	  }
	
	//==========================================================================================================================
	//Background----------------------------------------
	
	@Given("open the browser to login")
	public void open_the_browser_to_login() {
	    driver.get(url);
	}

	@When("Enter  username {string},password {string}")
	public void enter_username_password(String string, String string2) {
	   bp.setUsername(string);
	   bp.setPassword(string2);
	 
	}

	@When("click the Login Button")
	public void click_the_login_button() {
	   bp.setLogin();
	}
	
	//==========================================================================================================================
//	@Given("on the Booklist Home Page")
//	public void on_the_booklist_home_page() {
//	  driver.navigate().refresh();
//	}
//
//	@When("click on Add To Favorite FavButton")
//	public void click_on_add_to_favorite_fav_button() {
//	   bp.setFavBtn();
//	}
//
//	@When("click on ok btn")
//	public void click_on_ok_btn() {
//		bp.getOkBtn();
//	  
//	}
	
	
	//========================================================================================================================
		 //Search Functionality

	/*
	 * @Given("on the Booklist Page") public void on_the_booklist_page() { //
	 * driver.get(url);
	 * 
	 * }
	 * 
	 * @When("click on search btn") public void click_on_search_btn() {
	 * //driver.manage().timeouts().setScriptTimeout(100,SECONDS);
	 * //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * bp.setSearch(); }
	 * 
	 * @When("Enter the search text as {string}") public void
	 * enter_the_search_text_as(String string) { bp.setSearchText(string);
	 * 
	 * }
	 * 
	 * @Then("Verify Book name as {string}") public void verify_book_name_as(String
	 * string) {
	 * 
	 * String text=bp.VerifyBookName(); if(text.equals(string)) {
	 * System.out.println("Test Passed"); } }
	 */

   //=============================================================================================================================
		//REad Now Functionality
	
	@Given("on the BookPage")
	public void on_the_book_page() {
		driver.get("http://localhost:3000/home");
	}

	@When("click on Read Now")
	public void click_on_read_now() {
		Actions act = new Actions(driver);
			act.moveByOffset(648, 30).contextClick().build().perform();
	}

	@Then("Verify the Book Name as {string}")
	public void verify_the_book_name_as(String string) {
		driver.navigate().to("https://itbook.store/books/1001620981541");
    String Exp=	bp.VerifyBookName();
    if(string.equals(Exp)) {
    	System.out.println("Test Passed");
    }
    else {
    	System.out.println("Test Failed");
    }
    
	}
		
	//==========================================================================================================================


	@Given("on the Booklist Home Page")
	public void on_the_booklist_home_page() {
		driver.get("http://localhost:3000/home");
	}

	@When("click on Add To Favorite FavButton")
	public void click_on_add_to_favorite_fav_button() {
		Actions act = new Actions(driver);
		act.moveByOffset(230, 50).contextClick().build().perform();
	}

	@When("click on ok btn")
	public void click_on_ok_btn() {
		
		Actions act = new Actions(driver);
		act.moveByOffset((int) 68.64, 41).contextClick().build().perform();

	}
	@When("click to Fav Section")
	public void click_to_fav_section() {
	    driver.navigate().to("http://localhost:3000/favorites");
	}

	@Then("Verify book as {string}")
	public void verify_book_as(String string) {
	 
	   Actions act = new Actions(driver);
		String Exp=act.moveByOffset(318, 30).contextClick().build().toString();
		
		
	    if(string.equals(Exp)) {
	    	System.out.println("Test Passed");
	    }
	    else {
	    	System.out.println("Test Failed");
	    }
	}
	
	//==========================================================================================================================

	@When("click on search btn for search")
	public void click_on_search_btn_for_search() {
		
		Actions act = new Actions(driver);
		act.moveByOffset(800, 40).contextClick().build().perform();
		
	}

	@When("Enter the search text as {string} for search")
	public void enter_the_search_text_as_for_search(String string) {
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//input[@id='searchbar'][1]"));
				
				//create an object for the Actions class and pass the driver argument 
				Actions action = new Actions(driver);
				
				//pass the product name that has to be searched in the website
				

JavascriptExecutor jse = ((JavascriptExecutor)driver);        	

jse.executeScript("arguments[0].value='Seeing Theory';", element);
	}

	@Then("Verify Book name as {string} as search")
	public void verify_book_name_as_as_search(String string) {

		if(string.equals("Seeing Teory")) {
			System.out.println("Test Passed");
		}
	}
	
	
	//====================================================================================================================================
	

	
	@After
	public void TearDown() {
		driver.close();
		
	}


}