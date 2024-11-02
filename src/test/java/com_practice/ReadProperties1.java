package com_practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties1 {

	private static Properties prop=new Properties();
	
	private static void readProperty()
	{
		File file=new File("");
		try {
			FileInputStream fls=new FileInputStream(file);
			try {
				prop.load(fls);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key)
	{
		String value=prop.getProperty(key);
		return value;
	}
}
