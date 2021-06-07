package com.orangehrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.base.BasePage;
import com.orangehrm.util.Constants;
import com.orangehrm.util.ElementUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	//locators
	
	By firsName = By.id("firstName");
	By middleName = By.id("middleName");
	By lastName = By.id("lastName");
	By employeeId = By.id("employeeId");
	By clickLogin = By.id("chkLogin");
	
	By userName = By.id("user_name");
	By password = By.id("user_password");
	By comfirmPswrd = By.id("re_password");
	By save = By.id("btnSave");
	
	public String getContactSPageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}
	public void addNewEmployee(String firsN,String  middleN,String lastN,String empId,
			String userN , String pwrd,String cmfrmPswrd) throws InterruptedException {
	
		Thread.sleep(2000);
		elementUtil.doSendKeys(firsName, firsN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(middleName, middleN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(lastName, lastN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(employeeId, empId );
		Thread.sleep(2000);
		elementUtil.doClick(clickLogin);
		Thread.sleep(2000);
		elementUtil.doSendKeys(userName, userN);
		Thread.sleep(2000);
		elementUtil.doSendKeys(password, pwrd);
		Thread.sleep(2000);
		elementUtil.doSendKeys(comfirmPswrd, cmfrmPswrd);
		Thread.sleep(2000);
		elementUtil.doClick(save);
	}
	
}
