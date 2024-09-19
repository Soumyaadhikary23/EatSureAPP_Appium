package com.eatsure.sampletest;

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
import com.eatsure.pom.android.LandingPage;
import com.eatsure.pom.android.LocalityPage;
import com.eatsure.pom.android.LoyaltyPage;
import com.eatsure.pom.android.ProductListingPage;
import com.eatsure.pom.android.RestaurantPage;
import com.eatsure.pom.android.SignUpPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class D2C_VR_ESAPP_SANITY extends BaseTest {
	SoftAssert as;
	public static final Logger log = LogManager.getLogger(D2C_VR_ESAPP_SANITY.class.getName());
//	LocalityPage locality = new LocalityPage(driver);
	
	@Test(enabled = true, priority = 0, description = "Verify landing page",groups= {"Smoke"})
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
		as.assertEquals(locality.verifyfoodOnTrainNavigationbarButton(), true,
				"FoodInTrain button under NavigationBar is not present");
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
	
	
	@Test(enabled = true, priority = 5, description = "Verify Restaurants Page,Product Listing Page")
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
		
		
		//Click on first Restaurant
		restPage.clickonfirstRestaurant();
		
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
	@Test(enabled = true, priority = 6, description = "Verify Restaurants Page,Product Details Page")
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
	
	
	@Test(enabled = true, priority = 9, description = "Verify Loyalty functionality on locality page")
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
			//Just I commented 
			locality.scrollToText("Foodcourt on an App");
//			locality.scrollToText("Login");
			as.assertAll();
//		    as.assertEquals((locality.firstBanner).getAttribute("focusable")),"true"));
//			as.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/img_banner_item'])[1]")).getAttribute("focusable"),"true");
}
	
	@Test(enabled = true, priority = 10, description = "Verify Login flow on Login page via SMS")
	public void verifyLoginflow() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		locality.clickloginButton(driver);
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
		
		signup.enterOTP(prop.getProperty("otp"));
		Thread.sleep(2000);
		as.assertEquals(signup.verifyotpButtonEnabled(), true, "OTP Window verify OTP button is disabled");
		signup.clickVerifyotpButton(driver);
		
		log.info("Customer logged successfully to eatsure App");
		
		Thread.sleep(5000);
		LoyaltyPage loyalty = new LoyaltyPage(driver);
		loyalty.handleLoyaltyProgramPoppedup();

//		locality.clickseeAllbuttontonavigatePLP(0);
		
		as.assertAll();
	}
	
	@Test(enabled = false, priority = 11, description = "Verify Signup flow for new user")
	public void verifySignUpFlow() throws Throwable {
		LocalityPage locality = new LocalityPage(driver);
		locality.clickloginButton(driver);
		SignUpPage signup = new SignUpPage(driver);	
		signup.enterNewMobileNumber();
		Thread.sleep(2000);
		signup.clickSendOTPButton(driver);
		as = new SoftAssert();
		as.assertEquals(signup.verifySignupPageContent(), true, "SignUp page Content is not present");
		as.assertAll();
		
		signup.enterNewEmailId();
        signup.enterNewUserName();
        signup.clickOnSignMeUpButton();
        Thread.sleep(30000);

	}
	
	
	
	@Test(enabled = false, priority = 12, description = "Verify footer section  on locality page")
	public void verifyFooterContains() throws Throwable {

		LocalityPage locality = new LocalityPage(driver);
		as = new SoftAssert();
		
		
//		locality.scrollToText("Login");

		// SCROLL
//		locality.scrollToText("Foodcourt on an App");
		// or
//		locality.restaurant(driver);
		// or
//		locality.scrollToText("Popular Cuisines");

//		locality.scrollTillRestaurantSection();

//		System.out.println("Scrolling Vivek");
//		locality.scrollDown(locality.monthENDSection);

		Thread.sleep(3000);
		System.out.println("Scrolling Up Vivek");

//		locality.scrollUp(locality.monthENDSection);
//		Thread.sleep(5000);
//		locality.scrollUp(locality.monthENDSection);

//		locality.scrollable();

//		locality.addIemTocartByIndex(0);
		locality.addNormalProductcondition(0);
		Thread.sleep(2000);
		locality.goToCartPage();
//		locality.addIemTocartByIndex(0);
		
		

	}
	
//	@AfterSuite
//	public void afterSuite() {
//
//		ExtentReport.extent.flush();
//	}

}
