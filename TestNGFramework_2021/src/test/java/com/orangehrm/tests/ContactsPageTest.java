package com.orangehrm.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.ContactsPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.util.Constants;
import com.orangehrm.util.ExcelUtil;

public class ContactsPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
	}
	@Test(priority = 1)
	public void veryfyContactPageTitle() {
		String title = contactsPage.getContactSPageTitle();
		System.out.println("contact page title "+title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	@DataProvider()
	public Object [][] getContactData(){
		Object data [][] = ExcelUtil.getTestData("Sayfa1");
		return data;
				}
	@Test(priority = 2, dataProvider = "getContactData")
	public void createContactTest(String FirstName,String MiddleName, String LastName,String EmployeeId,String UserName,String Password,String ConfirmPassword) throws InterruptedException {
		contactsPage.addNewEmployee(FirstName, MiddleName, LastName, EmployeeId, UserName, Password, ConfirmPassword);
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	
}
