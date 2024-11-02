package com.utilities;

import java.io.File;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testCases.Base;

public final class ExtentReport extends Base implements IReporter {

	
	
	public ExtentReport() {
	}

	@BeforeSuite
	public void startReport() {
		if (Objects.isNull(reports)) {
			htmlReporter = new ExtentSparkReporter("Index.html");

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
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
			
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
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

	@AfterSuite
	public void endReport() {
		if(Objects.nonNull(reports)) {
		reports.flush();}
	}

}
