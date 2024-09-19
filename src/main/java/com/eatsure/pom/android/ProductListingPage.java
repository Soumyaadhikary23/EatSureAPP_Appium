package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ProductListingPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(ProductListingPage.class.getName());
//	public static WebDriverWait wait;

	public ProductListingPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivNewArrow")
	WebElement newArrowbutton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvNewFeatureInfo")
	WebElement newFeatureInfo;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_back")
	WebElement backButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_all")
	WebElement allFilterButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_veg")
	WebElement vegFilterButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_non_veg")
	WebElement nonvegFilterButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sort_filter")
	WebElement sortFilterButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_header_sort_filter")
	WebElement sortFilterButtonafterScrolldown;

	// Locator of "veg" icon
//	public static By vegIcon = By.xpath("//div[@data-qa='isVeg']");
	public static By vegIcon = By.id("com.done.faasos.debug:id/img_category_product_type");

	// Locator of "Nonveg" icon
	// Note:- As of now we donot bang on any element on DOM to differentiate between
	// Veg or Non-Veg
//	public static By nonVegIcon = By.xpath("//div[@data-qa='isNonVeg']");
	public static By nonVegIcon = By.id("com.done.faasos.debug:id/img_category_product_type");

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivMenuButton")
	WebElement menuButton;

//	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBrandName'])[0]")
//	@AndroidFindBy(xpath = "(//android.widget.TextView)[0]")
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBrandName'])[1]")
	WebElement firstMission;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBrandName'])[2]")
	WebElement secondMission;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_filter_title")
	WebElement sortFiltertitel;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sort_by")
	WebElement sortFilterSortBy;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_price_low_to_high")
	WebElement sortFilterCostLowtoHigh;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_price_high_to_low")
	WebElement sortFilterCostHightoLow;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_spice_low_to_high")
	WebElement sortFilterSpiceLowtoHigh;

	@AndroidFindBy(id = "com.done.faasos.debug:id/radio_button_spice_high_to_low")
	WebElement sortFilterSpiceHightoLow;

	@AndroidFindBy(id = "com.done.faasos.debug:id/reset_filter_pref")
	WebElement sortFilterClearAllbutton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/button_apply_filter")
	WebElement sortFilterAPPLYbutton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add")
	public List<WebElement> addButtons;

	@AndroidFindBy(id = "com.done.faasos.debug:id/buttonAddItem")
	public WebElement addItemButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/layout_required")
	public WebElement requiredpoppedup;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select a minimum of 1 and a maximum of 2']")
	public WebElement requiredSelectMinimumOneProductpoppedup;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Select a minimum of 1 and a maximum of 2')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup//android.widget.CheckBox[1]")
	public WebElement requiredpoppedupCheckbox;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvFssaiNumber")
	public WebElement fassaiNumberText;
	
	

	/**
	 * Description: verify new feature info on PLP page
	 * 
	 * @return
	 * @author vivek ranjan
	 * @throws InterruptedException
	 * @date 28-March-2024
	 */
	public boolean verifynewFeatureInfo() throws InterruptedException {
		Thread.sleep(3000);
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/tvNewFeatureInfo")));
		if (newFeatureInfo.getText()
				.equalsIgnoreCase("Order from multiple restaurants and get them in a single delivery")) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:- Click on new Arrow button on PLP page
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 28-March-2024
	 */
	public void ClicknewArrowButton() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/ivNewArrow")));
		if (newArrowbutton.isDisplayed()) {
			driver.executeScript("mobile: clickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) newArrowbutton).getId()));
		}
	}

	/**
	 * Description:- Click on back button on PLP page
	 * 
	 *
	 * @author vivek ranjan Date:- 28-March-2024
	 */
	public void ClickBackArrowButton() {
		if (backButton.isDisplayed()) {
			backButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) backButton).getId()));
		}
	}

	/**
	 * Description:- Click on veg filter button on PLP page
	 * 
	 * 
	 * @author vivek ranjan Date:- 28-March-2024
	 * 
	 * 
	 */

	public void ClickVegFilterButton() {
		try {
			vegFilterButton.isDisplayed();
			vegFilterButton.click();
//			driver.executeScript("mobile: doubleClickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) vegFilterButton).getId()));
			log.info("Successfully click on Veg Icon");
		} catch (Exception e){
			log.info("Unable to click on Veg Icon");
		}
		
			
			
//			vegFilterButton.click();

//			 int x = vegFilterButton.getLocation().getX() + (vegFilterButton.getSize().getWidth() / 2);
//		        int y = vegFilterButton.getLocation().getY() + (vegFilterButton.getSize().getHeight() / 2);
//		        
//		        // Perform two consecutive clicks with a slight delay in between
//		        clickOnCoordinates(x, y);
//		        try {
//		            Thread.sleep(500); // Adjust delay as needed
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
//		        clickOnCoordinates(x, y);
//		    }
//
//		    public void clickOnCoordinates(int x, int y) {
//		    	MobileTouchAction touchAction = new MobileTouchAction(driver);
//		        touchAction.tap(x, y).perform();
//		    }

			
		
	}

	/**
	 * Description:- Click on nonveg filter button on PLP page
	 * 
	 * 
	 * @author vivek ranjan Date:- 28-March-2024
	 * 
	 * 
	 */
	public void ClicknonVegFilterButton() {
		try {
			nonvegFilterButton.isDisplayed();
			nonvegFilterButton.click();
//			driver.executeScript("mobile: doubleClickGesture",
//			ImmutableMap.of("elementId", ((RemoteWebElement) nonvegFilterButton).getId()));
			log.info("Successfully clicked on Non-Veg Icon");
		} catch (Exception e) {
			log.info("Unable to click on Non-Veg Icon");
		}
		
	}

	/**
	 * Description:- Click on "All" filter button on PLP page
	 * 
	 * 
	 * @author vivek ranjan Date:- 28-March-2024
	 * 
	 * 
	 */
	public void ClickAllFilterButton() {
		try {
			allFilterButton.isDisplayed();
			allFilterButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) allFilterButton).getId()));
			log.info("Successfully click on All Filter Button");
		} catch (Exception e) {
			log.info("Unable to click on All Filter Button");
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
		if (sortFilterButton.isDisplayed()) {
			sortFilterButton.click();
//			driver.executeScript("mobile: clickGesture",
//					ImmutableMap.of("elementId", ((RemoteWebElement) sortFilterButton).getId()));
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
//		for (int i=0;i<20;i++) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.
		if (menuButton.isDisplayed()) {
//			menuButton.click();
			driver.executeScript("mobile: clickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) menuButton).getId()));
		}
//	}
	}

	/**
	 * Description: This method will validate the "Veg" or "NonVeg" icon
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @param locator
	 * @return
	 * @date 31-March-2024
	 */
	public boolean verifyPresenceofVegorNonVegIcon(AndroidDriver driver, By locator, String type) {
		List<WebElement> icons = driver.findElements(locator);
		log.info("Number of Icon of " + type + icons.size());
		if (icons.size() != 0) {
			return true;

		} else
			return false;
	}

	/**
	 * Description:-Click on each Menu from list
	 * 
	 * @author @vivek Ranjan
	 * @param driver
	 */
	public void clickonMenufromList() {

		List<WebElement> menuList = driver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tv_collection_name']"));
		log.info("Number of collection on PLP Page " + menuList.size());
		for (WebElement menu : menuList) {
			log.info(menu.getText());
			menu.click();
			clickMenuButton();
		}
	}

	/**
	 * Method to get all sort/filter choices list and click on given choice
	 * 
	 * @author Lalit
	 * @param driver
	 */
	public void selectSortingFilterOption(AndroidDriver driver) {
		List<WebElement> sortChoices = driver
				.findElements(By.xpath("//div[@class='style__Wrapper-sc-1fi10uk-0 jhniOz']//label//p"));

		// System.out.println(sortChoices);
		for (WebElement sortChoice : sortChoices) {
			if (sortChoice.getText().contains("Cost: High to Low")) {
				sortChoice.click();
				log.info("User succesfully clicked on Sorting/Filter choice");
				break;
			}
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
	public void clickonfirstMission() {
		try {
			if (firstMission.isDisplayed()) {
				firstMission.click();
				log.info("First Mission is displayed ");
			}

		} catch (Exception e) {
			log.info("First Mission is not displayed");
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
	
	public void clickonsecondMission() {
		try {
			if (secondMission.isDisplayed()) {
				secondMission.click();
				log.info("Second Mission is displayed ");
			}

		} catch (Exception e) {
			log.info("Second Mission is not displayed");
		}
	}
	

	/**
	 * Description: Verify Sort And Filter title
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterTitle() {

		if (sortFiltertitel.getText().equalsIgnoreCase("Sort And Filter")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sort Filter SortBy
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterSortBy() {

		if (sortFilterSortBy.getText().equalsIgnoreCase("Sort by")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterCostLowtoHigh
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterCostLowtoHigh() {

		if (sortFilterCostLowtoHigh.getText().equalsIgnoreCase("Cost: Low to High")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterCostHightoLow
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterCostHightoLow() {

		if (sortFilterCostHightoLow.getText().equalsIgnoreCase("Cost: High to Low")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterSpiceLowtoHigh
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterSpiceLowtoHigh() {

		if (sortFilterSpiceLowtoHigh.getText().equalsIgnoreCase("Spice: Low to High")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterSpiceHightoLow
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterSpiceHightoLow() {

		if (sortFilterSpiceHightoLow.getText().equalsIgnoreCase("Spice: High to Low")) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterClearAllbutton
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterClearAllbutton() {

		if (sortFilterClearAllbutton.isDisplayed()) {
			return true;
		} else
			return false;
	}

	/**
	 * Description: Verify sortFilterAPPLYbutton
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 03-Apr-2024
	 */
	public boolean verifysortFilterAPPLYbutton() {

		if (sortFilterAPPLYbutton.isEnabled()) {
			return true;
		} else
			return false;
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
	 * Description:- Click on "sortFilterCostLowtoHigh" button on sort/filter
	 * 
	 * @param driver
	 * @author vivek ranjan Date:- 04-Apr-2024
	 * 
	 * 
	 */
	public void clicksortFilterCostLowtoHigh() {

		WebDriverWait wait;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.done.faasos.debug:id/radio_button_price_low_to_high")));
		sortFilterCostLowtoHigh.click();
	}

//	public void pullToRefresh() {
//		
//		
//		int deviceWidth = driver.manage().window().getSize().getWidth();
//		int deviceHeight = driver.manage().window().getSize().getHeight();
//
//		int midX = (deviceWidth / 2);
//		int midY = (deviceHeight / 2);
//
//
//		int bottomEdge = (int) (deviceHeight * 0.85f);
//
//
//		new TouchAction(driver)
//		    .press(point(midX,midY))
//		    .waitAction(waitOptions(ofMillis(1000)))
//		    .moveTo(point(midX, bottomEdge))
//		    .release().perform(); 
//	}

	/**
	 * Description:- Click on any place via co-ordinate
	 * 
	 * @author vivek ranjan date:-03-Apr-2024
	 */

	public void clickElementByCoordinates(By vegIcon2, int x, int y) {
		TouchAction touchAction = new TouchAction((AndroidDriver) driver);
		touchAction.tap(PointOption.point(x, y)).perform();
	}
	
	/**
	 * Description:- This is created to handle add Normal product combo box
	 * dynamically
	 * 
	 * @author vivek ranjan
	 * @param driver
	 * @date:- 15-Mar-2024
	 */
	public void addNormalProductconditionFromPLPpage(int index) {
      try {
		addButtons.get(index).click();
         log.info("Successfully Clicked on Add button");
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
			}catch (Exception e) {
				log.info("Required product is not present");
			}
//			addItemButton.click();

			log.info("Static combo added ");

		} catch (Exception e) {

			log.info("Noramal Item added ");
		}
		
      } catch (Exception e) {
    	  log.info("Unable to click on Add button");
    	  
      }
	}
	
	/**
	 * Description: Verify Fssai number text
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 07-Apr-2024
	 */
	public boolean verifyfssaiText() {

		if (fassaiNumberText.getText().trim().equalsIgnoreCase("License No.")) {
			return true;
		} else
			return false;
	}
	
}
