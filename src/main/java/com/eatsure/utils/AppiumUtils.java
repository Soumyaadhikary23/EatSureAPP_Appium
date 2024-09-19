package com.eatsure.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
//	AppiumDriver driver;
	public AppiumDriverLocalService service;
	
//	public AppiumUtils(AppiumDriver driver) {
//		this.driver = driver;
//	}
	/**
	 * Description:-get Formatted amount
	 * 
	 * @param amount
	 * @return
	 * @author vivek ranjan Date:- 14/03/2024
	 */
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
//	public AppiumDriverLocalService startAppiumServer() {
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File(
//						"C://Users//vivek ranjan//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		// To start the service
//		service.start();
//		return service;
//	}
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extent report pick file and attach to report
		
		
		
	}

}
