package com.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
