package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadWriteExcel {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path="C:\\Users\\Swapnil\\eclipse-workspace\\AdvanceProjX\\src\\main\\resources\\TestDate.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colnum=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
