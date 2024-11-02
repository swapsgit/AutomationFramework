package com.testCases;

import java.io.File;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.projx.driver.DriverManager;
import com.utilities.ExtentReport;

public class Base {
	public static WebDriver driver;

//	public String baseUrl = "https://demo.guru99.com/v4/";
	public String uId = "mngr573332";
	public String passWord = "vabapEg";
	public String ChromepropertyString = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "driver" + File.separator + "chromedriver.exe";

	public String GeckopropertyString = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "driver" + File.separator + "geckodriver.exe";
	Logger logger;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;

	protected Base() {

	}

	@BeforeClass()
	@Parameters({"browser"})
	public void setup(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", ChromepropertyString);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
				/*
				 * driver = new ChromeDriver(); driver.manage().window().maximize();
				 */
				DriverManager.setDriver(new ChromeDriver());
//		DriverManager.getDriver().get(baseUrl)
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", GeckopropertyString);
				DriverManager.setDriver(new FirefoxDriver());

			}
		}

	}

	@BeforeTest
	public void startReport() {
		
			htmlReporter = new ExtentSparkReporter("C:\\Users\\Swapnil\\eclipse-workspace\\AdvanceProjX\\test-output\\Index.html");

			//configuration to change look and feel
			htmlReporter.config().setDocumentTitle("Extent Report Demo");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTheme(Theme.STANDARD); //or dark
			htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a '('zzz')'");
			
			reports = new ExtentReports();
			reports.attachReporter(htmlReporter);

			//add environment details
			reports.setSystemInfo("Machine", "testPC01");
			reports.setSystemInfo("OS", "Windows 10");
			reports.setSystemInfo("User", "Swapnil");
			reports.setSystemInfo("Browser", "Chrome");	
		
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
			
			String screenshotPath = ExtentReport.getScreenshot(DriverManager.getDriver(), result.getName());
			test.addScreenCaptureFromPath(screenshotPath+".png");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skip", ExtentColor.YELLOW));

		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\Swapnil\\eclipse-workspace\\AdvanceProjX\\Screenshots\\" + screenshotName + ".jpeg";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}

	@AfterTest
	public void endReport() {
		
		reports.flush();
		}
	

	@AfterClass
	public void teardown() {
		// driver.quit();
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}

}
