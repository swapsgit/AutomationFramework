package com.testCases;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.ManagerHomePage;
import com.pageObjects.NewCustomerPage;
import com.projx.driver.DriverManager;
import com.utilities.ExtentReport;
import com.utilities.ReadProp;

public final class TC_Login_NewCust_methodChain extends Base {

	@Test(enabled=true, dataProviderClass=com.utilities.ReadWriteExcel.class, dataProvider="LoginData")
	public void NewCust_methodChain(String name, String email, String dob, String gender, String add, String city, String stat, String pin, String mob, String pass) throws Exception {
		logger = LogManager.getLogger(TC_Login_NewCust_methodChain.class);
		test=reports.createTest("newCustMEthodChain");
		logger.info("NewCustomer Test Started");
		DriverManager.getDriver().get(ReadProp.readProperty("baseUrl"));

		LoginPage lp = new LoginPage(DriverManager.getDriver());
		ManagerHomePage mhp = lp.entertxtuid(uId).entertxtpassword(passWord).clickbtnLogin();
		NewCustomerPage ncp = mhp.clickNewCustomer().enterName(name).enterAddress(add).enterCityName(city)
				.enterDateOfBirth(dob).enterEmailid(email).enterpassword(pass)
				.enterPinCode(pin).enterStateName(stat).enterTelephoneNo(mob).selectGender(gender)
				.clickbtnSub();

		if (DriverManager.getDriver().findElement(By.xpath("//p[@class=\"heading3\"]")).getText()
				.equals("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true, "New Customer test failed __Message from Assertion__");
			logger.info("NewCustmer Test Passed name "+name);
		} else {
			Assert.assertTrue(false, "New Customer test failed __Message from Assertion__");
			logger.info("NewCustomer Test Failed");
		}

	}

}
