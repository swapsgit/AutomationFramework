package com_practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.sun.java.swing.plaf.windows.TMSchema.Prop;

public class ReadProperties {
	private static Properties prop = new Properties();;

	static {
		File file = new File(
				"C:\\\\Users\\\\Swapnil\\\\eclipse-workspace\\\\AdvanceProjX\\\\src\\\\main\\\\resources\\\\config.properties");
		FileInputStream fls;
		try {
			fls = new FileInputStream(file);
			prop.load(fls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String readProperty(String key) {

		String value = prop.getProperty(key);
		return value;
	}
}
