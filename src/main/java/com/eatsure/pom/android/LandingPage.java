package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LandingPage extends AndroidActions{
	public AppiumDriverLocalService service; 
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(LandingPage.class.getName());
	public static  WebDriverWait wait; 
	 public LandingPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		// TODO Auto-generated constructor stub
	}
	

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	private WebElement searchLocationBox1;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement searchLocationBox2;
	
	@AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement searchLocationBox3;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement okButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvOnboardingText")
	private WebElement onboardingText;
	
//	@AndroidFindBy(xpath = "//android.widget.Button[@text='Explore Restaurants']")
	@AndroidFindBy(id = "com.done.faasos.debug:id/btnSetYourLocationBB")
//	@AndroidFindBy(id = "com.done.faasos.debug:id/btnSetYourLocation")
	private WebElement exploreRestaurantsButton;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	private WebElement permissionDenyButton;
	
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement permissionOnlyThisTimeButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_alfredMessage")
	private WebElement helpusLocateText;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/slf_tv_search_location_denied")
	private WebElement enterLocationManuallyButton;
	
	
	
	
	
	
	//Action
	/**
	 * Description: Enter the staging Number
	 * @param stagingNumber
	 * @author vivek ranjan
	 * @date 13-March-2024
	 */
	
	public void setStagingNumber(String stagingNumber) {
		searchLocationBox1.sendKeys(stagingNumber);
		searchLocationBox2.sendKeys(stagingNumber);
		searchLocationBox3.sendKeys(stagingNumber);
		
	}
	
	/**
	 * Description: Enter the staging Number for D2C
	 * @param stagingNumber
	 * @author vivek ranjan
	 * @date 13-March-2024
	 */
	
	public void setStagingNumberD2C(String stagingNumber) {
		searchLocationBox1.sendKeys(stagingNumber);
		
	}
	
	/**
	 * Description: click on "OK" button
	 * @param driver
	 * @author vivek ranjan
	 * @date 13-March-2024
	 */
	public void clickOKbutton(AndroidDriver driver){
		
		okButton.click();
	}
	
	/**
	 * Description: Click on "Explore Restaurants Button"
	 * @param driver
	 */
	public void clickExploreRestaurantsButton(AndroidDriver driver) {
		try {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/btnSetYourLocationBB")));
		exploreRestaurantsButton.click();
		log.info("Successfully clicked on Explore Restaurant Button");
		} catch (Exception e ) {
			log.info("Unable to click on Explore Restaurant Button");
		}
	}
	

	/**
	 * Description: Click on "Donot Allow Button"
	 * @param driver
	 *  @author vivek ranjan
	 * @date 13-March-2024
	 */
	public void clickDonotAllowButton(AndroidDriver driver) {
		permissionDenyButton.click();
	}
	
	
	/**
	 * Description:Verify OnBoarding text on landing page
	 * 
	 * @author vivek ranjan
	 * @return
	 * date 13-March-2024
	 */
	public boolean verifyOnboardingText1() {

		if (onboardingText.isDisplayed()) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify the On boarding Text
	 * @return
	 * @author vivek ranjan
	 * @date 13-March-2024
	 */
	public boolean verifyOnboardingText() {

		if (onboardingText.getText().contains("Multiple Trusted Restaurants")) {
			log.info("Onboarding Text " + onboardingText.getText());
			return true;
		} else
			return false;
	}
	
	/**
	 * Description: Verify "Help Us Locate You" Text
	 * @return
	 *  @author vivek ranjan
	 * @date 13-March-2024
	 */
	public boolean verifyHelpUsLocateYouText() {

		if (helpusLocateText.getText().equalsIgnoreCase("Help Us Locate You!")) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Click on "Enter Location Manually" button
	 * @param driver
	 * @author vivek ranjan
	 * @date 13-March-2024
	 * 
	 */
	public void clickEnterLocationManuallyButton(AndroidDriver driver) {
		enterLocationManuallyButton.click();
	}
	
	
	
	
	

}
