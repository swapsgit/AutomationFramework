package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.projx.constants.FrameworkConstants;

public class ReadProp {
	
	private ReadProp() {
		
		

	}
	private static Properties prop = new Properties();

	static {
		File file = new File(FrameworkConstants.getpropertyFilePath());
			
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				prop.load(fis);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static String readProperty(String Key) throws Exception
	{
		
		String value=prop.getProperty(Key);
		if(Objects.isNull(value))
		{
			throw new Exception("Property name "+ Key +" is not found. Please check config.properties");
			
		}
		return value;
	}

}
 