package com.d2c.sampletest;

import java.time.Duration;

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
import com.eatsure.pom.android.RestaurantPage;
import com.eatsure.pom.android.SignUpPage;
import com.eatsure.pom.android.TrackingPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class D2C_VR_D2C_EndtoEnd_SANITY extends BaseTest {
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_D2C_EndtoEnd_SANITY.class.getName());
//	LocalityPage locality = new LocalityPage(driver);
	
	@Test(enabled = true, priority = 0, description = "Verify landing page",groups= {"Smoke"})
	public void verifylandingPage() throws Throwable {
//		ExtentTest test = extent.createTest("Verify landing page");
//		ExtentReport.createTest("Verify landing page");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		LandingPage landing = new LandingPage(driver);

//		landing.setStagingNumber("staging26");
		landing.setStagingNumberD2C(prop.getProperty("stagingNumber"));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		landing.clickOKbutton(driver);
		Thread.sleep(2000);
		as = new SoftAssert();
		//Commenting for D2C
//		as.assertEquals(landing.verifyOnboardingText(), true, "On Boarding Text mismatch");
		landing.clickExploreRestaurantsButton(driver);
		Thread.sleep(2000);
		landing.clickDonotAllowButton(driver);
		Thread.sleep(2000);
		as.assertEquals(landing.verifyHelpUsLocateYouText(), true, "Help Us Locate you Text mismatch");
		as.assertAll();
		landing.clickEnterLocationManuallyButton(driver);
		
	}

	@Test(enabled = true, priority = 1, description = "Verify fireBase notification",groups= {"Smoke"})
	public void verifyFirebaseNotification() throws Throwable {
//		ExtentReport.createTest("Verify fireBase notification");
		LocalityPage locality = new LocalityPage(driver);

		locality.ClickSearchLocationBox(driver);
		locality.storeselect(prop.getProperty("location"));
		locality.clickNoNotificationButton(driver);
//		locality.clickenableNotificationButton(driver);
//		locality.clickallowPermissionButton(driver);
		
		locality.canceLoyaltyNotificationBar(driver);
		
//		locality.clickseeAllbuttontonavigatePLP(0);
//		System.out.println("Vivek Ranjan");
		

	}
//	
//	@Test(enabled = true, priority = 1, description = "Reset the APP")
//	public void verifyResetAPP() throws Throwable {
////		ExtentReport.createTest("Verify fireBase notification");
//		
//		LocalityPage locality = new LocalityPage(driver);
//
//		locality.ClickSearchLocationBox(driver);
//		locality.storeselect(prop.getProperty("location"));
//		locality.clickNoNotificationButton(driver);
////		locality.clickenableNotificationButton(driver);
////		locality.clickallowPermissionButton(driver);
//		
//		locality.canceLoyaltyNotificationBar(driver);
//		
////		locality.clickseeAllbuttontonavigatePLP(0);
////		System.out.println("Vivek Ranjan");
//		
//
//	}

	@Test(enabled = true, priority = 2, description = "Verify Error Message with UI Elements Once non serviceable area is entered")
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

	@Test(enabled = true, priority = 3, description = "Verify Header and Navigation bar Contains of locality page")
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
//		as.assertEquals(locality.verifyfoodOnTrainNavigationbarButton(), true,
//				"FoodInTrain button under NavigationBar is not present");
		as.assertAll();

	}

	@Test(enabled = true, priority = 4, description = "Verify Banner clickable and scroll")
	public void verifyLocalityPageContains() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		as = new SoftAssert();
		as.assertEquals(locality.verifytopSearchSection(), true, "Top Search section is not present");
		as.assertAll();
		
		//Click on First Banner
		locality.ClickonFirstBanner(0);
//		Thread.sleep(1000);
//		as.assertEquals(locality.verifyRestaurantStrip(),true, "Restaurant Strip is not present");
//		as.assertAll();
		locality.clickBackButtonStrip(driver);
		Thread.sleep(1000);
        //Swipe banner till last available banner
		locality.swipeBanner(driver, "left");
		locality.scrollToText("Login");
		
	}
	
	
	@Test(enabled = false, priority = 5, description = "Verify Restaurants Page,Product Listing Page")
	public void verifyRestaurantsPage() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		//Scroll till Restaurant Section
		
		locality.scrollToText("Foodcourt on an App");
		Thread.sleep(1000);
//		locality.scrollToText("Popular Cuisines");
//		
//		locality.scrolltillRestaurantSection();
//		Thread.sleep(2000);
//		locality.scrollToText("See all");
		int listofBrandsLocality = locality.listofbrandsLocality();	
		locality.clickseeAllRestaurantsSection(driver);
		int listofBrandsSeeAll = locality.listofbrandsLocalityUnderSeeAll();
		//Verify list of Restaurants present on localityPage is same as after clicking "See all" button
		as.assertEquals(listofBrandsLocality, listofBrandsSeeAll);
		
		locality.clickBackButton(driver);
		
		//Click on first Restaurant
		locality.ClickonFirstRestaurant(0);
		
		RestaurantPage restPage = new RestaurantPage(driver);
		
		restPage.clickonfirstRestaurant();
		Thread.sleep(1000);
		//Add product from restaurant page
		restPage.addNormalProductcondition(0);
		restPage.ClickVegFilterButton();
		restPage.ClicknonVegFilterButton();
		
		
		//Click on first Restaurant 25-Apr-2024 as of now commenting
//		restPage.clickonfirstRestaurant();
		
		//Click on Sort/Filter button
		restPage.clicksortFilterButton();
		//Click on sortFilter Cost LowtoHigh
		restPage.clicksortFilterCostLowtoHigh();
	    //Click on Apply Button Sort Filter  
		restPage.clickApplyButtonSortFilter();
		//Add product from restaurant page
//		restPage.addNormalProductcondition(0);
		
		//Click on Menu Button
		restPage.clickMenuButton();
		
		//Click on each collection from Menu and validate the Shorting of product price
		restPage.clickoneachCollectionfromMenuandValidatetheShortingofProductPriceFromLowToHigh();
		
		Thread.sleep(1000);
		
		restPage.clickCloseButton();
		
		Thread.sleep(2000);
		//Click on Sort/Filter button
		restPage.clicksortFilterButtonOncescrollDown();
		//Click on sortFilter Cost HightoLOW
		restPage.clicksortFilterCostHightoLow();
	    //Click on Apply Button Sort Filter  
		restPage.clickApplyButtonSortFilter();
		
		//Click on Menu Button
		restPage.clickMenuButton();
				
	    //Click on each collection from Menu and validate the Shorting of product price
	   restPage.clickoneachCollectionfromMenuandValidatetheShortingofProductPriceFromHighToLow();
				
	   Thread.sleep(1000);
				
	   restPage.clickCloseButton();

		//Click on Back arrow button to navigate to Home Page
		restPage.ClickBackArrowButton();
		
		//Navigate to HOME page
		locality.scrollToText("Login");
		
//		locality.scrollToText(prop.getProperty("location"));
		
		as.assertAll();
		
		}
	@Test(enabled = false, priority = 6, description = "Verify Restaurants Page,Product Details Page")
	public void verifyProductDetailsPage() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		//Scroll till Restaurant Section
		
		locality.scrollToText("Foodcourt on an App");
		Thread.sleep(1000);
		as = new SoftAssert();
		
		//Click on first Restaurant
		locality.ClickonFirstRestaurant(0);
		
		RestaurantPage restPage = new RestaurantPage(driver);
		
		String productNameOnRestaurantPage =  restPage.getproductNameOnRestaurantPage();
		
		int productPriceOnRestaurantPage =  restPage.getproductPriceOnRestaurantPage();
		
		restPage.clickonfirstRestaurant();
//		Thread.sleep(2000);
		restPage.firstProductNameOnResturantPage.click();
		Thread.sleep(2000);
		
		String productNameOnPDPPage = restPage.getproductNameOnPDPPage();
		int productPriceOnProductDetailPage =  restPage.getproductPriceOnProductDetailPage();
		
		as.assertEquals(productNameOnRestaurantPage, productNameOnPDPPage);
		as.assertAll();
		as.assertEquals(productPriceOnRestaurantPage, productPriceOnProductDetailPage);
		as.assertAll();
		
		//Add Product from PDP Page
		restPage.addNormalProductfromPDPPage();
		
		//Click on Back arrow button to navigate to Restaurant Page
		restPage.ClickBackArrowButtonPDP();
		
		//Click on Back arrow button to navigate to Home Page
		restPage.ClickBackArrowButton();
				
		//Navigate to HOME page
		locality.scrollToText("Login");

	}
	@Test(enabled = true, priority = 7, description = "Verify Search functionality on locality page")
	public void verifySearchFunctionality() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		//List of Brands under Locality Page
		int listofBrandsLocality = locality.listofbrandsLocality();	
		//Click on Search box section
		locality.clickonSearchBox();
		Thread.sleep(2000);
		//List of Brands under Search section Page
		int listofBrandsSearch = locality.listofBrandsUnderSearch();
		//Verify list of Restaurants present on localityPage is same as Search field
		as.assertEquals(listofBrandsLocality, listofBrandsSearch);
		as.assertAll();
		//Enter wrongProductName under search section
		locality.enterTextunderSearchBox(prop.getProperty("wrongProductName"));
		Thread.sleep(2000);
		as.assertEquals(locality.verifysearchSectionNoResultFoundText(), true, "search Section No Result Found Text");
		as.assertAll();
		as.assertEquals(locality.verifysearchSectionRestaurantTitle(), true, "search Section Restaurant Title not Found");
		as.assertAll();
		
		locality.clickOnsearchSectionCrossButton();
        locality.enterTextunderSearchBox(prop.getProperty("correctProductName"));
        Thread.sleep(8000);
        locality.addNormalProductcondition(0);
		Thread.sleep(3000);
		locality.clickBackButtonSearchSection();
		Thread.sleep(1000);
		//Navigate to HOME page
		locality.scrollToText("Login");

	}
	
	@Test(enabled = true, priority = 8, description = "Verify Grid Card,Add product from Locality page and Product Listing page Flow")
	public void verifyGridCardandProductListingPageflow() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		
		//Add Normal product from Locality Page
		Thread.sleep(1000);
		locality.scrollToText("Add");
		locality.addNormalProductcondition(0);
		Thread.sleep(1500);
		//Click on seeAll button
		locality.clickseeAllbuttontonavigatePLP(0);
//		System.out.println("Vivek Ranjan");
//		ProductListingPage productListing = new ProductListingPage(locality.clickseeAllbuttontonavigatePLP(0));
		ProductListingPage plp = new ProductListingPage(driver);
		as = new SoftAssert();
//		as.assertEquals(productListing.verifynewFeatureInfo(), true, "Order from multiple restaurants and get them in a single delivery message is not present");
//		productListing.ClicknewArrowButton();
		//Click via co-ordinate
//		plp.clickElementByCoordinates(ProductListingPage.vegIcon, 309, 1231);
		
		//Commenting the below two lines now as we have resolved the slowness issue.
		plp.clickonfirstMission();
		plp.clickonsecondMission();
	
        //Scroll till first "+ Add" button
//		locality.scrollToText("+ Add");
//		plp.scrollToText("License No. ");
//		//Add first product
		plp.addNormalProductconditionFromPLPpage(0);
        
        //Click on Veg Button
        plp.ClickVegFilterButton();
        //Validate the Veg icon
        as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.vegIcon, "veg:- "), true,
				"Veg Icon mismatch");
        
        //click on nonveg Button
        plp.ClicknonVegFilterButton();
        //Validate  the nonveg icon
        as.assertEquals(plp.verifyPresenceofVegorNonVegIcon(driver, ProductListingPage.nonVegIcon, "nonveg:- "), true,
				"nonVeg Icon mismatch");
        
        //Click on All button
        plp.ClickAllFilterButton();
        
        //Click on Sort/Filter button
        plp.clicksortFilterButton();
        
        
        //Verify content of Sort/Filter section:-
        as.assertEquals(plp.verifysortFilterTitle(), true, "verifysortFilterTitle is not present");
        
        as.assertEquals(plp.verifysortFilterSortBy(), true, "verifysortFilterSortBy is not present");
        
        as.assertEquals(plp.verifysortFilterCostLowtoHigh(), true, "verifysortFilterCostLowtoHigh is not present");
        
        as.assertEquals(plp.verifysortFilterCostHightoLow(), true, "verifysortFilterCostHightoLow is not present");
        
        as.assertEquals(plp.verifysortFilterSpiceLowtoHigh(), true, "verifysortFilterSpiceLowtoHigh is not present");
        
        as.assertEquals(plp.verifysortFilterSpiceHightoLow(), true, "verifysortFilterSpiceHightoLow is not present");
        
        as.assertEquals(plp.verifysortFilterClearAllbutton(), true, "verifysortFilterClearAllbutton is not present");
        
        as.assertEquals(plp.verifysortFilterAPPLYbutton(), true, "verifysortFilterAPPLYbutton is not enable");
        
        plp.clicksortFilterCostLowtoHigh();
        
        plp.clickApplyButtonSortFilter();
        
      //Click on Menu Button
        plp.clickMenuButton();
        
        //Click on each collection under Menu
        plp.clickonMenufromList();
        
        as.assertEquals(plp.verifyfssaiText(), true, "verify fssai text is not enable");
        
        plp.ClickBackArrowButton();
        
        Thread.sleep(2000);        
        //Navigate to HOME page
        locality.scrollToText("Foodcourt on an App");
			
		as.assertAll();
	}
	
	
	@Test(enabled = false, priority = 9, description = "Verify Loyalty functionality on locality page")
	public void verifyLoyaltyFunctionality() throws Throwable {
	
	//LoyaltyPage verification
		LocalityPage locality = new LocalityPage(driver);
			locality.scrollToText("Earn SurePoints to join the Squad");
			LoyaltyPage loyalty = new LoyaltyPage(driver);
			Thread.sleep(1000);
			as.assertEquals(loyalty.verifyloyaltyeatsureEliteTitleLocalityPage(), true, "loyalty eatsure Elite Title LocalityPage is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureNoJoiningFeeBenefitTitleLocalityPage(), true, "loyalty eatsure NoJoiningFee BenefitTitle LocalityPage is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDelivery(), true, "loyalty Benefit Title FreeDelivery is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureFreedeliveryEligibilityLocalityPage(), true, "loyalty Benefit Title FreeDelivery Eligibility above ₹199 is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDishes(), true, "loyalty Benefit Title FreeDIshes is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureFreeDishEligibilityLocalityPage(), true, "loyalty Benefit Title FreeDIshes eligibility above ₹350 is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureDescriptionLocalityPage(), true, "verify loyalty eatsure Description LocalityPage is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureJoinDescriptionLocalityPage(), true, "verify loyalty eatsure Join Description LocalityPage is not present");
			as.assertAll();
			Thread.sleep(1000);
			loyalty.clickLoyaltyCardSection();
			Thread.sleep(2000);		
			//Under Loyalty program card
			as.assertEquals(loyalty.verifyloyaltyeatsureEliteTitleLocalityPage(), true, "loyalty eatsure Elite Title LocalityPage is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDelivery(), true, "loyalty Benefit Title FreeDelivery is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyBenefitTitleFreeDishes(), true, "loyalty Benefit Title FreeDIshes is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyloyaltyeatsureNoJoiningFeeBenefitTitleLocalityPage(), true, "loyalty eatsure NoJoiningFee BenefitTitle LocalityPage is not present");
			as.assertAll();
			//
			as.assertEquals(loyalty.verifyHowitWorksLoyaltyPage(), true, "loyalty How it works section is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifywhyJoinSureSquadeLoyaltyPage(), true, "loyalty Why join SureSquade is not present");
			as.assertAll();
//			as.assertEquals(loyalty.verifysureSquadLevelsLoyaltyPage(), true, "loyalty Sure Squad Level is not present");
			
			loyalty.scrollToText("FAQ's");
			
			
//			locality.scrollToText(driver,"FAQ's");
			Thread.sleep(1000);
			as.assertAll();
			as.assertEquals(loyalty.verifysilverPassLoyaltyPage(), true, "loyalty Silver Pass is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifygoldPassLoyaltyPage(), true, "loyalty Gold Pass is not present");
			as.assertAll();
			as.assertEquals(loyalty.verifyjoinSilverPassButtonLoyaltyPage(), true, "loyalty Join silver pass button is not enabled");
			as.assertAll();
			as.assertEquals(loyalty.verifyFAQLoyaltyPage(), true, "loyalty FAQ is not enabled");
			as.assertAll();
			Thread.sleep(1000);
			loyalty.scrollToText("EatSure Elite");
			Thread.sleep(1000);
			
			loyalty.clickonBackButtonLoyaltyPage(0);
			
			Thread.sleep(1000);
			
//			locality.scrollToText(prop.getProperty("gridcardName"));
			
//			locality.addNormalProductcondition(0);
			//Just I commented as we are login once click on CART page on next test case.
//			locality.scrollToText("Foodcourt on an App");
//			locality.scrollToText("Login");
			as.assertAll();
//		    as.assertEquals((locality.firstBanner).getAttribute("focusable")),"true"));
//			as.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/img_banner_item'])[1]")).getAttribute("focusable"),"true");
}
	
	@Test(enabled = true, priority = 10, description = "Verify Login flow on Login page via SMS")
	public void verifyLoginflow() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
//		locality.clickloginButton(driver);
		locality.clickCartButton(driver);
		Thread.sleep(2000);		
		SignUpPage signup = new SignUpPage(driver);
		as = new SoftAssert();
		as.assertEquals(signup.verifyLoginPageImage(), true, "Login page image not present");
		as.assertEquals(signup.verifySMSRadioButtonisSelected(), true, "SMS Radio button is not Selected");
		as.assertEquals(signup.verifySMSRadioButtonDisplayed(), true, "SMS Radio button is not present");
		as.assertEquals(signup.verifyWhatsAppRadioButtonisNotSelected(), true, "What's up Radio button is not selected");
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
		
		//OTP Communication window
		as.assertEquals(signup.verifyotpCommunicationText(), true, "OTP window communication text is not correct");
//		as.assertEquals(signup.verifysmsOTPSentText(), true, "SMS OTP SENT text didnot appear");
		signup.enterOTP(prop.getProperty("wrongOTP"));
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disabled");
		signup.clickVerifyotpButton(driver);
		as.assertEquals(signup.verifyotpcodeerrorText(), true, "OTP code error text is not correct");
		
		Thread.sleep(8000);
		as.assertEquals(signup.verifyresendOTPviaSMSText(), true, "OTP Window resend OTP via SMS text is not correct");
		as.assertEquals(signup.verifyresendOTPviaSMSbuttonEnabled(), true, "OTP Window resend OTP via SMS button is not enabled");
		as.assertEquals(signup.verifyresendOTPviaWhatsappText(), true, "OTP Window resend OTP via whatsapp text is not correct");
		as.assertEquals(signup.verifyresendOTPviaWhatsappbuttonEnabled(), true, "OTP Window resend OTP via whatsapp button is not enabled");
		
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disbaled");
		as.assertAll();
		
		signup.enterOTP(prop.getProperty("otp"));
		Thread.sleep(2000);
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disabled");
		as.assertAll();
		signup.clickVerifyotpButton(driver);
		
		log.info("Customer logged successfully to eatsure App");
		
		Thread.sleep(3000);
		LoyaltyPage loyalty = new LoyaltyPage(driver);
//		loyalty.handleLoyaltyProgramPoppedup();

//		locality.clickseeAllbuttontonavigatePLP(0);
		
		
	}
	
	//CART PAGE FLOW
	
	@Test(enabled = true, priority = 11, description = "Verify Cart page Contain")
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

	@Test(enabled = true, priority = 12, description = "Verify Increase quantity and edit the custemizable product from Cart page")
	public void verifyCartProducts() throws Throwable {
		CartPage cart = new CartPage(driver);

//		log.info("Total brand count in the cart " + cart.brandName());
//		log.info("Total product in the cart " + cart.productCount());
		as.assertEquals(cart.increaseQuantity(), 2, "Quantity increase not woriking");
		as.assertAll();
		log.info("Successfuly increase the quantity before quantity ");
		cart.editProduct();
	}

	@Test(enabled = true, priority = 13, description = "Verify add instruction")
	public void instruction() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.scrollToText("Write cooking instructions (Optional)");
		as.assertEquals(cart.instruction(), "Write cooking instructions (Optional)",
				"text not matching for instruction box");
		as.assertAll();
		as.assertEquals(cart.instructionInputBox(), "Write cooking instructions", "header title not matching");
		as.assertAll();

		as.assertEquals(cart.afterAddInst(), "Automation Test order", "Instructio not added");
		as.assertAll();
		log.info("Successfully added the cooking Instruction");
	}

	@Test(enabled = true, priority = 14, description = "Verify the address")
	public void address() throws Throwable {
		CartPage cart = new CartPage(driver);
		//click on chnage address
		cart.address();
		//Return "you delivery location" Address
		cart.conformLocation();
		//click on "conform Location and Proceed"
		cart.clickConformLOcation();
		// as.assertEquals(cart.conformLocation(),
		// cart.addaddresspagelocalityName(),"loaclity name not matching");
		// as.assertAll();
		//Entering the address details
		cart.addressAdded();
		Thread.sleep(2000);
		as.assertEquals(cart.verifyAddress(), "Eatsure", "address save not working");
		as.assertAll();
		log.info("verify Successfully add address working");

	}

	@Test(enabled = false, priority = 15, description = "Verify the coupon")
	public void coupon() throws Throwable {
		CartPage cart = new CartPage(driver);
		LocalityPage locality = new LocalityPage(driver);
		cart.scrollToText("Explore Coupons");
		as.assertEquals(cart.couponboxHeader(), "Coupons for you", "coupon header  show wrong");
		as.assertAll();
		as.assertEquals(cart.couponboxtitle(), "Explore Coupons", "coupon title show wrong");
		as.assertAll();
		//Click on "View All" button
		cart.view();
		// as.assertEquals(cart.couponHeader(), "Got an offer/ promo code?", "coupon
		// input box text not matching");
		// as.assertAll();
		// as.assertEquals(cart.apply(), false, "apply button not coming input box");
		// as.assertAll();
		/*
		 * as.assertEquals(cart.afterInput(), true,
		 * "apply button is enable after put coupon name "); as.assertAll();
		 * as.assertEquals(cart.couponError(), true, "Error message is not showing");
		 * as.assertAll();
		 */
		
		//Storing coupon name "BINlockCoupon"
		String couponListCouponname = cart.applyCouponName();
		//Retrieve the offer price "400"
		int offerPrice = cart.applydiscount();
		//Click on "Apply" button and almost verify the toast message "coupon applied successfully"
		cart.applycoupon();
		log.info("Successfully apply coupon " + cart.cuponapplyMessage());
//		Thread.sleep(2000);
//		locality.scrollToText("Coupons for you");
		
		// String nameCoupon=cart.popupCoupon();
		cart.scrollToText("SureSquad");
		Thread.sleep(2000);
		//verify above applied "Coupon Name"  on cart page
		as.assertEquals(cart.couponboxtitle(), couponListCouponname, "coupon name not showing save after applying");
		as.assertAll();
		
		//Verify above applied "price" on cart page
		as.assertEquals(cart.cartcouponprice(), offerPrice, "apply discount show wrong");
		as.assertAll();
		log.info("Successfully verify coupon section");
//		Thread.sleep(1000);
//		cart.scrollToText("Coupon Savings");
//		//Validate "coupon Saving" is displaying for each product
//		as.assertEquals(cart.couponTag(), true, "coupon tag not showing");
//		as.assertAll();
		log.info("Successfully verfi coupon tag after applied coupon");
	}

	@Test(enabled = false, priority = 16, description = "Verify free dish ")
	public void FreeDish() throws Throwable {
		CartPage cart = new CartPage(driver);
//		LocalityPage locality = new LocalityPage(driver);
		Thread.sleep(2000);
		cart.scrollToText("SureSquad");
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

	@Test(enabled = true, priority = 17, description = "Verify the bill details")
	public void billDetails() throws Throwable {
		CartPage cart = new CartPage(driver);
//		LocalityPage locality = new LocalityPage(driver);
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
	
	@Test(enabled = true, priority = 18, description = "Verify saving  details")
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
	
	@Test(enabled = true, priority = 19, description = "Verify payment page Contain")
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
	
	//TRACKING PAGE FLOW:-
	
	@Test(enabled = true, priority = 20, description = "Verify Tracking page Contain")
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
		//Validate "Live Order Tracking" header title
		as.assertEquals(tracking.verifyLiveOrderTrackingTextDisplay(driver), true,
				"Live Order Tracking Text Not displayed in Tracking Page");
		as.assertAll();
		//Verify Total Items and Price 
		as.assertEquals(tracking.verifyTotalItemsWithPriceTextDisplay(driver), true,
				"Total Items With Price Text Not displayed in Tracking Page");
		as.assertAll();
		//Retrieve the Item count and item Price
		int trackingcount = tracking.retrieveItemsCount();
		int trackingprice = tracking.retrievePrice();
		log.info("Item Count on tracking page "+ trackingcount);
		log.info("Item Price on Tracking Page "+ trackingprice);
		
		//Verify "Help" button displayed on Header
		as.assertEquals(tracking.verifyHelpButtonTextDisplay(driver), true,
				"Help Button Text Not displayed in Tracking Page");
		as.assertAll();
		//Verify "View My order details" link displayed
		as.assertEquals(tracking.verifyViewMyOrderDetailsLinkDisplay(driver), true,
				"View MyOrder Details Link Not displayed in Tracking Page");
		as.assertAll();
		//Verify Order prepared progress status is displayed
		as.assertEquals(tracking.verifyOrderStatusSectionDisplay(driver), true,
				"Order Status Section Display Not displayed in Tracking Page");
		as.assertAll();
		
		//Click on "View my Order Deatils"
		tracking.clickMyOrderDetailsLink();

		log.info("Successfully Verified Tracking Page");

	}

	@Test(enabled = true, priority = 21, description = "Verify Order Details/Summary page Contain")
	public void orderDetails() throws Throwable {
		OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
		TrackingPage tracking = new TrackingPage(driver);
		Thread.sleep(5000);
		//Verify "HELP" button under right side Header section in "Order Summary" section
		as.assertEquals(orderDetailsPage.verifyHelpButton(driver), true,
				"Help Button in Order Details Page Not displayed");
		as.assertAll();
		//Verify Order CRN details under "Order Summary" section
		as.assertEquals(orderDetailsPage.verifyOrderCrn(driver), true, "Order Crn in Order Details Page Not displayed");
		as.assertAll();
		//Verify Order place time under "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyOrderPlacedTime(driver), true,
				"Order Placed Time in Order Details Page Not displayed");
		as.assertAll();
		//Verify Total item count on "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyTotalItemCount(driver), true,
				"Total Item Count in Order Details Page Not displayed");
		as.assertAll();
		//Verify "Order Received" text under different cooking status under "Order SUmmary Page"
		as.assertEquals(orderDetailsPage.verifyOrderReceivedText(driver), true,
				"Order Received Text in Order Details Page Not displayed");
		as.assertAll();
		//Verify "Cooking" text under different cooking status under "Order SUmmary Page"
		as.assertEquals(orderDetailsPage.verifyOrderCookText(driver), true,
				"Order Cook Text in Order Details Page Not displayed");
		as.assertAll();
		//Verify "out for Delivery" text under different cooking status under "Order SUmmary Page"
		as.assertEquals(orderDetailsPage.verifyOrderOutForDeliveryText(), true,
				"OrderOutForDeliveryText in Order Details Page Not displayed");
		
		as.assertAll();
		
//		as.assertEquals(orderDetailsPage.verifyProductName(), true,
//				"ProductName in Order Details Page Not displayed");
//		as.assertAll();
//		as.assertEquals(orderDetailsPage.verifyProductPrice(driver), true,
//				"ProductPrice in Order Details Page Not displayed");
//		as.assertAll();
		//Verify "Delivery Address" text under "Order Summary" Page
		as.assertEquals(orderDetailsPage.verifyDeliveryAddressText(driver), true,
				"DeliveryAddressText in Order Details Page Not displayed");
		as.assertAll();
		//Verify "Address Label" under "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyAddressLabel(driver), true,
				"AddressLabel in Order Details Page Not displayed");
		as.assertAll();
		//Verify "Address Details" under "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyAddressDetail(driver), true,
				"AddressDetail in Order Details Page Not displayed");
		as.assertAll();
		//Verify "View taxes and other charges" link under "Order Summary" page
		tracking.scrollToText("View taxes and other charges");
		Thread.sleep(1000);
		as.assertEquals(orderDetailsPage.verifyViewTaxesAndOtherChargesLink(driver), true,
				"ViewTaxesAndOtherChargesLink in Order Details Page Not displayed");
		as.assertAll();
		
		//Click on "ViewTaxesAndOtherCharges" Link under "Order Summary" page
		orderDetailsPage.clickViewTaxesAndOtherChargesLink(driver);
		Thread.sleep(1000);
		tracking.scrollToText("Grand Total");
		//Verify "Grand Total" under "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyGrandTotalText(driver), true,
				"GrandTotalText in Order Details Page Not displayed");
		as.assertAll();
		//Verify "Grand Total" under "Order Summary" page
		as.assertEquals(orderDetailsPage.verifyGrandTotalAmount(driver), true,
				"GrandTotalAmount in Order Details Page Not displayed");
		as.assertAll();
		//Note "Grand Total" Amount in "order summary" page
		int grandTotalAmount = orderDetailsPage.retrieveGrandTotalAmount();
		log.info("Grand Total Amount in order summary page " +grandTotalAmount);
		//Verify "paidBy" text displayed under "order summary" page
		as.assertEquals(orderDetailsPage.verifyPaidByText(driver), true,
				"PaidByText in Order Details Page Not displayed");
		as.assertAll();
		//Verify "paidByTotalamount" text displayed under "order summary" page
		as.assertEquals(orderDetailsPage.verifyPaidByTotalAmount(driver), true,
				"PaidByTotalAmount in Order Details Page Not displayed");
		as.assertAll();
		
		log.info("Successfully Verified Order Details/Summary page Page");
		//Click on Back button
		orderDetailsPage.clickBackButton(driver);
		log.info("Successfully Verified Back button from Order Details Page");
		Thread.sleep(2000);
		//Click on Cross button
		tracking.clickBackButton(driver);
		log.info("Successfully Verified Rdirection from order details to Tracking Page");
		
	}

	@Test(enabled = true, priority = 22, description = "Verify Order Details page Contain")
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
		//Verify "My Orders" text under header section
		as.assertEquals(myOrdersPage.verifyMyOrdersText(driver), true, "My Orders Text in My Order Page Not displayed");
		as.assertAll();
		//Verify "Cooking" Status under "My Orders" page
		as.assertEquals(myOrdersPage.verifyOrderState(driver), true, "Orders State in My Order Page Not displayed");
		as.assertAll();
//		as.assertEquals(myOrdersPage.verifyProductName(driver), true, "Product Name in My Order Page Not displayed");
//		as.assertAll();
//		as.assertEquals(myOrdersPage.verifyProductPrice(driver), true, "Product Price in My Order Page Not displayed");
//		as.assertAll();
//		int myOrdersAmount = myOrdersPage.retrieveAmount();
//		log.info(myOrdersAmount);
//		as.assertEquals(myOrdersAmount, grandTotalAmount, "Amount is Not Matching in OrderDetails and My Orders Page");
		//Verify "Track my Order" button under "My Orders" page
		as.assertEquals(myOrdersPage.verifyBtnTrackOrder(driver), true,
				"Track Order Button in My Order Page Not displayed");
		as.assertAll();
		myOrdersPage.clickTrackMyOrderButton(driver);
		log.info("Successfully Verified My Orders Page");
		Thread.sleep(3000);
		//Verify it navigate to "LIVE Order Tracking" page
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
