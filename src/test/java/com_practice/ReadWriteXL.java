package com_practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import com_practice.XLUtiles;
public class ReadWriteXL {
	
	//implementation
	//@Test(DataProviderClass=package.class.class, DataProvider="data")
	@DataProvider(name="data")
	public String[][] getData() throws IOException
	{
		String path="";
		int rownum=XLUtiles.getRowCount(path, "sheet1");
		int colnum=XLUtiles.getCellCount(path, "sheet1", 1);
		
		String data[][]=new String[rownum][colnum];
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				data[i-1][j]=XLUtiles.getCellData(path, "sheet1", i, j);
			}
		}
		return data;
	}

}
