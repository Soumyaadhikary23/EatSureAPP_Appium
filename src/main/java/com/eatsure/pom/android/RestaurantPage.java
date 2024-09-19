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

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RestaurantPage extends AndroidActions {
	
//	public AppiumDriverLocalService service;
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(LocalityPage.class.getName());
	public static  WebDriverWait wait; 
	public RestaurantPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_veg")
	WebElement vegFilterButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_non_veg")
	WebElement nonvegFilterButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/ivMenuButton")
	WebElement menuButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTitle")
	WebElement closeButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sort_filter")
	WebElement sortFilterButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_header_sort_filter")
	WebElement sortFilterButtonOncescrollDown;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/button_apply_filter")
	WebElement sortFilterAPPLYbutton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_price_low_to_high")
	WebElement sortFilterCostLowtoHigh;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_price_high_to_low")
	WebElement sortFilterCostHightoLOW;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBrandName'])[1]")
	WebElement firstRestaurant;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBrandName'])[2]")
	WebElement secondRestaurant;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_back")
	WebElement backButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
	public List<WebElement> addButtons;
	
	
	//PDP page 
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])[1]")
	public WebElement firstProductNameOnResturantPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvProductName']")
	WebElement ProductNameOnProductDetailPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvPrice']")
	WebElement ProductPriceOnProductDetailPage;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
	public WebElement addToCartButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/buttonAddItem")
	public WebElement addItemButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/layout_required")
	public WebElement requiredpoppedup;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a minimum of 1 and a maximum of 2']")
	public WebElement requiredSelectMinimumOneProductpoppedup;
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Select a minimum of 1 and a maximum of 2')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.CheckBox[1]")
	public WebElement requiredpoppedupCheckbox;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvAddProduct")
	public WebElement plusButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/backButton")
	WebElement backButtonPDP;
	
	
	
	
	/**
	 * Description:- Click on veg filter button on Restaurant page
	 * 
	 * 
	 * @author vivek ranjan Date:- 07-Apr-2024
	 * 
	 * 
	 */
	public void ClickVegFilterButton() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_veg")));
			if (vegFilterButton.isDisplayed()) {
				vegFilterButton.click();
//				driver.executeScript("mobile: doubleClickGesture",
//						ImmutableMap.of("elementId", ((RemoteWebElement) vegFilterButton).getId()));
				log.info("Successfully Clicked on Veg Button");
			}
		} catch (Exception e) {
			log.info(" Unable to see Veg Button");
		}
	}
	
	/**
	 * Description:- Click on nonveg filter button on Restaurant page
	 * 
	 * 
	 * @author vivek ranjan Date:- 07-Apr-2024
	 * 
	 * 
	 */
	public void ClicknonVegFilterButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_non_veg")));
			if (nonvegFilterButton.isDisplayed()) {
				nonvegFilterButton.click();
//				driver.executeScript("mobile: doubleClickGesture",
//						ImmutableMap.of("elementId", ((RemoteWebElement) nonvegFilterButton).getId()));
				log.info("Successfully Clicked on Non Veg Button");
			}
		} catch (Exception e) {
			log.info(" Unable to see Non-Veg Button");
		}
	}
	
	
	
	/**
	 * Description:-Click on each collection from Menu and validate the Shorting of product price from Low to High
	 * 
	 * @author @vivek Ranjan
	 * @param driver
	 * @throws Exception 
	 * @date 09-Apr-2024
	 */
	public void clickoneachCollectionfromMenuandValidatetheShortingofProductPriceFromLowToHigh() throws Exception {

		List<WebElement> menuList = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_collection_name']"));
		for (WebElement menu : menuList) {
			String collectionName=menu.getText();
			log.info(collectionName);
			String productCount = driver.findElement(By.xpath("//android.widget.TextView[@text='"+collectionName+"']/following-sibling::android.widget.TextView")).getText();
			int productValue  = Integer.valueOf(productCount);
			menu.click();
			int tempPrice=0;
			for(int i=1;i<=productValue;i++) {
				try {
				Thread.sleep(1000);
				WebElement elementName = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])["+i+"]"));
				String productName = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])["+i+"]")).getText();
				String productPrice = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_price'])["+i+"]")).getText();
//				driver.findElement(AppiumBy
//						.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName + "\"));"));
//				scrollToText(productName);
//				boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//						.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

//				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//					    "left", 100, "top", 100, "width", 200, "height", 200,
//					    "direction", "down",
//					    "percent", 3.0
//					));
//				boolean canScrollMore;
//				do {
//					canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//							.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
//
//				} while (canScrollMore);
//				scrollDown();
				
//				scrollUp();
				String numericString = productPrice.replaceAll("[^\\d]", "");
				int price = Integer.parseInt(numericString);
				log.info("Price as integer: " + price);
				if (tempPrice<price) {
					tempPrice = price;
				
					log.info(productName +" value is "+price+" in shorting order from Low to High");
				}else {
					throw new Exception(productName +" value is "+price+" in not shorting order from Low to High ");
				}
				log.info("Able to scroll till all the product in collection");
			} catch (Exception e) {
				log.info("Unable to scroll till all the product in collection");
			}
		}
			
			clickMenuButton();
		}
	}
	
	/**
	 * Description:-Click on each collection from Menu and validate the Shorting of product price from Low to High
	 * 
	 * @author @vivek Ranjan
	 * @param driver
	 * @throws Exception 
	 * @date 09-Apr-2024
	 */
	public void clickoneachCollectionfromMenuandValidatetheShortingofProductPriceFromHighToLow() throws Exception {

		List<WebElement> menuList = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_collection_name']"));
		for (WebElement menu : menuList) {
			String collectionName=menu.getText();
			log.info(collectionName);
			String productCount = driver.findElement(By.xpath("//android.widget.TextView[@text='"+collectionName+"']/following-sibling::android.widget.TextView")).getText();
			int productValue  = Integer.valueOf(productCount);
			menu.click();
			int tempPrice=0;
			for(int i=1;i<=productValue;i++) {
				try {
				Thread.sleep(1000);
				WebElement elementName = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])["+i+"]"));
				String productName = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])["+i+"]")).getText();
				String productPrice = driver.findElement(By.xpath("(//android.widget.TextView[@text='"+collectionName+"']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_price'])["+i+"]")).getText();
//				driver.findElement(AppiumBy
//						.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + productName + "\"));"));
//				scrollToText(productName);
//				boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//						.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

//				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//					    "left", 100, "top", 100, "width", 200, "height", 200,
//					    "direction", "down",
//					    "percent", 3.0
//					));
//				boolean canScrollMore;
//				do {
//					canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
//							.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
//
//				} while (canScrollMore);
//				scrollDown();
				
//				scrollUp();
				String numericString = productPrice.replaceAll("[^\\d]", "");
				int price = Integer.parseInt(numericString);
				log.info("Price as integer: " + price);
				if (tempPrice>price) {
					tempPrice = price;
				
					log.info(productName +" value is "+price+" in shorting order from HIGH to LOW");
				}else {
					throw new Exception(productName +" value is "+price+" in not shorting order from HIGH to LOW ");
				}
				log.info("Able to scroll till all the product in collection");
			} catch (Exception e) {
				log.info("Unable to scroll till all the product in collection");
			}
		}
			
			clickMenuButton();
		}
	}
	/**
	 * Description:- Click on "Menu" button on PLP page
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 01-Apr-2024
	 * 
	 * 
	 */
	public void clickMenuButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/ivMenuButton")));

		if (menuButton.isDisplayed()) {
			menuButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) menuButton).getId()));
			log.info(" Successfully Clicked on Menu Button");
		}
		}
		 catch (Exception e) {
				log.info(" Unable to see Menu Button");
			}

	}
	
	/**
	 * Description:- Click on "Close" button on PLP page
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 21-Apr-2024
	 * 
	 * 
	 */
	public void clickCloseButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvTitle")));

		if (closeButton.isDisplayed()) {
			closeButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) menuButton).getId()));
			log.info(" Successfully Clicked on Close Button");
		}
		}
		 catch (Exception e) {
				log.info(" Unable to see Close Button");
			}

	}
	
	
	/**
	 * Description:- Click on "sort" filter button on PLP page
	 * 
	 *
	 * @author vivek ranjan Date:- 28-March-2024
	 * 
	 * 
	 */
	public void clicksortFilterButton() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/tv_sort_filter")));
		
		if (sortFilterButton.isDisplayed()) {
			sortFilterButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) sortFilterButton).getId()));
		}
		log.info("Clicked successfully on sort filter button");
		} catch (Exception e) {
			log.info("Unable to find sort filter button");
		}
	}
	
	/**
	 * Description:- Click on "sort" filter button on PLP page once scroll down
	 * 
	 *
	 * @author vivek ranjan Date:- 21-Apr-2024
	 * 
	 * 
	 */
	public void clicksortFilterButtonOncescrollDown() {
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/tv_header_sort_filter")));
		
		if (sortFilterButtonOncescrollDown.isDisplayed()) {
			sortFilterButtonOncescrollDown.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) sortFilterButton).getId()));
		}
		log.info("Clicked successfully on sort filter button Once Scroll Down");
		} catch (Exception e) {
			log.info("Unable to find sort filter button Once Scroll Down");
		}
	}
	
	/**
	 * Description:- Click on "sortFilterCostLowtoHigh" button on sort/filter
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 04-Apr-2024
	 * 
	 * 
	 */
	public void clicksortFilterCostLowtoHigh() {

		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/radio_button_price_low_to_high")));
		sortFilterCostLowtoHigh.click();
		log.info("SUccessfully  clicked on clicksortFilterCostLowtoHigh ");
	}catch (Exception e) {
		
		log.info("Unable to click on clicksortFilterCostLowtoHigh ");
	}
	}
	
	/**
	 * Description:- Click on "sortFilterCostLowtoHigh" button on sort/filter
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 21-Apr-2024
	 * 
	 * 
	 */
	public void clicksortFilterCostHightoLow() {

		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/radio_button_price_high_to_low")));
		sortFilterCostHightoLOW.click();
		log.info("SUccessfully  clicked on clicksortFilterCostHightoLow ");
	}catch (Exception e) {
		
		log.info("Unable to click on clicksortFilterCostHightoLOW ");
	}
	}
	
	/**
	 * Description:- Click on "Apply" button on sort/filter
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 01-Apr-2024
	 * 
	 * 
	 */
	public void clickApplyButtonSortFilter() {
		sortFilterAPPLYbutton.click();
	}
	
	/**
	 * Description:- Click on "Menu" button on PLP page
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 01-Apr-2024
	 * 
	 * 
	 */
	public void clickonfirstRestaurant() {
		try {
			if (firstRestaurant.isDisplayed()) {
				firstRestaurant.click();
				log.info("First Restaurant is displayed ");
			}

		} catch (Exception e) {
			log.info("First Restaurant is not displayed");
		}
	}
	
	/**
	 * Description:- Click on back button on PLP page
	 * 
	 *
	 * @author vivek ranjan Date:- 11-Apr-2024
	 */
	public void ClickBackArrowButton() {
		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/iv_back")));
		backButton.click();
		log.info("SUccessfully  clicked on backButton ");
	}catch (Exception e) {
		
		log.info("Unable to click on backButton ");
	}
	}
	
	/**
	 * Description:-To getproductNameOnRestaurantPage
	 * @return
	 * @author vivek ranjan
	 * @date 13-Apr-2024
	 */
	public String getproductNameOnRestaurantPage() {
		String productNameOnRestaurantPage = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_name'])[1]")).getText();
		log.info("Product Name on RestaurantPage is " + productNameOnRestaurantPage);
		return productNameOnRestaurantPage;
	}
	
	/**
	 * Description:- To getproductPriceOnRestaurantPage
	 * @return
	 * @author vivek ranjan
	 * @date 13-Apr-2024
	 */
	public int getproductPriceOnRestaurantPage() {
		String productPriceOnRestaurantPage = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_product_price'])[1]")).getText();
		String numericString = productPriceOnRestaurantPage.replaceAll("[^\\d]", "");
		int priceOnRestaurantPage = Integer.parseInt(numericString);
		log.info("Price as integer: " + priceOnRestaurantPage);
		return priceOnRestaurantPage;
	}
	/**
	 * Description:- Click on First product to Navigate to PDP Page
	 * @author vivek ranjan
	 * @date 19-May-2024
	 */
	public void clickonFirstProductToNavigatetoPDPPage() {
		try {
		firstProductNameOnResturantPage.click();
		log.info("Successfully Navigated to PDP Page ");
		} catch (Exception e) {
		log.info("Unable to Navigate to PDP Page ");
		}
	}
	
	/**
	 * Description:- To getproductNameOnPDPPage
	 * @return
	 * @author vivek ranjan
	 * @date 13-Apr-2024
	 */
	
	public String getproductNameOnPDPPage() {
		String productNameOnProductDetailPage = ProductNameOnProductDetailPage.getText();
		log.info("Product Name on PDPPage is " + productNameOnProductDetailPage);
		return productNameOnProductDetailPage;
	}
	
	/**
	 * Description:- To getproductPriceOnProductDetailPage
	 * @return
	 * @author vivek ranjan
	 * @date 13-Apr-2024
	 */
	public int getproductPriceOnProductDetailPage() {
		String productPriceOnProductDetailPage = ProductPriceOnProductDetailPage.getText();
		String numericStringPDP = productPriceOnProductDetailPage.replaceAll("[^\\d]", "");
		int priceOnPDPPAge = Integer.parseInt(numericStringPDP);
		log.info("Price as integer: " + priceOnPDPPAge);
		return priceOnPDPPAge;
	}
	
	/**
	 * Descrption:- Add Normal Product from PDP Page
	 * Logic:- If will able to see the "Add Product" button then add the product else if will able to see the "+" button
	 * Then click on "+" button and increase the count by 1.
	 * @throws Exception
	 * @author vivek ranjan
	 * @date 13-Apr-2024
	 */
	public void addNormalProductfromPDPPage() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/btn_add")));
		Thread.sleep(1000);
//		if(addToCartButton.isDisplayed()) {
	try {
		addToCartButton.click();
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
			}catch (Exception e) {
				log.info("Required product is not present");
			}
//			addItemButton.click();

			log.info("Static combo added ");

		} catch (Exception e) {

			log.info("Noramal Item added ");
		}
		
		
		} catch (Exception e1) {
			
//			else if(plusButton.isDisplayed()){
			plusButton.click();
			try {
				addItemButton.isDisplayed();
				try {
					addItemButton.click();
//					requiredpoppedup.isDisplayed();
					requiredSelectMinimumOneProductpoppedup.isDisplayed();
					requiredpoppedupCheckbox.click();
					log.info("Required product is present");
				}catch (Exception e) {
					log.info("Required product is not present");
				}
				addItemButton.click();

				log.info("Static combo added ");

			} catch (Exception e) {

				log.info("Noramal Item added ");
			}
			
			}
	
	}
	
	/**
	 * Description:- Click on back button on PDP page
	 * 
	 *
	 * @author vivek ranjan Date:- 12-Apr-2024
	 */
	public void ClickBackArrowButtonPDP() {
		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/backButton")));
		backButtonPDP.click();
		log.info("SUccessfully  clicked on backButton on PDP Page ");
	}catch (Exception e) {
		
		log.info("Unable to click on backButton on PDP Page ");
	}
	}
	
	/**
	 * Description:- This is created to handle add Normal product combo box
	 * dynamically
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @date:- 20-Apr-2024
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
	
}

	
	

