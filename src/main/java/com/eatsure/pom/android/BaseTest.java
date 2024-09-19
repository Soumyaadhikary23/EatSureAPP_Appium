package com.eatsure.pom.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest  {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static Properties prop;
	

	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				// System.getProperty("user.dir") +
				// "/src//main//java//com//eatsure//resources//data.properties");
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestRunDetails.properties");

		prop.load(fis);
		String ipAddress = prop.getProperty("IpAddress");
		String portStr = prop.getProperty("port");
		int portInt = Integer.parseInt(portStr);
		//Below line commented for browser stack
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\cbnits\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(portInt).build();
		// To start the service
		service.start();
     
		UiAutomator2Options options = new UiAutomator2Options();
		
		//Below line commented for browser stack
		options.setPlatformName("Android");
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
//		options.setApp(
//				 "C:\\Users\\vivek ranjan\\Documents\\eatsure-appium-automation-BX-19575\\src\\test\\resources\\app-staging-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\app-eatsureTest-debug (4).apk");
				 
//		options.setChromedriverExecutable(
//				"C://Users//vivek ranjan//Documents//eatsure-appium-automation-BX-19575//src//test//resources//chromedriver.exe");
		options.setChromedriverExecutable("D:\\new Eatsure\\src\\test\\resources\\chromedriver.exe");
//		options.setApp(
//				"C://Users//vivek ranjan//Documents//eatsure-appium-qa-automation//eatsure-appium-qa-automation//src//test//java//resources//General-Store.apk");
		options.setCapability("appium:settings[waitForIdleTimeout]", 500);
		
		
		
		
//		DesiredCapabilities dc = new DesiredCapabilities();
//        // OS Name
//        dc.setCapability("automationName", "Appium");
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("platformVesrion", "13");
//        dc.setCapability("deviceName", "androidTiramisu");
//        dc.setCapability("newCommandTimeout", "650000");
//        // dc.setCapability("appPackage", "com.driverapp");
//        dc.setCapability("app", "C://Users//vivek ranjan//Documents//eatsure-appium-qa-automation//eatsure-appium-automation//src//test//resources//app-staging-debug.apk");
//        
		String url = String.format("http://%s:%d", ipAddress, portInt);
		
		driver = new AndroidDriver(new URI(url).toURL(), options);
		
		
		//Browser stack capability
//		MutableCapabilities capabilities = new UiAutomator2Options();
//		capabilities.setCapability("appium:settings[waitForIdleTimeout]", 500);
//		driver = new AndroidDriver(new URI(url).toURL(), capabilities);
		
		
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
//		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.className("android.widget.EditText")).clear();
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("staging26");
		
//		ExtentReport.initialize();
		
	}


	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
