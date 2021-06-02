package com.book.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookListPage {

	@FindBy(id="loginuser")
	private WebElement username;
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='btnLogin']")
	private WebElement login;

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	private WebElement FavBtn;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[4]/div[1]/button[1]")
	private WebElement okbtn;
	
	@FindBy(id="searchbar")
	private WebElement search;
	
	@FindBy(xpath="/html[1]/body[1]/article[1]/div[1]/div[1]/div[1]/h1[1]")
	private WebElement verifyBook;
	
	@FindBy(xpath="//h1[contains(text(),'Seeing Theory')]")
	private WebElement readNowBooK;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	private WebElement readLink;
	
	public void setUsername(String username1) {
		username.sendKeys(username1);
	}

	public void setPassword(String password1) {
		password.sendKeys(password1);
	}

	public void setLogin() {
	    login.click();
	}
	public void setFavBtn() {
	    FavBtn.click();
	}
	
	public void setSearch() {
	    search.click();
	}
	public void setSearchText(String string) {
	    search.sendKeys(string);
	    
	    }
	public void setSearchText1(Keys return1) {
	    search.sendKeys(return1);
	    
	    }
	
	
	public String VerifyBookName() {
		return  verifyBook.getText();
	}

	public String readNowBooK() {
		return  readNowBooK.getText();
	}
	public void getreadLink() {
		readLink.click();
	}
	

	public void getOkBtn() {
		okbtn.click();
	}
	
	
	
}