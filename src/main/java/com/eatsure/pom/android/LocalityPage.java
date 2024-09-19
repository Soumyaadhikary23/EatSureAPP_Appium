package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LocalityPage extends AndroidActions {
//	public AppiumDriverLocalService service;
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(LocalityPage.class.getName());
	public static WebDriverWait wait;

	public LocalityPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_search_location")
	WebElement searchLocationBox;

	@AndroidFindBy(className = "android.widget.TextView")
	WebElement locationList;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvRestaurantsHeader")
	WebElement restaurantSection;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_login")
	private WebElement loginButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvGridHeader")
	public WebElement monthENDSection;

	@AndroidFindBy(id = "com.done.faasos.debug:id/v_notification_background")
	public WebElement notificationBar;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivCloseSurePoints")
	public WebElement notificationBarCancle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
	public WebElement addButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/notification_dialog")
	public WebElement notificationDialog;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_no_notification")
	public WebElement noNotificationDialog;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_yes_notification")
	public WebElement enableNotificationButton;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/grant_dialog")
	public WebElement grantDialog;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	public WebElement allowPermissionButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_location_icon")
	public WebElement locationIcon;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvStoreNotFoundTitle")
	public WebElement nonServiceableTitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTryAnotherLocation")
	public WebElement tryAnotherLocationButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/toolbarTitle")
	public WebElement enterDeliveryLocationTitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_address")
	public WebElement locationNameHeader;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvDeliveryNav")
	public WebElement deliveryNavigationbarButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvDeliveryTime")
	public WebElement nowNavigationbarButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/viewBGPickup")
	public WebElement dineInNavigationbarButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/viewBgIrctc")
	public WebElement foodOnTrainNavigationbarButton;

	//Search section
	@AndroidFindBy(id = "com.done.faasos.debug:id/btnSearchProduct")
	public WebElement searchSection;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/etSearchProduct")
	public WebElement searchProductSection;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/img_banner_item'])[1]")
	public WebElement firstBanner;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/img_banner_item'])[2]")
	public WebElement secondBanner;

	@AndroidFindBy(id = "com.done.faasos.debug:id/img_banner_item")
	public List<WebElement> listofBanners;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/ivBrandCarouselLogo']")
	public List<WebElement> listofbrandsLocality;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvExploreAll' and @text='See all']")
	public WebElement seeallButtonRestaurant;

	@AndroidFindBy(id = "com.done.faasos.debug:id/cl_brand_parent")
	public List<WebElement> listofbrandsLocalityUnderSeeAll;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.done.faasos.debug:id/ivBrandLogoBg']")
	public List<WebElement> listofbrandsUnderSearchSection;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
	public List<WebElement> addButtons;

	@AndroidFindBy(id = "com.done.faasos.debug:id/buttonAddItem")
	public WebElement addItemButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/navigation_bar_item_icon_view")
	public WebElement cartButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivBackButton")
	public WebElement backButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvGridSeeAll")
	public List<WebElement> seeAllButtons;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cart']")
	public WebElement cartButtons;

	@AndroidFindBy(id = "com.done.faasos.debug:id/layout_required")
	public WebElement requiredpoppedup;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a minimum of 1 and a maximum of 2']")
	public WebElement requiredSelectMinimumOneProductpoppedup;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Select a minimum of 1 and a maximum of 2')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.CheckBox[1]")
	public WebElement requiredpoppedupCheckbox;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Foodcourt on an App')]/parent::android.view.ViewGroup//android.widget.TextView[starts-with(@text,'See all')]")
	WebElement seeAllButtonUnderRestaurantSection;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvRestaurants")
	public WebElement restaurantsStrip;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_back")
	public WebElement backButtonStrip;
	
	//Search sections locators
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvNoResultFound")
	public WebElement searchSectionNoResultFoundText;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvRestaurantTitle")
	public WebElement searchSectionRestaurantTitle;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/ivBack")
	public WebElement searchSectionBackArrowButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/ivClearSearch")
	public WebElement searchSectionCrossButton;
	
//	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
//	public List<WebElement> addButtons;
	

	/**
	 * Description:- Click on search location box
	 * 
	 * @param driver
	 */
	public void ClickSearchLocationBox(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/et_search_location")));
			searchLocationBox.click();
			log.info("SUccessfully click on Search Location Box");
		} catch (Exception e) {
			log.info("Unable to click on Search Location Box");
		}
	}

	/**
	 * Description:- Selection of store from Locality page
	 * 
	 * @param storeName
	 * @throws InterruptedException
	 */

	public void storeselect(String storeName) throws InterruptedException {
		Thread.sleep(3000);
		try {
		searchLocationBox.sendKeys(storeName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
		List<WebElement> locations = driver.findElements(By.id("com.done.faasos.debug:id/tv_place_name"));
		WebElement store = locations.stream().filter(location -> location.getText().equalsIgnoreCase(storeName))
				.findFirst().orElse(null);
		if (store != null) {
			store.click();
		} else {
			System.out.println("Store not found!");
		}
		log.info("Successfully  find the location "+ storeName );
		} catch (Exception e) {
			log.info("Unable to find the location "+ storeName );
		}

	}

	public void scrollTillRestaurantSection() {
		scrollable(restaurantSection);
	}

	/**
	 * Description:-Swipe banner till last available banner
	 * 
	 * @param driver
	 * @param direction
	 * @throws InterruptedException
	 * @author vivek ranjan Date:- 19-March-2024
	 */

	public void swipeBanner(AndroidDriver driver, String direction) throws InterruptedException {

		try {
			List<WebElement> banners = driver.findElements(By.id("com.done.faasos.debug:id/img_banner_item"));
			for (WebElement banner : banners) {
				swipeAction(banner, direction);
			}
			log.info("Swipe all the Banners");
		} catch (Exception e) {
			log.info("Banners are not present");
		}
	}

	/**
	 * Description:- Scroll till "seeALL" button under Restaurant Page
	 * 
	 * @author vivek ranjan Date:- 08-Apr-2024
	 */
	public void scrolltillRestaurantSection() {
		try {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[starts-with(@text,'Foodcourt on an App')]/parent::android.view.ViewGroup//android.widget.TextView[starts-with(@text,'See all')]")));
//		scrollDown(seeAllButtonUnderRestaurantSection);
			scrollable(seeAllButtonUnderRestaurantSection);
			log.info("Scroll till seeAll button under Restaurant section");
		} catch (Exception e) {
			log.info("Unable to Scroll till seeAll button under Restaurant section");
		}
	}

	/**
	 * Description: Verify "Help Us Locate You" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifyLoginButton() {

		if (loginButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify "location Name Header" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifylocationNameHeader() {

		if (locationNameHeader.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify "Delivery button under NavigationBar" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifydeliveryNavigationbarButton() {

		if (deliveryNavigationbarButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify "Now button under NavigationBar" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifynowNavigationbarButton() {

		if (nowNavigationbarButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify "DineIn button under NavigationBar" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifydineInNavigationbarButton() {

		if (dineInNavigationbarButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify "FoodOnTrain button under NavigationBar" Text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifyfoodOnTrainNavigationbarButton() {

		if (foodOnTrainNavigationbarButton.isDisplayed()) {
			return true;

		} else
			return false;
	}

	/**
	 * Description: Verify top "Search section"
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifytopSearchSection() {

		if (searchSection.isDisplayed()) {
			return true;

		} else
			return false;
	}
	
	/**
	 * Description: Enter text under "Search section"
	 * 
	 * @return
	 * @author vivek ranjan
	 * @throws Exception 
	 * @date 17-Apr-2024
	 */
	public  void clickonSearchBox() throws Exception {
		try {
			Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/btnSearchProduct")));
		searchSection.click();
		log.info("Successfully click on search box ");
		} catch (Exception e) {
			log.info("Unable to click on search box ");
		}
	}
	
	/**
	 * Description: Enter text under "Search section"
	 * 
	 * @return
	 * @author vivek ranjan
	 * @throws Exception 
	 * @date 17-Apr-2024
	 */
	public  void enterTextunderSearchBox(String text) throws Exception {
		try {
			
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/etSearchProduct")));
		searchProductSection.sendKeys(text);
		Thread.sleep(3000);
		log.info("Correctly enter the text under search box "+text );
		} catch (Exception e) {
			log.info("Unable to enter the text under search box "+text );
		}
	}
	
	
	
	

	/**
	 * Description:-Cancel "sign up" notification Bar
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 15-Mar-2024
	 */
	public void canceLoyaltyNotificationBar(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/v_notification_background")));
			if (notificationBar.isDisplayed()) {
				notificationBarCancle.click();
			}
			log.info("Clicked successfully on Cancel Notification bar");
		} catch (Exception e) {
			log.info("Cancel Notification bar is not present");
		}

	}

	/**
	 * Description:- Scroll till Restaurant section
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date:- 15-March-2024
	 */
	public void restaurant(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/view_see_all")));
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Foodcourt on an App\"));"));
	}

	/**
	 * Description:- Click enable Notification Button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 15-March-2024
	 */
	public void clickenableNotificationButton(AndroidDriver driver) {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_yes_notification")));
			if (notificationDialog.isDisplayed()) {
				enableNotificationButton.click();
				log.info("Notification window for Android-13 is displayed ");
			}
		} catch (Exception e) {
			log.info("Notification window for Android-13 is not displayed");
		}

	}

	/**
	 * Description:- Click enable Notification Button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 15-March-2024
	 */
	public void clickNoNotificationButton(AndroidDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_no_notification")));
			if (noNotificationDialog.isDisplayed()) {
				noNotificationDialog.click();
				log.info("Successfully Clicked on No I am Good Notification window ");
			}
		} catch (Exception e) {
			log.info(" No I am Good Notification window  is not displayed");
		}

	}

	/**
	 * Description:-Click Allow permission Button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date:- 15-March-2024
	 */
	public void clickallowPermissionButton(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/grant_dialog")));
			if (grantDialog.isDisplayed()) {
				allowPermissionButton.click();
				log.info("Allow window is displayed ");
			}
		} catch (Exception e) {
			log.info("Allow window is not displayed ");
		}

	}

	/**
	 * Description:- This is created to handle add Normal product combo box
	 * dynamically
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @date:- 15-Mar-2024
	 */
	public void addNormalProductcondition(int index) {

		addButtons.get(index).click();

//		clickJavaScript(element, driver);
		try {
			addItemButton.isDisplayed();
			try {
				addItemButton.click();
//				requiredpoppedup.isDisplayed();
				try {
					requiredSelectMinimumOneProductpoppedup.isDisplayed();
					requiredpoppedupCheckbox.click();
					addItemButton.click();
					log.info("Required product is present");
				} catch (Exception e) {
					log.info("Required product is not present");
				}
				
				
			} catch (Exception e) {
				log.info("Required product is not present");
			}
//			addItemButton.click();

			log.info("Static combo added ");

		} catch (Exception e) {

			log.info("Noramal Item added ");
		}
	}

	/**
	 * 
	 */
	public void goToCartPage() {
		cartButton.click();

	}

	/**
	 * Description:- Click on location icon
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 18-March-2024
	 */
	public void ClicklocationIcon(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/iv_location_icon")));
		locationIcon.click();
	}

	/**
	 * Description: Verify the nonServiceableLocation
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-March-2024
	 */
	public boolean verifynonServiceableLocationTitle() {

		if (nonServiceableTitle.getText().replaceAll("\\r?\\n", " ").contains("We Haven't Reached Here Yet!")) {
			log.info("NonServiceableLocationTitle" + nonServiceableTitle.getText());
			return true;
		} else
			return false;
	}

	/**
	 * Description:- Click on tryAnotherLocation button
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 18-March-2024
	 */
	public void ClicktryAnotherLocation(AndroidDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/tvTryAnotherLocation")));
		tryAnotherLocationButton.click();
	}

	/**
	 * Description: Verify Enter Your Delivery Location Title
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 18-Mar-2024
	 */
	public boolean verifyenterDeliveryLocationTitle() {

		if (enterDeliveryLocationTitle.getText().contains("Enter Your Delivery Location")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description:-listofbrandsLocality
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 19-March-2024
	 */
	public int listofbrandsLocality() {
		int numberofRestaurantonLocalitypage = listofbrandsLocality.size();
		log.info("listofbrandsLocality " + numberofRestaurantonLocalitypage);
		return numberofRestaurantonLocalitypage;

	}

	/**
	 * Description:-listofbrandsLocalityUnderSeeAll
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 19-March-2024
	 */
	public int listofbrandsLocalityUnderSeeAll() {
		int numberofRestaurantsUnderSeeAll = listofbrandsLocalityUnderSeeAll.size();
		log.info("listofbrandsLocalityUnderSeeAll " + numberofRestaurantsUnderSeeAll);
		return numberofRestaurantsUnderSeeAll;

	}
	
	/**
	 * Description:-listofBrandsUnderSearch section
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 17-Apr-2024
	 */
	public int listofBrandsUnderSearch() {
		int numberofRestaurantonSearchSectionpage = listofbrandsUnderSearchSection.size();
		log.info("listofbrandsSearch section " + numberofRestaurantonSearchSectionpage);
		return numberofRestaurantonSearchSectionpage;

	}

	/**
	 * Description:- Click on seeAll button under restaurants section
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date 20-Mar-2024
	 */
	public void clickseeAllRestaurantsSection(AndroidDriver driver) {

		seeallButtonRestaurant.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvSearch")));
	}

	/**
	 * Description:- Click login button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date:- 22-March-2024
	 */

	public void clickloginButton(AndroidDriver driver) {

//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_login")));
			loginButton.click();
			log.info("Click on Login button successfully");
		} catch (Exception e) {
			log.info("Login Button is not present");
		}
	}

	/**
	 * Description:- Click Back button
	 * 
	 * @param driver
	 * @author vivek ranjan Date 22-March-2024
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

	/**
	 * Description:- Click Back button strip from Restaurant Page once navigated via
	 * Banner
	 * 
	 * @param driver
	 * @author vivek ranjan Date 15-Apr-2024
	 */
	public void clickBackButtonStrip(AndroidDriver driver) {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/iv_back")));
			backButtonStrip.click();
			log.info("Click on Back button strip on Restaurant Page successfully");
		} catch (Exception e) {
			log.info("Back Button Strip is not present on Restaurant Page");
		}
	}

	/**
	 * Description:- This is created to click on "See All" to navigate to PLP
	 * dynamically
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @return
	 * @date:- 15-Mar-2024
	 */
	public void clickseeAllbuttontonavigatePLP(int index) {
		try {
			seeAllButtons.get(index).click();

			log.info("Navigated to PLP page ");

		} catch (NoSuchElementException e) {

			log.info("Unable to see seeAll button ");
		}
//		return driver;
	}

	/**
	 * Description:- Click login button
	 * 
	 * @param driver
	 * @author vivek ranjan
	 * @date:- 22-March-2024
	 */

	public void clickCartButton(AndroidDriver driver) {
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Cart']")));
			cartButtons.click();
			log.info("Click on Cart button");
		} catch (Exception e) {
			log.info("Cart Button is not present");
		}
	}

	/**
	 * Description:- Click on first Restaurant
	 * 
	 * @author vivek ranjan
	 * @date:- 22-March-2024
	 */
	public void ClickonFirstRestaurant(int index) {
		try {
			listofbrandsLocality.get(index).click();
			log.info("Successfully clicked on first Restaurant");
		} catch (Exception e) {
			log.info("Unable to click on first Restaurant");
		}

	}

	/**
	 * Description:- Click on first Banner
	 * 
	 * @author vivek ranjan
	 * @date:- 15-Apr-2024
	 */
	public void ClickonFirstBanner(int index) {
		try {
			listofBanners.get(index).click();
			log.info("Successfully clicked on first Banner");
		} catch (Exception e) {
			log.info("Unable to click on first Banner");
		}
	}

	/**
	 * Description: Verify Restaurant Strip
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 15-APr-2024
	 */
	public boolean verifyRestaurantStrip() {

		if (restaurantsStrip.getText().equalsIgnoreCase("Restaurants")) {
			return true;

		} else
			return false;
	}
	
	//Search section Methods
	/**
	 * Description: Verify SectionNoResultFoundText
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 17-Apr-2024
	 */
	public boolean verifysearchSectionNoResultFoundText() {

		if (searchSectionNoResultFoundText.getText().contains("No search result found")) {
			return true;
		} else
			return false;
	}
	
	/**
	 * Description: Verify searchSectionRestaurantTitle
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 17-Apr-2024
	 */
	public boolean verifysearchSectionRestaurantTitle() {

		if (searchSectionRestaurantTitle.getText().contains("Most Loved Restaurants")) {
			return true;
		} else
			return false;
	}
	
	/**
	 * Description:- Click on cross button under search section
	 * 
	 * @author vivek ranjan
	 * @date:- 18-Apr-2024
	 */
	public void clickOnsearchSectionCrossButton() {
		try {
			searchSectionCrossButton.click();
			log.info("Successfully clicked on Cross Button");
		} catch (Exception e) {
			log.info("Unable to click on searchSectionCrossButton");
		}
	}
	
	/**
	 * Description:- Click Back button search page
	 * 
	 * @param driver
	 * @author vivek ranjan Date 18-Apr-2024
	 */
	public void clickBackButtonSearchSection() {
		try {
//	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/ivBack")));
			searchSectionBackArrowButton.click();
			log.info("Click on Search section Back button successfully");
		} catch (Exception e) {
			log.info("Search section Back Button is not present");
		}
	}
	
	/**
	 * Description:- This is created to handle add Normal product combo box from Search section
	 * dynamically
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @date:- 15-Mar-2024
	 */
	public void addNormalProductSearchSectioncondition(int index) {

		addButtons.get(index).click();

//		clickJavaScript(element, driver);
		try {
			addItemButton.isDisplayed();
			try {
				addItemButton.click();
//				requiredpoppedup.isDisplayed();
				if (requiredSelectMinimumOneProductpoppedup.isDisplayed()) {
					requiredpoppedupCheckbox.click();
					log.info("Required product is present");
					addItemButton.click();
				}
			} catch (Exception e) {
				log.info("Required product is not present");
			}
//			addItemButton.click();

			log.info("Static combo added ");

		} catch (NoSuchElementException e) {

			log.info("Noramal Item added ");
		}
	}


}
