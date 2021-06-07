package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.util.ElementUtilPF;

public class LoginPagePF {
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	
	//Page Factory Concept==@FindBy
	
	@FindBy(how = How.ID,using = "username")
	@CacheLookup
	WebElement usernameID;
	
	@FindBy(how = How.ID,using = "password")
	@CacheLookup
	WebElement passwordID;
	
	@FindBy(how = How.ID,using = "loginBtn")
	@CacheLookup
	WebElement loginbutton;

	public LoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtilPF = new ElementUtilPF(driver);
	}
	public void doLogin(String username, String pwd) {
		elementUtilPF.waitForElementPresent(usernameID);
		usernameID.sendKeys(username);
		passwordID.sendKeys(pwd);
		loginbutton.click();
	}
	
	
	
}
