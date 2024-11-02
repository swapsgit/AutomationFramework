package com.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {

	@Test(dataProvider="logindat", enabled=false)
	public void test1(String Usr, String pass, String asd)
	{
		for(int i=0;i<=3;i++)
		{
			System.out.println(Usr);
			System.out.println(pass);
			System.out.println(asd+"Login");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="logindat")
	public String[][] getData()
	{
		String[][] a= {{"Krishna","kri@12","asdal"},{"Sham","sh@nad"},{"raju","jha@la",""}};
		return a;
	}
	
	
}
