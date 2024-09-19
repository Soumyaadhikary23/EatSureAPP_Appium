package com.eatsure.pom.android;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrackingPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(PaymentPage.class.getName());
	public static WebDriverWait wait;

	public TrackingPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Max Savings']")
	private WebElement maxSavingsDisplayInOrderPlacePopup;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sure Points']")
	private WebElement surePointsDisplayInOrderPlacePopup;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_order_placed_close")
	private WebElement orderPlaceClosePopup;

	@AndroidFindBy(id = "com.done.faasos.debug:id/toolbarTitle")
	private WebElement liveOrderTrackingTextDisplay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvOrderTrackItemPrice")
	private WebElement totalItemsWithPriceTextDisplay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvHelp")
	private WebElement helpButtonTextDisplay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTrackOrderViewDetails")
	private WebElement viewMyOrderDetailsLinkDisplay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/orderStatesContainer")
	private WebElement orderStatusSectionDisplay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivBackButton")
	private WebElement backButton;

	/**
	 * Description: Verify Max Savings Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyMaxSavingsDisplayInOrderPlacePopup(AndroidDriver driver) {

		if (maxSavingsDisplayInOrderPlacePopup.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Sure Points Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifySurePointsDisplayInOrderPlacePopup(AndroidDriver driver) {

		if (surePointsDisplayInOrderPlacePopup.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Order Place Close Popup Click
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public void OrderPlaceClosePopupClick() throws Exception {
		Thread.sleep(3000);
		orderPlaceClosePopup.click();
	}

	/**
	 * Description: Verify Live Order Tracking Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyLiveOrderTrackingTextDisplay(AndroidDriver driver) {

		if (liveOrderTrackingTextDisplay.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Total Items With Price Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyTotalItemsWithPriceTextDisplay(AndroidDriver driver) {

		if (totalItemsWithPriceTextDisplay.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Total Items Count
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public int retrieveItemsCount() {
		String retrieveItem = totalItemsWithPriceTextDisplay.getText().split(" ")[0];
		int itemCount = Integer.parseInt(retrieveItem);
		return itemCount;

	}

	/**
	 * Description: Verify Price Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public int retrievePrice() {
		// Define the string
		String input = totalItemsWithPriceTextDisplay.getText();

		// Split the string by the pipe symbol '|'
		String[] parts = input.split("\\|");

		// Extract the amount from the second part
		String amountString = parts[1].trim();

		// Remove the currency symbol '₹' and extract the amount
		String amount = amountString.substring(1);
		int price = Integer.parseInt(amount);
		log.info(price);
		return price;

	}

	/**
	 * Description: Verify Help Button Text Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyHelpButtonTextDisplay(AndroidDriver driver) {

		if (helpButtonTextDisplay.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify View MyOrder Details Link Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyViewMyOrderDetailsLinkDisplay(AndroidDriver driver) {

		if (viewMyOrderDetailsLinkDisplay.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order Status Section Display
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderStatusSectionDisplay(AndroidDriver driver) {

		if (orderStatusSectionDisplay.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify View MyOrder Details Link Click
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */

	public void clickMyOrderDetailsLink() {
		
		try {
//			   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvTrackOrderViewDetails")));
					viewMyOrderDetailsLinkDisplay.click();
					log.info("clickMyOrderDetailsLink button successfully");
				} catch (Exception e) {
					log.info("Unable to clickMyOrderDetailsLink button successfully");
				}
			
	}

	/**
	 * Description: Verify Click Back Button
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public void clickBackButton(AndroidDriver driver) {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/ivBackButton")));
			backButton.click();
			log.info("Click on Back button successfully");
		} catch (Exception e) {
			log.info("Back Button is not present");
		}
	}

}
