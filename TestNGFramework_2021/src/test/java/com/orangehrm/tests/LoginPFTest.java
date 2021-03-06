package com.orangehrm.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.LoginPagePF;

public class LoginPFTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPagePF loginPagePF;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPagePF = new LoginPagePF(driver);	
	}
	
	@Test
	
	public void loginTest() {
		loginPagePF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
