package com.books.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.book.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {
	 
	 String url="http://localhost:3000/login";
	WebDriver driver=null;
	 LoginPage lp;
	 
	@Before
	  public void configuration() {
	
		  
	 System.setProperty("webdriver.chrome.driver", "/home/globallogic/Downloads/chromedriver");		

	 ChromeOptions options=new  ChromeOptions();
	 
	 options.addArguments("start-maximized");
	  
	 
	 driver= new ChromeDriver(options);
	 
	 WebDriverWait wait=new WebDriverWait(driver,10);
	

	 lp = PageFactory.initElements(driver, LoginPage.class);
		
	 driver.get(url);
	 
	  }
	//================================================================================================================
	
	@Given("open the Login Page in browser")
	public void open_the_login_page_in_browser() {
	    driver.get(url);
	}

	@When("Enter  credentials username2 {string},password2 {string}")
	public void enter_credentials_username2_password2(String string, String string2) throws InterruptedException {
		Thread.sleep(3000);
		lp.setUsername(string);
	   lp.setPassword(string2);
	}

	@Then("Click the Login Button")
	public void click_the_login_button() {
	    lp.setLogin();
	}
//======================================================================================================================

	@Given("Open The Login Page In Browser Window")
	public void open_the_login_page_in_browser_window() {
	  driver.get(url);
	}

	@When("Enter  Credentials As username3 {string},password3 {string}")
	public void enter_credentials_as_username3_password3(String string, String string2) throws InterruptedException {
	Thread.sleep(3000);
	   lp.setUsername(string);
	   lp.setPassword(string2);
	}

	@When("Click The Login Button3")
	public void click_the_login_button3() {
	  lp.setLogin();
	}
	
	@Then("Verify {string}")
	public void verify(String string) {
		String text=lp.verify();
		if(text.equals(string)) {
			System.out.println("TestPassed");
  	}
	}
  
	@After
	public void TearDown() {
		driver.close();
		
	}
	

}