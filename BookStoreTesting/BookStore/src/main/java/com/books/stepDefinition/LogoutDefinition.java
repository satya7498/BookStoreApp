package com.books.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.book.pages.LogoutPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutDefinition {

	String url="http://localhost:3000/login";

	WebDriver driver=null;
	LogoutPage lp;
	 
	@Before
	  public void configuration() {
	
		  
	 System.setProperty("webdriver.chrome.driver", "/home/globallogic/Downloads/chromedriver");		

	 ChromeOptions options=new  ChromeOptions();
	 
	 options.addArguments("start-maximized");
	  
	 
	 driver= new ChromeDriver(options);
	 
	 WebDriverWait wait=new WebDriverWait(driver,10);
	 driver.get(url);
	 
	 
	 lp = PageFactory.initElements(driver, LogoutPage.class);
		
	
	 
	  }
	@Given("on the login start page")
	public void on_the_login_start_page() {
		 driver.get(url);
	}

	@When("Enter  user credentials username4 {string},password4 {string}")
	public void enter_user_credentials_username4_password4(String string, String string2) throws InterruptedException {
	   
		Thread.sleep(1000);
		   lp.setUsername(string);
		   lp.setPassword(string2);
	}

	@When("Click the Login Button4")
	public void click_the_login_button4() {
	    lp.setLogin();
	}

	@When("Click the Logout Btn")
	public void click_the_logout_btn() {
		
	 lp.setLogout();
	}

	@Then("Verify with {string}")
	public void verify_with(String string) {
	   String text=lp.verify();
	   if(text.equals(string)) {
		   System.out.println("Test Passed");
	   }
	}
	
	@After
	public void TearDown() {
		driver.close();
		
	}
	

}
