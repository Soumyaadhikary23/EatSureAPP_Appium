package com.eatsure.pom.android;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;
import com.eatsure.utils.RandomDataGenerator;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(SignUpPage.class.getName());
	public static  WebDriverWait wait; 
	public SignUpPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_phone_number")
	private WebElement phoneNumberTextBox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/button_send_otp")
	private WebElement sendOTPButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_otp_sent_to_communication_channel")
	private WebElement otpSendCommunication;

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_otp")
	private WebElement otpTextBox;

//	@AndroidFindBy(id = "com.done.faasos.debug:id/button_send_otp")
//	private WebElement sendotpButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/button_verify")
	private WebElement verifyotpButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement loginPageImage;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_sms")
	private WebElement smsRadioButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_whatsapp")
	private WebElement whatsappRadioButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_country_code")
	private WebElement countryCodeDropdown;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_dialling_code")
	private WebElement dialingCode;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ibCancelText")
	private WebElement cancelButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_otp_code_text")
	private WebElement otpSourceText;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_otp_sent_to_communication_channel")
	private WebElement otpCommunicationText;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_otp_sent")
	private WebElement smsOTPSentButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_resend_sms_otp")
	private WebElement resendOTPviaSMS;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_resend_whatsapp_otp")
	private WebElement resendOTPviaWhatsapp;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_otp_code_error_text")
	private WebElement otpcodeerrortext;
	
	
	
	//Signup page locator for new user
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/etEmail")
	private WebElement emaiIDforNewUser;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/etName")
	private WebElement nameforNewUser;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_signup_text")
	private WebElement signupText;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/button_submit")
	private WebElement signMeUpButton;
	

	/**
	 * Description: Enter mobileNumber
	 * 
	 * @author vivek ranjan
	 * @param MobileNumber
	 * @date 20-March-2024
	 */

	public void enterMobileNumber(String MobileNumber) {
		phoneNumberTextBox.sendKeys(MobileNumber);
	}

	/**
	 * Description: Click on "SEND OTP" button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 20-March-2024
	 * 
	 */
	public void clickSendOTPButton(AndroidDriver driver) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.id("com.done.faasos.debug:id/button_send_otp")));
		sendOTPButton.click();
	}

	/**
	 * Description: Click on "cancelButton" button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 27-March-2024
	 * 
	 */
	public void clickcancelButton(AndroidDriver driver) {
		cancelButton.click();
	}
	
	/**
	 * Description: Click on "whatsUPRadioButton" button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 27-March-2024
	 * 
	 */
	public void clickWhatsUpRadioButton(AndroidDriver driver) {
		whatsappRadioButton.click();
	}

	/**
	 * Description: Click on "SMSRadioButton" button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 27-March-2024
	 * 
	 */
	public void clickSMSRadioButton(AndroidDriver driver) {
		smsRadioButton.click();
	}
	
	/**
	 * Description: Enter OTP
	 * 
	 * @param OTP
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public void enterOTP(String OTP) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.id("com.done.faasos.debug:id/tv_otp_sent_to_communication_channel")));

		otpTextBox.sendKeys(OTP);
//		verifyotpButton.click();

	}
	/**
	 * Description: Click on "VERIFY & PROCEED" button in OTP page
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 27-March-2024
	 * 
	 */
	public void clickVerifyotpButton(AndroidDriver driver) {
		verifyotpButton.click();
	}
	/**
	 * Description: Verify login Page Image
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifyLoginPageImage() {

		if (loginPageImage.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify SMS radio button
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifySMSRadioButtonisSelected() {
		if (Boolean.valueOf(smsRadioButton.getAttribute("checked")) == true) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify SMS radio button displayed
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifySMSRadioButtonDisplayed() {

		if (smsRadioButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify WhatsApp radio button not selected
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyWhatsAppRadioButtonisNotSelected() {
		if (Boolean.valueOf(whatsappRadioButton.getAttribute("checked")) == false) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify What's up radio button displayed
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifyWhatsUpRadioButtonDisplayed() {

		if (whatsappRadioButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Country code dropdown
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifyCountryCode() {

		if (countryCodeDropdown.getText().equalsIgnoreCase("IND")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Dialing code
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifyDialingCode() {

		if (dialingCode.getText().equalsIgnoreCase("+91")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify Dialing code
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 21-March-2024
	 */
	public boolean verifysendotpButton() {

		if (sendOTPButton.isEnabled()) {
			return false;

		} else
			return true;
	}

	/**
	 * Description: Verify SMS OTP Source Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifySMSotpSourceText() {
		if (otpSourceText.getText().equalsIgnoreCase("You’ll receive a 4-digit OTP through SMS.")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify WhatsUP OTP Source Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyWhatsUPotpSourceText() {
		if (otpSourceText.getText().equalsIgnoreCase("You’ll receive a 4-digit OTP through Whatsapp.")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify WhatsUP OTP Source Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyotpCommunicationText() {
		if (otpCommunicationText.getText().equalsIgnoreCase("We have sent a SMS verification code to")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify resend OTP via SMS Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyresendOTPviaSMSText() {
		if (resendOTPviaSMS.getText().equalsIgnoreCase("Resend OTP via SMS")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify resendOTPviaSMS button enabled
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyresendOTPviaSMSbuttonEnabled() {
		if (Boolean.valueOf(resendOTPviaSMS.getAttribute("enabled")) == true) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify resend OTP via whatsapp Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyresendOTPviaWhatsappText() {
		if (resendOTPviaWhatsapp.getText().equalsIgnoreCase("Resend OTP via Whatsapp")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify resendOTPviaWhatsapp button enabled
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyresendOTPviaWhatsappbuttonEnabled() {
		if (Boolean.valueOf(resendOTPviaWhatsapp.getAttribute("enabled")) == true) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify resendOTPviaWhatsapp button disabled
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyotpButtonDisabled() {
		if (Boolean.valueOf(verifyotpButton.getAttribute("enabled")) == false) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify resendOTPviaWhatsapp button enabled
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyotpButtonEnabled() {
		if (Boolean.valueOf(verifyotpButton.getAttribute("enabled")) == true) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Verify otp code error Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifyotpcodeerrorText() {
		if (otpcodeerrortext.getText().equalsIgnoreCase("Uh-oh! The OTP you've entered is invalid. Kindly re-enter the correct OTP.")) {
			return true;

		} else
			return false;
			
		
	}
	
	/**
	 * Description: Verify SMS otp sent Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 27-March-2024
	 */
	public boolean verifysmsOTPSentText() {
		if (smsOTPSentButton.getText().equalsIgnoreCase("SMS OTP Sent")) {
			return true;

		} else
			return false;
			
		
	}
	
	//SIGN up SCREEN Methods:-
	

	/**
	 * Description: Enter new mobileNumber
	 * 
	 * @author vivek ranjan
	 * @param MobileNewNumber
	 * @date 05-April-2024
	 */

	public void enterNewMobileNumber() {
		String MobileNewNumber=RandomDataGenerator.generatePhoneNumber();
		log.info("New Mobile no generated :-"+MobileNewNumber);	
		phoneNumberTextBox.sendKeys(MobileNewNumber);
	}
	
	/**
	 * Description: Enter new EMail ID
	 * 
	 * @author vivek ranjan
	 * @param EmailID
	 * @date 05-April-2024
	 */

	public void enterNewEmailId() {
		String newEMAILID=RandomDataGenerator.generateEmailId();
		log.info("New Email ID generated :-"+newEMAILID);	
		emaiIDforNewUser.sendKeys(newEMAILID);
	}
	
	/**
	 * Description: Enter new User Name
	 * 
	 * @author vivek ranjan
	 * @param userName
	 * @date 05-April-2024
	 */

	public void enterNewUserName() {
		String newUserName=RandomDataGenerator.generateName();
		log.info("New Email ID generated :-"+newUserName);	
		nameforNewUser.sendKeys(newUserName);
	}
	
	/**
	 * Description: Verify sign up Page content
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 05-Apr-2024
	 */
	public boolean verifySignupPageContent() {

		if (signupText.getText().equalsIgnoreCase("Sign Up")) {
			return true;

		} else
			return false;
	}
	/**
	 * 
	 */
	
	public void clickOnSignMeUpButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.id("com.done.faasos.debug:id/button_submit")));

		if (signMeUpButton.isDisplayed()) {
			 signMeUpButton.click();
		}
	

	}
	
}
