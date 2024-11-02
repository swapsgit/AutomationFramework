package com_practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadWritexl1 {

	@DataProvider(name="logindata")
	public String[][] getData() throws IOException
	{
		String path="";
		int rowNum=XLUtils1.getRowCount(path, "sheet1");
		int cellNum=XLUtils1.getCellCount(path, "sheet1", 1);
		
		String data[][]=new String[rowNum][cellNum];
		for(int i=1;i<rowNum;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				data[i-1][j]=XLUtils1.getCellData(path, "sheet1", i, j);
			}
		}
		return data;
	}
}
