package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testCases.Base;

public class Listners extends Base implements ITestListener {

	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage" + result.getName());

	}

	public void onTestFailure(ITestResult fail) {
		System.out.println("Method failed" + fail.getName());
		String meth_name=fail.getMethod().getMethodName();
    	TakesScreenshot sc=(TakesScreenshot)driver;
    	File src=sc.getScreenshotAs(OutputType.FILE);
    	File dest=new File("C:\\Users\\Swapnil\\eclipse-workspace\\AdvanceProjX\\Screenshots\\"+meth_name+".jpg");
    	
    	try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult skip) {
		System.out.println("Method skipped" + skip.getName());

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());

	}

	public void onTestSuccess(ITestResult pass) {
		System.out.println("Method passed" + pass.getName());

	}

}
