package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "name")
	WebElement txtName;

	public NewCustomerPage enterName(String str) {
		txtName.sendKeys(str);
		return this;
	}

	@FindBy(xpath = "//input[@value=\"m\"]")
	WebElement radMale;
	@FindBy(xpath = "//input[@value=\"f\"]")
	WebElement radFemale;

	public NewCustomerPage selectGender(String gend) {
		if (gend.startsWith("M")) {
			radMale.click();
		} else {
			radFemale.click();
		}
		return this;

	}

	@FindBy(id = "dob")
	WebElement txtDob;

	public NewCustomerPage enterDateOfBirth(String str) {
		txtDob.sendKeys(str);
		return this;

	}

	@FindBy(name = "addr")
	WebElement txtAddr;

	public NewCustomerPage enterAddress(String str) {
		txtAddr.sendKeys(str);
		return this;

	}

	@FindBy(name = "city")
	WebElement txtCity;

	public NewCustomerPage enterCityName(String str) {
		txtCity.sendKeys(str);
		return this;

	}

	@FindBy(name = "state")
	WebElement txtState;

	public NewCustomerPage enterStateName(String str) {
		txtState.sendKeys(str);
		return this;

	}

	@FindBy(name = "pinno")
	WebElement txtPin;

	public NewCustomerPage enterPinCode(String str) {
		txtPin.sendKeys(str);
		return this;

	}

	@FindBy(name = "telephoneno")
	WebElement txttelephoneno;

	public NewCustomerPage enterTelephoneNo(String str) {
		txttelephoneno.sendKeys(str);
		return this;

	}

	@FindBy(name = "emailid")
	WebElement txtemailid;

	public NewCustomerPage enterEmailid(String str) {
		txtemailid.sendKeys(str);
		return this;

	}

	@FindBy(name = "password")
	WebElement txtpassword;

	public NewCustomerPage enterpassword(String str) {
		txtpassword.sendKeys(str);

		return this;
	}

	@FindBy(name = "sub")
	WebElement btnSub;

	public NewCustomerPage clickbtnSub() {
		btnSub.click();
		return this;
	}

	@FindBy(name = "res")
	WebElement btnRes;

	public NewCustomerPage clickbtnRes() {
		btnRes.click();
		return this;
	}

}
