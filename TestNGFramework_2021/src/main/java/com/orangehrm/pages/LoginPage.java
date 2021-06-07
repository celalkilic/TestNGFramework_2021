package com.orangehrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.orangehrm.base.BasePage;
import com.orangehrm.util.Constants;
import com.orangehrm.util.ElementUtil;

public class LoginPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	//Locators
	By usernameID = By.id("txtUsername");
	By passwordID = By.id("txtPassword");
	By loginBtnID = By.id("btnLogin");
	
	//Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	
	public String getPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
		//return driver.getTitle();
	}
	
	public HomePage doLogin(String username, String pwd) {
		elementUtil.doSendKeys(usernameID, username);
		elementUtil.doSendKeys(passwordID, pwd);
		elementUtil.doClick(loginBtnID);
		//driver.findElement(usernameID).sendKeys(username);
		//driver.findElement(passwordID).sendKeys(pwd);
		//driver.findElement(loginBtnID).click();
		return new HomePage(driver);
	}	
}
