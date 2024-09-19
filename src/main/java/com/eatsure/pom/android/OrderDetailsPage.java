package com.eatsure.pom.android;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderDetailsPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(PaymentPage.class.getName());
	public static WebDriverWait wait;

	public OrderDetailsPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvOrderCrn")
	private WebElement orderCrn;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTimeLabel")
	private WebElement orderPlacedTime;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvItemCount")
	private WebElement totalItemCount;

	@AndroidFindBy(id = "com.done.faasos.debug:id/rbOrderReceivedText")
	private WebElement orderReceivedText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/rbOrderCookText")
	private WebElement orderCookText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/rbOrderOutForDeliveryText")
	private WebElement orderOutForDeliveryText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductName,com.done.faasos.debug:id/tvComboName")
	private WebElement productName;
	
	
        
	
//	@AndroidFindBy(id = "com.done.faasos.debug:id/tvComboName")
//	private WebElement comboName;


	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductPrice || com.done.faasos.debug:id/tvComboPrice" )
	private WebElement productPrice;
	
//	@AndroidFindBy(id = "com.done.faasos.debug:id/tvComboPrice" )
//	private WebElement comboPrice;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvPaymentTitle")
	private WebElement viewTaxesAndOtherChargesLink;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvDeliveryAddress")
	private WebElement deliveryAddressText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvAddressLabel")
	private WebElement addressLabel;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvAddressDetail")
	private WebElement addressDetail;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvBillTotalRowItem")
	private WebElement grandTotalText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvBillTotalRowPrice")
	private WebElement grandTotalAmount;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvSplitPaymentMode")
	private WebElement paidByText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvPaymentTotal")
	private WebElement paidByTotalAmount;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvHelp")
	private WebElement helpButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivBackButton")
	private WebElement backButton;

	/**
	 * Description: Verify Help Button
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyHelpButton(AndroidDriver driver) {

		if (helpButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order Crn
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */

	public boolean verifyOrderCrn(AndroidDriver driver) {

		if (orderCrn.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order Placed Time
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderPlacedTime(AndroidDriver driver) {

		if (orderPlacedTime.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Total Item Count
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyTotalItemCount(AndroidDriver driver) {

		if (totalItemCount.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order Received Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderReceivedText(AndroidDriver driver) {

		if (orderReceivedText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order Cook Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderCookText(AndroidDriver driver) {

		if (orderCookText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Order OutForDelivery Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyOrderOutForDeliveryText() {
try {
		orderOutForDeliveryText.isDisplayed();
			return true;
		}
catch (Exception e) {
		return false;
}
	
	}

	/**
	 * Description: Verify Product Name
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyProductName() {

		if (productName.isDisplayed()){
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
	 * Description: Verify View TaxesAndOtherChargesLink
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyViewTaxesAndOtherChargesLink(AndroidDriver driver) {
     
		if (viewTaxesAndOtherChargesLink.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Delivery Address Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyDeliveryAddressText(AndroidDriver driver) {

		if (deliveryAddressText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Address Label
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyAddressLabel(AndroidDriver driver) {

		if (addressLabel.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Address Detail
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyAddressDetail(AndroidDriver driver) {

		if (addressDetail.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Grand Total Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyGrandTotalText(AndroidDriver driver) {

		if (grandTotalText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify Grand Total Amount
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyGrandTotalAmount(AndroidDriver driver) {

		if (grandTotalAmount.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify PaidBy Text
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyPaidByText(AndroidDriver driver) {

		if (paidByText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify PaidBy Total Amount
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public boolean verifyPaidByTotalAmount(AndroidDriver driver) {

		if (paidByTotalAmount.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify click ViewTaxesAndOtherCharges Link
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public void clickViewTaxesAndOtherChargesLink(AndroidDriver driver) {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvPaymentTitle")));
			viewTaxesAndOtherChargesLink.click();
//			driver.executeScript("mobile: doubleClickGesture",
//			ImmutableMap.of("elementId", ((RemoteWebElement) viewTaxesAndOtherChargesLink).getId()));
			log.info("Click on View Taxes And Other Charges Link successfully");
		} catch (Exception e) {
			log.info("View Taxes And Other Charges Link is not present");
		}
	}

	/**
	 * Description: Verify retrieve Grand Total Amount
	 * 
	 * @param stagingNumber
	 * @author Pankaj Gokhale
	 * @date 10th-April-2024
	 */
	public int retrieveGrandTotalAmount() {
		String retrieveAmount = grandTotalAmount.getText().split("")[1];
		int viewOrdersAmount = Integer.parseInt(retrieveAmount);
		log.info("Grand Total :- " + viewOrdersAmount);
		return viewOrdersAmount;

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
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/ivBackButton")));
			backButton.click();
//			driver.executeScript("mobile: doubleClickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) backButton).getId()));
			log.info("Click on Back button successfully");
		} catch (Exception e) {
			log.info("Back Button is not present");
		}
	}
}
