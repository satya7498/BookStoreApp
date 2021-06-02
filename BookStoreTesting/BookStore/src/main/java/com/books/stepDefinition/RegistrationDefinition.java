package com.books.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import com.book.pages.RegistrationPage;



public class RegistrationDefinition {

	WebDriver driver=null;
	 RegistrationPage rp;

		String url="http://localhost:3000/login";
	 
	@Before
	  public void configuration() {
	
		  
		 System.setProperty("webdriver.chrome.driver", "/home/globallogic/Downloads/chromedriver");		
		  
		 ChromeOptions options=new  ChromeOptions();
		 
		 options.addArguments("start-maximized");
		  
		 
		 driver= new ChromeDriver(options);
		 
		 WebDriverWait wait=new WebDriverWait(driver,10);
		 
	     driver.get(url);
	
		
		
	 
	 

	 rp = PageFactory.initElements(driver, RegistrationPage.class);
	
	 
	  }
	
	@Given("open the browser")
	public void open_the_browser() {
	
	    driver.get(url);    
	}

	@When("click on Register")
	public void click_on_register() {
	    
		rp.setRegister();
	}

	@When("Enter  username {string} ,email {string} ,password {string}")
	public void enter_username_email_password(String string, String string2, String string3) {
	    rp.setUsername(string);
	    rp.setEmail(string2);
	    rp.setPassword(string3);
	}

	@When("click the create account")
	public void click_the_create_account() {
	    rp.setRegisterBtn();
	   
	}
	
	//=======================================================================================================
	
	@Given("user on the Login Page")
	public void user_on_the_login_page() {
	    driver.get(url);
	}

	@When("click on Register link")
	public void click_on_register_link() {
		 
		rp.setRegister();
		
	}

	@When("Enter  username1 {string} ,email1 {string} ,password1 {string}")
	public void enter_username1_email1_password1(String string, String string2, String string3) {
		    rp.setUsername(string);
		    rp.setEmail(string2);
		    rp.setPassword(string3);
	}

	@When("user clicks Register button")
	public void user_clicks_register_button() {
	    
		rp.setRegisterBtn();
	}

	@Then("diplay register page")
	public void diplay_register_page() {
	    String str="CREATE ACCOUNT";
		if(str.equals(rp.setRegisterBtnText()));
		
	}



	
	
	
	@After
	public void TearDown() {
		driver.close();
		
	}
}