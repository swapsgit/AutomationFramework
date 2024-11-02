package com_practice;

import org.testng.annotations.DataProvider;

public class ReadWritexl2 {

	//@Test(DataProvider=package.classname.class, DataProviderName="")
	@DataProvider(name="data")
	public String[][] getData()
	{
		String path="";
		String xlsheet="";
		int rowCount=XLUtils2.getRowCount(path, xlsheet);
		int cellCount=XLUtils2.getCellCount(path, xlsheet, 1);
		
		String data[][]=new String[rowCount][cellCount];
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				data[i-1][j]=XLUtils2.getCellData(path, xlsheet, i, j);
			}
		}
		return data;
	}
}
