package com.eatsure.sampletest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eatsure.pom.android.BaseTest;
import com.eatsure.pom.android.CartPage;
import com.eatsure.pom.android.LandingPage;
import com.eatsure.pom.android.LocalityPage;
import com.eatsure.pom.android.LoyaltyPage;
import com.eatsure.pom.android.MyOrdersPage;
import com.eatsure.pom.android.OrderDetailsPage;
import com.eatsure.pom.android.PaymentPage;
import com.eatsure.pom.android.ProductListingPage;
import com.eatsure.pom.android.SignUpPage;
import com.eatsure.pom.android.TrackingPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class D2C_VR_ESAPP_TrackingPage2 extends BaseTest {
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESAPP_TrackingPage2.class.getName());
//	LocalityPage locality = new LocalityPage(driver);

	@Test(enabled = true, priority = 0, description = "Verify landing page", groups = { "Smoke" })
	public void verifylandingPage() throws Throwable {
//		ExtentTest test = extent.createTest("Verify landing page");
//		ExtentReport.createTest("Verify landing page");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		LandingPage landing = new LandingPage(driver);

//		landing.setStagingNumber("staging26");
		landing.setStagingNumber(prop.getProperty("stagingNumber"));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		landing.clickOKbutton(driver);
		Thread.sleep(2000);
		as = new SoftAssert();
		as.assertEquals(landing.verifyOnboardingText(), true, "On Boarding Text mismatch");
		landing.clickExploreRestaurantsButton(driver);
		Thread.sleep(2000);
		landing.clickDonotAllowButton(driver);
		Thread.sleep(2000);
		as.assertEquals(landing.verifyHelpUsLocateYouText(), true, "Help Us Locate you Text mismatch");
		as.assertAll();
		landing.clickEnterLocationManuallyButton(driver);

	}

	@Test(enabled = true, priority = 1, description = "Verify fireBase notification", groups = { "Smoke" })
	public void verifyFirebaseNotification() throws Throwable {
//		ExtentReport.createTest("Verify fireBase notification");
		LocalityPage locality = new LocalityPage(driver);

		locality.ClickSearchLocationBox(driver);
		locality.storeselect(prop.getProperty("location"));
		locality.clickenableNotificationButton(driver);
		locality.clickallowPermissionButton(driver);
		locality.canceLoyaltyNotificationBar(driver);

	}

	@Test(enabled = false, priority = 2, description = "Verify Error Message with UI Elements Once non serviceable area is entered")
	public void verifyErrorMessageNonServiceableLocation() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		locality.ClicklocationIcon(driver);
		locality.ClickSearchLocationBox(driver);
		locality.storeselect(prop.getProperty("nonServiceableLocation"));
		as = new SoftAssert();
		as.assertEquals(locality.verifynonServiceableLocationTitle(), true, "nonServiceableLocationTitle mismatch");
		locality.ClicktryAnotherLocation(driver);
		as.assertEquals(locality.verifyenterDeliveryLocationTitle(), true, "verifyenterDeliveryLocationTitle mismatch");
		locality.ClickSearchLocationBox(driver);
		locality.storeselect(prop.getProperty("location"));
		locality.canceLoyaltyNotificationBar(driver);
		as.assertAll();
	}

	@Test(enabled = false, priority = 3, description = "Verify Header and Navigation bar Contains of locality page")
	public void verifyHeaderandNavigationbarContain() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		as = new SoftAssert();
		as.assertEquals(locality.verifyLoginButton(), true, "Login button not present");
		as.assertEquals(locality.verifylocationNameHeader(), true, "Location Name header is not present");
		as.assertEquals(locality.verifydeliveryNavigationbarButton(), true,
				"Delivery button under NavigationBar is not present");
		as.assertEquals(locality.verifynowNavigationbarButton(), true, "Now button under NavigationBar is not present");
		as.assertEquals(locality.verifydineInNavigationbarButton(), true,
				"DineIn button under NavigationBar is not present");
		as.assertEquals(locality.verifyfoodOnTrainNavigationbarButton(), true,
				"FoodInTrain button under NavigationBar is not present");
		as.assertAll();

	}

	@Test(enabled = true, priority = 4, description = "Verify Search,Banner,Restaurents,Popular Cuisines and SureSquad on locality page content")
	public void verifyLocalityPageContains() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		as = new SoftAssert();
		as.assertEquals(locality.verifytopSearchSection(), true, "Top Search section is not present");
		// Swipe banner till last available banner
		// locality.swipeBanner(driver, "left");

		Thread.sleep(2000);
		locality.scrollToText("Add");
		locality.addNormalProductcondition(0);
//		locality.addNormalProductcondition(0);
		// Scroll till Restaurant Section
		/*
		 * locality.scrollToText("Foodcourt on an App"); Thread.sleep(2000);
		 * locality.scrollToText("See all"); int listofBrandsLocality =
		 * locality.listofbrandsLocality();
		 * locality.clickseeAllRestaurantsSection(driver); int listofBrandsSeeAll =
		 * locality.listofbrandsLocalityUnderSeeAll();
		 * as.assertEquals(listofBrandsLocality, listofBrandsSeeAll);
		 * locality.clickBackButton(driver);
		 */
		// locality.scrollToText("Login");
		// as.assertAll();
//	    as.assertEquals((locality.firstBanner).getAttribute("focusable")),"true"));
//		as.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/img_banner_item'])[1]")).getAttribute("focusable"),"true");

	}

	@Test(enabled = true, priority = 5, description = "Verify Login flow on Login page via SMS")
	public void verifyLogin() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		locality.clickCartButton(driver);
		// locality.clickloginButton(driver);
		SignUpPage signup = new SignUpPage(driver);
		as = new SoftAssert();
		// as.assertEquals(signup.verifyLoginPageImage(), true, "Login page image not
		// present");
		as.assertEquals(signup.verifySMSRadioButtonisSelected(), true, "SMS Radio button is not Selected");
		as.assertEquals(signup.verifySMSRadioButtonDisplayed(), true, "SMS Radio button is not present");
		as.assertEquals(signup.verifyWhatsAppRadioButtonisNotSelected(), true,
				"What's up Radio button is not selected");
		as.assertEquals(signup.verifyWhatsUpRadioButtonDisplayed(), true, "WhatsUp Radio button is not present");
		as.assertEquals(signup.verifyCountryCode(), true, "Country code IND is not present");
		as.assertEquals(signup.verifyDialingCode(), true, "Dialing Code is not present");
		as.assertEquals(signup.verifysendotpButton(), true, "Send OTP button is disabled");
		as.assertEquals(signup.verifySMSotpSourceText(), true, "Verify otp Source Text is not via SMS");
		signup.clickWhatsUpRadioButton(driver);
		as.assertEquals(signup.verifyWhatsUPotpSourceText(), true, "Verify otp Source Text is not via WhatsUP");
		signup.clickSMSRadioButton(driver);
		signup.enterMobileNumber(prop.getProperty("MobileNo9digit"));
		as.assertEquals(signup.verifysendotpButton(), true, "Send OTP button is disabled");
		signup.enterMobileNumber(prop.getProperty("MobilenumberFixedOTP"));
		signup.clickcancelButton(driver);
		as.assertEquals(signup.verifysendotpButton(), true, "Send OTP button is disabled");
		signup.enterMobileNumber(prop.getProperty("MobilenumberFixedOTP"));
		Thread.sleep(2000);
		signup.clickSendOTPButton(driver);

		// OTP Communication window
		as.assertEquals(signup.verifyotpCommunicationText(), true, "OTP window communication text is not correct");
//		as.assertEquals(signup.verifysmsOTPSentText(), true, "SMS OTP SENT text didnot appear");
		signup.enterOTP(prop.getProperty("wrongOTP"));
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disabled");
		signup.clickVerifyotpButton(driver);
		as.assertEquals(signup.verifyotpcodeerrorText(), true, "OTP code error text is not correct");

		Thread.sleep(8000);
		as.assertEquals(signup.verifyresendOTPviaSMSText(), true, "OTP Window resend OTP via SMS text is not correct");
		as.assertEquals(signup.verifyresendOTPviaSMSbuttonEnabled(), true,
				"OTP Window resend OTP via SMS button is not enabled");
		as.assertEquals(signup.verifyresendOTPviaWhatsappText(), true,
				"OTP Window resend OTP via whatsapp text is not correct");
		as.assertEquals(signup.verifyresendOTPviaWhatsappbuttonEnabled(), true,
				"OTP Window resend OTP via whatsapp button is not enabled");

		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disbaled");

		signup.enterOTP(prop.getProperty("otp"));
		Thread.sleep(2000);
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disabled");
		signup.clickVerifyotpButton(driver);

		log.info("Customer logged successfully to eatsure App");

		Thread.sleep(2000);
		LoyaltyPage loyalty = new LoyaltyPage(driver);
//		as.assertEquals(loyalty.verifyloyaltyJoinPassDialogTitle(), true, "loyalty Join Pass Dialog Title is not present");
//		as.assertEquals(loyalty.verifyloyaltyJoinPassDialogDescription(), true, "loyalty Join Pass Dialog Description is not present");
//		as.assertEquals(loyalty.verifyloyaltyBenefitTag(), true, "loyalty Benefit Tag is not present");
//		as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDelivery(), true, "loyalty Benefit Title FreeDelivery is not present");
//		as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDishes(), true, "loyalty Benefit Title FreeDIshes is not present");
//		as.assertEquals(loyalty.verifyloyaltyJoinSurePass(), true, "loyalty JoinSurePass is not present");
//		as.assertEquals(loyalty.verifyloyaltyJoiningFee(), true, "loyalty Join FEE is not present");

		// loyalty.handleLoyaltyProgramPoppedup();

		locality.clickCartButton(driver);

//		locality.clickseeAllbuttontonavigatePLP(0);

		as.assertAll();
	}

	@Test(enabled = true, priority = 6, description = "Verify Cart page Contain")
	public void verifyCartPageHeaderContain() throws Throwable {

		LoyaltyPage loyalty = new LoyaltyPage(driver);
		CartPage cart = new CartPage(driver);
		cart.selectAddress();
		// as.assertEquals(loyalty.verifyloyaltyJoinPassDialogTitle(), true, "loyalty
		// Join Pass Dialog Title is not present");
		// as.assertEquals(loyalty.verifyloyaltyJoinPassDialogDescription(), true,
		// "loyalty Join Pass Dialog Description is not present");
		// as.assertAll();
		// log.info("Successfully Loyalty pop is coming for non loyalty user");

		// loyalty.handleLoyaltyProgramPoppedup();

		as.assertEquals(cart.cartHeaderContain(), true, "Cart page header contain don't show 4 element ");
		as.assertAll();
		log.info("Successfully verify the cart page headercontain");

		as.assertEquals(cart.navigation(), "Now", "Selected slot don't shwoing correctly");
		as.assertAll();
		log.info("Successfully verify the navigation bar and slot");
	}

	@Test(enabled = true, priority = 7, description = "Verify Cart page Contain")
	public void verifyCartProducts() throws Throwable {
		CartPage cart = new CartPage(driver);

		log.info("Total brand count in the cart " + cart.brandName());

		cart.paybutton();
	}

	@Test(enabled = true, priority = 8, description = "Verify payment page Contain")
	public void payment() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		PaymentPage payment = new PaymentPage(driver);
		as.assertEquals(payment.verifyPyamentTitle(driver), true, "Payement page not loading");
		as.assertAll();

		locality.scrollToText("Pay On Delivery");
		Thread.sleep(3000);
		payment.clickCodRadioButton();
		Thread.sleep(3000);
		as.assertEquals(payment.payButtonVerify(), true, "Payment button not enable");
		as.assertAll();
		payment.ClickonPayButton(driver);
		as.assertEquals(payment.orderPlace(driver), true, "order place not working");
		as.assertAll();
		log.info("Successfully one oder placed");

	}

	@Test(enabled = true, priority = 9, description = "Verify Tracking page Contain")
	public void tracking() throws Throwable {
		TrackingPage tracking = new TrackingPage(driver);
		as.assertEquals(tracking.verifyMaxSavingsDisplayInOrderPlacePopup(driver), true,
				"Max Savings Text in Order Place Popup Not displayed");
		as.assertAll();
		as.assertEquals(tracking.verifySurePointsDisplayInOrderPlacePopup(driver), true,
				"Sure Points Text in Order Place Popup Not displayed");
		as.assertAll();
		log.info("Successfully verified Order Place Close Popup Display");
		tracking.OrderPlaceClosePopupClick();
		Thread.sleep(3000);
		//Validate LIVE ORDER
		as.assertEquals(tracking.verifyLiveOrderTrackingTextDisplay(driver), true,
				"Live Order Tracking Text Not displayed in Tracking Page");
		as.assertAll();
		as.assertEquals(tracking.verifyTotalItemsWithPriceTextDisplay(driver), true,
				"Total Items With Price Text Not displayed in Tracking Page");
		as.assertAll();
		//Retrieve the Item count and item Price
		int trackingcount = tracking.retrieveItemsCount();
		int trackingprice = tracking.retrievePrice();
		log.info("Item Count on tracking page "+ trackingcount);
		log.info("Item Price on Tracking Page "+ trackingprice);
		
		as.assertEquals(tracking.verifyHelpButtonTextDisplay(driver), true,
				"Help Button Text Not displayed in Tracking Page");
		as.assertAll();
		as.assertEquals(tracking.verifyViewMyOrderDetailsLinkDisplay(driver), true,
				"View MyOrder Details Link Not displayed in Tracking Page");
		as.assertAll();
		as.assertEquals(tracking.verifyOrderStatusSectionDisplay(driver), true,
				"Order Status Section Display Not displayed in Tracking Page");
		as.assertAll();
		//Click on "View my Order Deatils"
		tracking.clickMyOrderDetailsLink();

		log.info("Successfully Verified Tracking Page");

	}

	@Test(enabled = true, priority = 10, description = "Verify Order Details/Summary page Contain")
	public void orderDetails() throws Throwable {
		OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
		TrackingPage tracking = new TrackingPage(driver);
		Thread.sleep(5000);
		as.assertEquals(orderDetailsPage.verifyHelpButton(driver), true,
				"Help Button in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyOrderCrn(driver), true, "Order Crn in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyOrderPlacedTime(driver), true,
				"Order Placed Time in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyTotalItemCount(driver), true,
				"Total Item Count in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyOrderReceivedText(driver), true,
				"Order Received Text in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyOrderCookText(driver), true,
				"Order Cook Text in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyOrderOutForDeliveryText(), true,
				"OrderOutForDeliveryText in Order Details Page Not displayed");
		
		as.assertAll();
		log.info("Pankaj");
		
//		as.assertEquals(orderDetailsPage.verifyProductName(), true,
//				"ProductName in Order Details Page Not displayed");
//		as.assertAll();
//		as.assertEquals(orderDetailsPage.verifyProductPrice(driver), true,
//				"ProductPrice in Order Details Page Not displayed");
//		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyDeliveryAddressText(driver), true,
				"DeliveryAddressText in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyAddressLabel(driver), true,
				"AddressLabel in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyAddressDetail(driver), true,
				"AddressDetail in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyViewTaxesAndOtherChargesLink(driver), true,
				"ViewTaxesAndOtherChargesLink in Order Details Page Not displayed");
		as.assertAll();
		
		//Click on "ViewTaxesAndOtherChargesLink"
		orderDetailsPage.clickViewTaxesAndOtherChargesLink(driver);
		as.assertEquals(orderDetailsPage.verifyGrandTotalText(driver), true,
				"GrandTotalText in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyGrandTotalAmount(driver), true,
				"GrandTotalAmount in Order Details Page Not displayed");
		as.assertAll();
		
		int grandTotalAmount = orderDetailsPage.retrieveGrandTotalAmount();
		log.info("Grand Total Amount in order summary page " +grandTotalAmount);
		
		as.assertEquals(orderDetailsPage.verifyPaidByText(driver), true,
				"PaidByText in Order Details Page Not displayed");
		as.assertAll();
		as.assertEquals(orderDetailsPage.verifyPaidByTotalAmount(driver), true,
				"PaidByTotalAmount in Order Details Page Not displayed");
		as.assertAll();
		
		log.info("Successfully Verified Order Details Page");
		//Click on Back button
		orderDetailsPage.clickBackButton(driver);
		log.info("Successfully Verified Back button from Order Details Page");
		Thread.sleep(2000);
		//Click on Cross button
		tracking.clickBackButton(driver);
		log.info("Successfully Verified Rdirection from order details to Tracking Page");
		
	}

	@Test(enabled = true, priority = 11, description = "Verify Order Details page Contain")
	public void myOrdersPage() throws Throwable {
		MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
		myOrdersPage.clickMyProfile();
        Thread.sleep(2000);
        myOrdersPage.clickMyOrder();
        Thread.sleep(5000);
		TrackingPage tracking = new TrackingPage(driver);
		OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
//		int grandTotalAmount = orderDetailsPage.retrieveGrandTotalAmount();
//		log.info("Grand Total Amount "+ grandTotalAmount);
		Thread.sleep(3000);
		as.assertEquals(myOrdersPage.verifyMyOrdersText(driver), true, "My Orders Text in My Order Page Not displayed");
		as.assertAll();
		as.assertEquals(myOrdersPage.verifyOrderState(driver), true, "Orders State in My Order Page Not displayed");
		as.assertAll();
//		as.assertEquals(myOrdersPage.verifyProductName(driver), true, "Product Name in My Order Page Not displayed");
//		as.assertAll();
//		as.assertEquals(myOrdersPage.verifyProductPrice(driver), true, "Product Price in My Order Page Not displayed");
//		as.assertAll();
//		int myOrdersAmount = myOrdersPage.retrieveAmount();
//		log.info(myOrdersAmount);
//		as.assertEquals(myOrdersAmount, grandTotalAmount, "Amount is Not Matching in OrderDetails and My Orders Page");
		as.assertEquals(myOrdersPage.verifyBtnTrackOrder(driver), true,
				"Track Order Button in My Order Page Not displayed");
		as.assertAll();
		myOrdersPage.clickTrackMyOrderButton(driver);
		log.info("Successfully Verified My Orders Page");
		Thread.sleep(3000);
		as.assertEquals(tracking.verifyLiveOrderTrackingTextDisplay(driver), true,
				"Live Order Tracking Text Not displayed in Tracking Page");
		as.assertAll();
	}

//	@AfterSuite
//	public void afterSuite() {
//
//		ExtentReport.extent.flush();
//	}

}
