package com.testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.projx.constants.FrameworkConstants;
import com.projx.driver.DriverManager;
import com.utilities.ExtentReport;
import com.utilities.ReadProp;

public final class TC_LoginTest extends Base {

	private TC_LoginTest() {
	}

	@Test(enabled = true, retryAnalyzer = com.utilities.Retry.class)
	public void loginTest() throws Exception {
	
		test=reports.createTest("Login Test");

		logger = LogManager.getLogger(TC_LoginTest.class);

		logger.info("opened browser");

		DriverManager.getDriver().get(ReadProp.readProperty("baseUrl")); //
		logger.info("opened browser");

		LoginPage lp = new LoginPage(DriverManager.getDriver());

		/*
		 * lp.entertxtuid(FrameworkConstants.getUsername());
		 * logger.info("Entered username");
		 * 
		 * lp.entertxtpassword(FrameworkConstants.getPassword());
		 * logger.info("Entered password"); lp.clickbtnLogin();
		 */
		lp.entertxtuid(FrameworkConstants.getUsername()).entertxtpassword(FrameworkConstants.getPassword())
				.clickbtnLogin();

		logger.info("clicked Login");
		if (DriverManager.getDriver().getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("Test Passed");
//			ExtentReport.test.pass("Test Passed extent Report");
		} else {
			Assert.assertTrue(false);
			logger.info("Test Failed");
//			ExtentReport.test.fail("Test Fail Extent Report");
		}

	}
}
