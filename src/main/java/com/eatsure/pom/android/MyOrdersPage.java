package com.eatsure.pom.android;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.eatsure.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyOrdersPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(PaymentPage.class.getName());
	public static WebDriverWait wait;

	public MyOrdersPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/toolbarTitle")
	private WebElement myOrdersText;

	@AndroidFindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.done.faasos.debug:id/rbOrderCookText'])[1]")
	private WebElement orderState;
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductName")
	private WebElement productName;
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductPrice")
	private WebElement productPrice;
	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id='com.done.faasos.debug:id/btnTrackOrder'])[1]")
	private WebElement btnTrackOrder;
	
	//Locator for Locality Page-My Profile

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
	private WebElement myProfile;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Orders']")
	private WebElement myOrders;
	
	//android.widget.TextView[@text='My Orders']
	

	/**
	 * Description: Verify MyOrders Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyMyOrdersText(AndroidDriver driver) {

		if (myOrdersText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order State
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderState(AndroidDriver driver) {

		if (orderState.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Product Name
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyProductName(AndroidDriver driver) {

		if (productName.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Product Price
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyProductPrice(AndroidDriver driver) {

		if (productPrice.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Track Order Button
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyBtnTrackOrder(AndroidDriver driver) {

		if (btnTrackOrder.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify retrieve Amount
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public int retrieveAmount() {
		String retrieveAmount = productPrice.getText().split("")[1];
		int myOrdersAmount = Integer.parseInt(retrieveAmount);
		return myOrdersAmount;

	}

	/**
	 * Description: Verify Track MyOrder Button
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public void clickTrackMyOrderButton(AndroidDriver driver) {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Button[@resource-id='com.done.faasos.debug:id/btnTrackOrder'])[1]")));
			btnTrackOrder.click();
			log.info("Click on Track Order Button successfully");
		} catch (Exception e) {
			log.info("Track Order Button is not present");
		}
	}

	/**
	 * Description: Verify My Profile click
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 21th-April-2024
	 */
	public void clickMyProfile() {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='My Profile']")));
			myProfile.click();
			log.info("Click on My Profile footer successfully");
		} catch (Exception e) {
			log.info("Unable to Click on My Profile footer");
		}
	}
	
	/**
	 * Description: Verify My Orders click
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 21th-April-2024
	 */
	public void clickMyOrder() {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='My Orders']")));
			myOrders.click();
			log.info("Click on My Orders  successfully");
		} catch (Exception e) {
			log.info("Unable to  My Orders  successfully");
		}
	}


}
