package com.projx.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Drivers {

	private Drivers() {}
	public static WebDriver driver;
	

	
	public static void initdriver() {

		if(driver==null) {
			System.setProperty("webdriver.chrome.driver","");
			driver=new ChromeDriver();
			
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get("url");
		}
//		or use below
		if(Objects.isNull(driver)) {}
		
	}

	public static void quitdriver() {

		if(driver!=null)
		{
			driver.quit();
		}
//		above or below method is usually used to avoid opening of the new browser if there one already open.
		if(Objects.nonNull(driver)) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
