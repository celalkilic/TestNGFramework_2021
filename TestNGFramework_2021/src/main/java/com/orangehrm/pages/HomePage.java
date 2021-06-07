package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;
import com.orangehrm.util.Constants;
import com.orangehrm.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locators
	By header = By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
	By accountName = By.xpath("//a[@class = 'panelTrigger']");
	
	By pim = By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b");
	By addEmployee = By.id("menu_pim_addEmployee");
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public String getHomePageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
		//return driver.getTitle();
	}
	public String getHomePageHeader() {
		return elementUtil.doGetText(header);
		//return driver.findElement(header).getText();
	}
	public String verfyLoggedAccountName() {
		return elementUtil.doGetText(accountName);
		//return driver.findElement(accountName).getText();
	}
	private void clickOnAddEmployee() {
		elementUtil.doClick(pim);
		elementUtil.doClick(addEmployee);
	}
	public ContactsPage gotoContactsPage() {
		clickOnAddEmployee();
		return new ContactsPage(driver);
	}
}
