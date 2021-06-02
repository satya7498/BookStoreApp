package com.book.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(id="loginuser")
	private WebElement username;
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='btnLogin']")
	private WebElement login;
	
	@FindBy(css="a[class='nav-link hoverLink mx-1']")	private WebElement logout;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/h2[1]")
	private WebElement loginText;

	public void setUsername(String username1) {
		username.sendKeys(username1);
	}

	public void setPassword(String password1) {
		password.sendKeys(password1);
	}

	public void setLogin() {
	    login.click();
	}
	
	public void setLogout() {
	
		logout.click();
	}
	public String verify() {
		return loginText.getText();
	}
}
