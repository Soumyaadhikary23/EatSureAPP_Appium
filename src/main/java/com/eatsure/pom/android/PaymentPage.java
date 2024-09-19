package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(PaymentPage.class.getName());
	public static WebDriverWait wait;

	public PaymentPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pay with']")
	private WebElement paymentPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pay On Delivery']")
	private WebElement CODText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pay Online to ensure contactless delivery']")
	private WebElement CODBox;
	
	@FindBy(css=".sc-hKFxyN.dElcG")
	//@AndroidFindBy(xpath="(//android.widget.Button)[6]")
	private WebElement PayButton;
	
	@FindBy(xpath="//button[@class='sc-hKFxyN ioskmB']")
//	@AndroidFindBy(xpath="//button[@class='sc-hKFxyN ioskmB']")
	private WebElement BinLockingPoppedupPayButton;
	
	@AndroidFindBy(id="com.done.faasos.debug:id/tvOrderPlacedLabel")
	private WebElement orderPlaceMessage;
	
	@AndroidFindBy(xpath="//div[@class='sc-iemWCZ hKymwP']")
	private WebElement totalpriceTop;
	
	@FindBy(xpath="//div[contains(@class,'offer-removal-modal-title')]")
//	@AndroidFindBy(xpath="//div[contains(@class,'offer-removal-modal-title')]")
	private WebElement paymodeChanePOp;
	
	
	
	
	/**
	 * Description: verify the payment page title
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public boolean verifyPyamentTitle(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Pay with']")));
		if(paymentPageTitle.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Description: click on COD
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void clickCodRadioButton() {
		
		try {
			CODBox.isDisplayed();
			CODBox.click();
			log.info("Clicked on COD radio button successfully");
		} catch (Exception e) {
			log.info("Unable to click on COD radio button successfully");
		}
		
	}
	
	/**
	 * Description: verify the pay button
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public boolean payButtonVerify() {
		Set<String> contexts=driver.getContextHandles();
		for(String contextname:contexts) {
			log.info("Context Name " + contextname);
		}
		driver.context("WEBVIEW_com.done.faasos.debug");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-hKFxyN.dElcG")));
		if(PayButton.isDisplayed()) {
			return true;
			}
		return false;
	}
	
	/**
	 * Description: change to webview for pay button
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	
	public void ClickonPayButton(AndroidDriver driver) throws InterruptedException {
		driver.context("WEBVIEW_com.done.faasos.debug");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-hKFxyN.dElcG")));
		try {
			PayButton.isDisplayed();
			Actions a = new Actions(driver);
			a.moveToElement(PayButton).click().build().perform();
			Thread.sleep(3000);
			try {
				paymodeChanePOp.isDisplayed();
				BinLockingPoppedupPayButton.click();
				log.info("This order apply for billocking coupon");
			} catch (Exception e) {
				log.info("This order don't apply any billocking coupon");
			}
			
			driver.context("NATIVE_APP");
			log.info("Successfully clicked on  Payment Button");
		} catch (Exception e) {
			log.info("Unable to see Payment Button");;
		}
	}
	
	public int payPrice() {
		driver.context("WEBVIEW_com.done.faasos.debug");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-hKFxyN.dElcG")));
		String text=PayButton.getText().split("INR")[1].trim();
		int Amount = Integer.parseInt(text);
		return Amount;
	}
	
	/**
	 * Description: pay button click
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void PaybuttonClick() {
		PayButton.click();
	}
	
	
	/**
	 * Description: verify order place message
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	
	public boolean orderPlace(AndroidDriver driver) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvOrderPlacedLabel")));
		if(orderPlaceMessage.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public int totalPriceTop() {
	
	//driver.context("WEBVIEW_com.done.faasos.debug");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@class='android.widget.TextView'])[4]"))));
	String text=driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[4]")).getText().toString().trim();
	int totalAmount = Integer.parseInt(text);
	return totalAmount;
	
	
	}
	
	

	

}
