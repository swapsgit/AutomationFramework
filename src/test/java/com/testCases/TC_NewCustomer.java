package com.testCases;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.ManagerHomePage;
import com.pageObjects.NewCustomerPage;
import com.projx.constants.FrameworkConstants;
import com.projx.driver.DriverManager;
import com.utilities.ReadProp;

public final class TC_NewCustomer extends Base {

	private TC_NewCustomer() {
	}

	
	@Test(enabled=true)
	public void newCustTest() throws Exception {
		logger = LogManager.getLogger(TC_NewCustomer.class);
		test=reports.createTest("YC_NewCustMEthodChain");

		DriverManager.getDriver().get(ReadProp.readProperty("baseUrl"));
		LoginPage lp = new LoginPage(DriverManager.getDriver());
		lp.entertxtuid(FrameworkConstants.getUsername());
		lp.entertxtpassword(FrameworkConstants.getPassword());
		lp.clickbtnLogin();
		logger.info("New Customer Test Started");
		ManagerHomePage mhp = new ManagerHomePage(DriverManager.getDriver());
		mhp.clickNewCustomer();
		Thread.sleep(2000);

		new Actions(DriverManager.getDriver()).keyDown(Keys.ESCAPE).build().perform();
		new Actions(DriverManager.getDriver()).keyUp(Keys.ESCAPE).build().perform();

		NewCustomerPage ncp = new NewCustomerPage(DriverManager.getDriver());
		ncp.enterName("RadhaKrishna VikePatil");
		logger.info("Entered Name");

		ncp.selectGender("M");
		ncp.enterDateOfBirth("13121999");
		ncp.enterAddress("Main street Satara");
		ncp.enterCityName("Satara");
		ncp.enterStateName("Maharashtra");
		ncp.enterPinCode("413315");
		ncp.enterTelephoneNo("1215161314");
		ncp.enterEmailid("newtest7@gmail.com");
		logger.info("Entered Email");

		ncp.enterpassword("Rajaji@newPass24");
		logger.info("Entered Password");

		ncp.clickbtnSub();
		logger.info("Clicked Submit");
//		System.out.println(DriverManager.getDriver().findElement(By.xpath("//p[@class=\"heading3\"]")).getText());

//		Alert al=DriverManager.getDriver().switchTo().alert();
//		al.dismiss();

//		Guru99 Bank New Customer Entry Page

//		String title=DriverManager.getDriver().getTitle();

		if (DriverManager.getDriver().findElement(By.xpath("//p[@class=\"heading3\"]")).getText()
				.equals("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true, "New Customer test failed __Message from Assertion__");
			logger.info("NewCustmer Test Passed");
		} 
			  else { Assert.assertTrue(false,
			  "New Customer test failed __Message from Assertion__");
			  logger.info("NewCustomer Test Failed"); }
			 

	}

}
