package com.orangehrm.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.util.Constants;
//@Listeners(com.orangehrm.listeners.TestAllureListener.class)
@Listeners(com.orangehrm.listeners.ExtentReportListener.class)
public class LoginPageTest {
	Logger log = Logger.getLogger("LoginPageTest");
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		log.info("browser is launching...");
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}
	@Test(priority = 2, description = "Login test is using correct username and password")
	public void loginTest1() {
		log.info("loginTest1 is starting...");
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("logintest1 is ending...");
	}
	@Test(priority = 3, description = "Login test is using incorrect username and password")
	public void loginTest2() {
		loginPage.doLogin(prop.getProperty("incorrectuser"), prop.getProperty("password"));
	}
	@Test(priority = 4, description = "Login test is using incorrect username and incorrect password")
	public void loginTest3() {
		loginPage.doLogin(prop.getProperty("incorrectuser"), prop.getProperty("incorrectpass"));
	}
	
	@Test(priority = 1, description = "get title from orangehrm login page")
	public void getTitle() {
		String title = loginPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"title is in=correct");
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	
	
}
