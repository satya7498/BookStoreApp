package com.book.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/p[1]/a[1]")
	private WebElement register;

	@FindBy(id="username")
	private WebElement username;

	@FindBy(xpath="//input[@id='registeremail']")
	private WebElement email;
 
	@FindBy(css="#registerpassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='btnRegister']")
	private WebElement registerBtn;
	

	public void setRegister() {
		register.click();
	}


	public void setUsername(String username1) {
		username.sendKeys(username1);
	}


	public void setEmail(String email1) {
		email.sendKeys(email1);
	}


	public void setPassword(String password1) {
		password.sendKeys(password1);
	}
	
	public void setRegisterBtn() {
		registerBtn.click();
	}
	public String setRegisterBtnText() {
		String text=registerBtn.getText();
		return text;
		
	}
	
	
	
}