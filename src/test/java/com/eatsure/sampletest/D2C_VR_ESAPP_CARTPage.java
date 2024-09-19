package com.eatsure.sampletest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
import com.eatsure.pom.android.PaymentPage;
import com.eatsure.pom.android.ProductListingPage;
import com.eatsure.pom.android.SignUpPage;
import com.google.common.collect.ImmutableMap;

//import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class D2C_VR_ESAPP_CARTPage extends BaseTest {
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESAPP_CARTPage.class.getName());
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
		as.assertAll();
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

	}

	@Test(enabled = true, priority = 6, description = "Verify Cart page Contain")
	public void verifyCartPageHeaderContain() throws Throwable {

		LoyaltyPage loyalty = new LoyaltyPage(driver);
		CartPage cart = new CartPage(driver);
		Thread.sleep(2000);
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
		log.info("Total product in the cart " + cart.productCount());
		as.assertEquals(cart.increaseQuantity(), 2, "Quantity increase not woriking");
		as.assertAll();
		log.info("Successfuly increase the quantity before quantity ");
		cart.editProduct();
	}

	@Test(enabled = false, priority = 8, description = "Verify add instruction")
	public void instruction() throws Throwable {
		CartPage cart = new CartPage(driver);
		as.assertEquals(cart.instruction(), "Write cooking instructions (Optional)",
				"text not matching for instruction box");
		as.assertAll();
		as.assertEquals(cart.instructionInputBox(), "Write cooking instructions", "header title not matching");
		as.assertAll();

		as.assertEquals(cart.afterAddInst(), "Test order this is", "Instructio not added");
		as.assertAll();
		log.info("Successfully added the cooking Instruction");
	}

	@Test(enabled = false, priority = 9, description = "Verify the address")
	public void address() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.address();
		cart.conformLocation();
		cart.clickConformLOcation();
		// as.assertEquals(cart.conformLocation(),
		// cart.addaddresspagelocalityName(),"loaclity name not matching");
		// as.assertAll();
		cart.addressAdded();
		as.assertEquals(cart.verifyAddress(), "Eatsure", "address save not working");
		as.assertAll();
		log.info("verify Successfully add address working");

	}

	@Test(enabled = true, priority = 10, description = "Verify the coupon")
	public void coupon() throws Throwable {
		CartPage cart = new CartPage(driver);
		LocalityPage locality = new LocalityPage(driver);
		cart.scrollToText("Explore Coupons");
		as.assertEquals(cart.couponboxHeader(), "Coupons for you", "coupon header  show wrong");
		as.assertAll();
		as.assertEquals(cart.couponboxtitle(), "Explore Coupons", "coupon title show wrong");
		as.assertAll();
		cart.view();
		 as.assertEquals(cart.couponHeader(), "Coupons for you", "coupon header text not matching");
		 as.assertAll();
		 cart.haveCodeBUttonClick();
		 as.assertEquals(cart.couponInputBoxText(), "Type your coupon code here","coupon box text not matching");
		 as.assertAll();
		as.assertEquals(cart.afterInput(), true,"apply button is enable after put coupon name "); 
		as.assertAll();
		 as.assertEquals(cart.couponError(), true, "Error message is not showing");
		 as.assertAll();
		 cart.close();
		String couponListCouponname = cart.applyCouponName();
		int offerPrice = cart.applydiscount();
		cart.applycoupon();
		Thread.sleep(2000);
		locality.scrollToText("Coupons for you");
		Thread.sleep(2000);
		// String nameCoupon=cart.popupCoupon();
		as.assertEquals(cart.couponboxtitle(), couponListCouponname, "coupon name not showing save after applying");
		as.assertAll();
		as.assertEquals(cart.cartcouponprice(), offerPrice, "apply discount show wrong");
		as.assertAll();
		log.info("Successfully verify coupon section");
		as.assertEquals(cart.couponTag(), true, "coupon tag not showing");
		as.assertAll();
		log.info("Successfully verfi coupon tag after applied coupon");
	}

	@Test(enabled = true, priority = 11, description = "Verify free dish ")
	public void FreeDish() throws Throwable {
		CartPage cart = new CartPage(driver);
		LocalityPage locality = new LocalityPage(driver);
		Thread.sleep(2000);
//		cart.scroll();
		if (cart.sureSquard() == "this is a loyalty user") {
			as.assertEquals(cart.freedishHeader(), "SureSquad", "header not matching for suresquard");
			as.assertAll();
			as.assertEquals(cart.designFreeDishBox(), true, "free dish box design not right");
			as.assertAll();
			cart.scrollToText("Add FREE Dish");
			Thread.sleep(1000);
			if (cart.clickadd().equalsIgnoreCase("Both the benefits are applicable")) {
				Thread.sleep(3000);
				as.assertEquals(cart.removeButton(), true, "after added remove button not showing");
				as.assertAll();
				cart.changClick();
				as.assertEquals(cart.freeDishPageTitle(), "FREE Dish Unlocked!", "Free dish title not matching");
				as.assertEquals(cart.freeDescription(), true, "Fress dish page Description is not shwoing");
				as.assertAll();
				Thread.sleep(2000);
				
				String SelectFreeProduct = cart.selectFreeProduct();
				log.info(SelectFreeProduct);
				cart.continueButton();
				log.info(cart.afterCangeProductName());
				as.assertEquals(cart.afterCangeProductName(), SelectFreeProduct, "Free product not change successfully");
				as.assertAll();
				log.info("Successfully change the free product");
				

			}
			log.info("Successfully verify the free dish section");
		}

	}

	@Test(enabled = true, priority = 12, description = "Verify the bill details")
	public void billDetails() throws Throwable {
		CartPage cart = new CartPage(driver);
		LocalityPage locality = new LocalityPage(driver);
		// cart.scrollUpInFrameB();
		// Thread.sleep(2000);
		// int totalProductPrice=cart.productSum();
		// log.info(totalProductPrice);
		Thread.sleep(3000);
		cart.scrollToText("Order Total (Incl.Taxes)");
//		cart.scrollVertical();
		Thread.sleep(2000);
		as.assertEquals(cart.biilHeader(), "Bill Summary", "bill details header not matching");
		as.assertAll();
		as.assertEquals(cart.billfields(), true, "in bill details 3 fields are not coming");
		as.assertAll();
		Thread.sleep(2000);
		int basketAmount = cart.basketTotal();
		// as.assertEquals(totalProductPrice, basketAmount, "basket total and product
		// total price are not matching");
		// as.assertAll();

		log.info(cart.calGrandTotal());

		as.assertEquals(cart.calGrandTotal(), cart.cartTotal(), "Total price not matching in the cart");
		as.assertAll();
		log.info("Successfully verify the cart bill details");

	}
	
	@Test(enabled = true, priority = 13, description = "Verify saving  details")
	public void savingsBar() throws Throwable {
		CartPage cart = new CartPage(driver);
		//as.assertEquals(cart.savingText(), "Your Savings on this order   ","saving text not display");
		//as.assertAll();
		as.assertEquals(cart.saving(), cart.savingInfoBar(), "saving show different top and buttom bar");
		as.assertAll();
		log.info("Successfully verify saving amount show same both the places");
		as.assertEquals(cart.buttosavingopen(), "Savings only on EatSure","saving header matching for buttom");
		as.assertAll();
		cart.close();
		as.assertEquals(cart.topSavingOpen(), "Savings only on EatSure","saving header matching for buttom");
		as.assertAll();
		as.assertEquals(cart.totalSavingCal(), cart.totalSavingINpopUp(),"Total saving for matching in the pop up");
		as.assertAll();
		cart.close();
		log.info("Successfully verify the saving bar");
	}
	
	@Test(enabled = true, priority = 14, description = "Verify payment page Contain")
	public void payment() throws Throwable {
		CartPage cart = new CartPage(driver);
		LocalityPage locality = new LocalityPage(driver);
		PaymentPage payment= new PaymentPage(driver);
		int cartTotal=cart.calGrandTotal();
		cart.paybutton();
		as.assertEquals(payment.verifyPyamentTitle(driver), true, "Payement page not loading");
		as.assertAll();
		//log.info(payment.totalPriceTop());
		
		locality.scrollToText("Pay On Delivery");
		Thread.sleep(3000);
		payment.clickCodRadioButton();
		Thread.sleep(3000);
		as.assertEquals(payment.payButtonVerify(), true,"Payment button not enable");
		as.assertAll();
		log.info(payment.payPrice());
//		as.assertEquals(cartTotal, payment.payPrice(), "cart and payment price are not matching");
//		as.assertAll();
		payment.ClickonPayButton(driver);
		as.assertEquals(payment.orderPlace(driver), true,"order place not working");
		as.assertAll();
		log.info("Successfully one oder placed");
		
	}
	
	

//	@AfterSuite
//	public void afterSuite() {
//
//		ExtentReport.extent.flush();
//	}

}
