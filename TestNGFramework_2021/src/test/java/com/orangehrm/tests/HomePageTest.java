package com.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test (priority = 1, description = "get home page title")
	public void verfyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is "+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
	@Test(priority = 2,description = "get home page header")
	public void verfyHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is "+header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	@Test(priority = 3, description = "get account name in home page")
	public void verfyLoggedInUserAccount() {
	String accountName = homePage.verfyLoggedAccountName();
	System.out.println(accountName);
	Assert.assertEquals(accountName, Constants.ACCOUNT_NAME);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
