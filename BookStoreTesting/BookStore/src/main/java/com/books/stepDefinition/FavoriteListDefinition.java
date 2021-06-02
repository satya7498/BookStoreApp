package com.books.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.book.pages.FavoriteListPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FavoriteListDefinition {

	 String url="http://localhost:3000/login";
    WebDriver driver=null;
	 FavoriteListPage fp;
	 
	@Before
	  public void configuration() {
	
		  
	 System.setProperty("webdriver.chrome.driver", "/home/globallogic/Downloads/chromedriver");		

	 ChromeOptions options=new  ChromeOptions();
	 
	 options.addArguments("start-maximized");
	  
	 
	 driver= new ChromeDriver(options);
	 
	 WebDriverWait wait=new WebDriverWait(driver,10);
	 
	 

	 fp = PageFactory.initElements(driver,  FavoriteListPage.class);
		
	 driver.get(url);
	 
	  }
	//========================================================================================================================
	
	@Given("move to login page")
	public void move_to_login_page() {
	   driver.get(url);
	}

	@When("Enter  username5 {string},password5 {string}")
	public void enter_username5_password5(String string, String string2) {
	  
		fp.setUsername(string);
        fp.setPassword(string2);
        }

	@When("click  on the Login Buttonf")
	public void click_on_the_login_buttonf() {
	   fp.setLogin();
	}
	
	//======================================================================================================================

	@Given("move to Favorite Page")
	public void move_to_favorite_page() {
	    driver.navigate().to("http://localhost:3000/favorites");
	}

	
	
	@When("click on remove Btnf")
	public void click_on_remove_btnf() {
	    
		Actions act = new Actions(driver);
		act.moveByOffset(230, 50).contextClick().build().perform();

	}

	//=========================================================================================================================
	@After
	public void TearDown() {
		driver.close();
		
	}

	
	
	
}
