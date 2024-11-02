package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projx.driver.DriverManager;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	private WebElement txtuid;

	@FindBy(name = "password")
	private WebElement txtpassword;

	@FindBy(name = "btnLogin")
	private WebElement btnLogin;

	@FindBy(name = "btnReset")
	private WebElement btnReset;
	
	
	
//	
//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/div[2]")
//	WebElement electronics;

//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/div[3]")
//	WebElement home_furni;
//	
//	
//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/a[3]")
//	WebElement appliances;
//	
//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/a[4]")
//	WebElement travel;
//	
//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/div[4]")
//	WebElement beuty_toys;
//	
//	@FindBy(xpath="//div[@class=\"_3sdu8W emupdz\"]/div[5]")
//	WebElement twowheelers;

	public LoginPage entertxtuid(String str) {
		txtuid.sendKeys(str);
		return this;
	}

	public LoginPage entertxtpassword(String str) {
		txtpassword.sendKeys(str);
		return this;
	}

	public ManagerHomePage clickbtnLogin() {
		explicitWait(btnLogin);
		btnLogin.click();
		return new ManagerHomePage(driver);
	}

	public ManagerHomePage clickbtnReset() {
		explicitWait(btnReset);
		btnReset.click();
		return new ManagerHomePage(driver);
	}
//	public void clickelectronics()
//	{
//		electronics.click();
//	}
//	public void clickhome_furni()
//	{
//		home_furni.click();
//	}
//	public void clickAppliances()
//	{
//		appliances.click();
//	}
//	public void clickTravel()
//	{
//		travel.click();
//	}
//	public void clickbeuty_toys()
//	{
//		beuty_toys.click();
//	}
//	public void clicktwowheelers()
//	{
//		twowheelers.click();
//	}
	private void explicitWait(WebElement by)
	{
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(by));
	}

}
