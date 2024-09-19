package com.eatsure.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.eatsure.pom.android.LandingPage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(LandingPage.class.getName());
	public AndroidActions(AndroidDriver driver) {
//		super(driver);
		this.driver = driver;
	}

	// Long Press-Right Click
	/**
	 * Description: Long press on any Key
	 * 
	 * @param ele
	 * @author vivek ranjan
	 * date:- 13-Mar-2024
	 */
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	// Swipe:-
	/**
	 * Description: Swipe the screen "left" or "right"
	 * 
	 * @param ele
	 * @param direction
	 * @author vivek ranjan
	 */
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
	}

	// Scroll to text
	/**
	 * Description: Scroll till "text"
	 * 
	 * @param text
	 * @author vivek ranjan date:- 13/03/2024
	 */
//	public void scrollToText(AndroidDriver driver,String text) {
		public void scrollToText(String text) {
		try {
//		driver.findElement(AppiumBy
//				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
		log.info("Successfully scroll to text " + text );
		} catch (Exception e) {
		log.info("Unable to scroll to text " + text );
		}
		}
	

	// Scroll-Infinite
	/**
	 * Description: Scroll Infinite
	 * 
	 * @author vivek ranjan date:- 13/03/2024
	 */
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

		} while (canScrollMore);
	}

	/**
	 * Description:- Scroll up
	 * @param ele
	 * @author vivek ranjan
	 * date:- 15-March-2024
	 */
	public void scrollDown() {
//	public void scrollDown(WebElement ele) {
//		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//				.of( "elementId", ((RemoteWebElement) ele).getId(),"left", 100, "top", 100, "width", 200, "height", 200, "direction", "up", "percent", 3.0));
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
				.of( "left", 100, "top", 100, "width", 200, "height", 200, "direction", "up", "percent", 3.0));
	}
	/**
	 * Description:- Scroll down
	 * @param ele
	 * @author vivek ranjan
	 * date:- 15-March-2024
	 */
	public void scrollUp() {
//		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//				.of( "elementId", ((RemoteWebElement) ele).getId(),"left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
				.of( "left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));


	}
	
	// scroll-scroll till element
	/**
	 * Description: Scroll till element
	 * 
	 * @param ele
	 * @author vivek ranjan date:- 13/03/2024
	 */
	public void scrollable(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId()));

	}
	
	
	

}
