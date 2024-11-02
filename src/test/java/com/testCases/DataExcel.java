package com.testCases;

import org.testng.annotations.Test;

public class DataExcel {

	@Test(dataProviderClass=com.utilities.ReadWriteExcel.class, dataProvider="LoginData", enabled=false)
	public void test1(String u, String p, String a, String s)
	{
		System.out.println(u+" "+p+" "+a+" "+s);
	}
	
}
  