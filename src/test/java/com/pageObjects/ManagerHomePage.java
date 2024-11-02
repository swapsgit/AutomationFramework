package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
	static WebDriver driver;

	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manager")
	WebElement btnManager;

	public ManagerHomePage clickManager() {
		btnManager.click();
		return this;
	}

	@FindBy(linkText = "New Customer")
	WebElement btnNewCustomer;

	public NewCustomerPage clickNewCustomer() {
		btnNewCustomer.click();
		return new NewCustomerPage(driver);
	}

}
