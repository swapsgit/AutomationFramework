package com_practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	//implementation
	//@Test(RetryAnalyzer=com_practice.RetryAnalyzer.class)
	int counter=0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		
		
		return false;
	}
	

}
