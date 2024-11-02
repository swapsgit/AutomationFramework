package com_practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listners  implements ITestListener{
	public WebDriver driver=new ChromeDriver();
	    public void onFinish(ITestContext arg0) {					
	        		
	    }		

	    public void onStart(ITestContext arg0) {					
	        		
	    }		

	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        		
	    }		

	    public void onTestFailure(ITestResult fail) {					
	       
	    	String methName=fail.getMethod().getMethodName();
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File src =ts.getScreenshotAs(OutputType.FILE);
	    	File dest = new File("C:\\Users\\Swapnil\\eclipse-workspace\\AdvanceProjX\\Screenshots\\"+methName+".jpeg");
	    	
	    	try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    }		

	    public void onTestSkipped(ITestResult arg0) {					
	        		
	    }		

	    public void onTestStart(ITestResult arg0) {					
	        		
	    }		

	    public void onTestSuccess(ITestResult arg0) {					
	        		
	    }		

}
