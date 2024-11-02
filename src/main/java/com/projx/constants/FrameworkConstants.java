 package com.projx.constants;

import java.io.File;

import org.apache.logging.log4j.Logger;

public class FrameworkConstants {
	private FrameworkConstants(){
		
	}
	private static String baseUrl = "https://demo.guru99.com/v4/";
	private static String uId = "mngr573332";
	private static String passWord = "vabapEg";
	private static String propertyString = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "driver" + File.separator + "chromedriver.exe";

	private static String propertyFilePath=System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "config.properties";
	
	public static String getChromeDriverPath() {
		return propertyString;
	}
	public static String getUrl() {
		return baseUrl;
	}
	public static String getUsername() {
		return uId;
	}
	public static String getPassword() {
		return passWord;
	}
	public static String getpropertyFilePath() {
		return propertyFilePath;
	}
}
