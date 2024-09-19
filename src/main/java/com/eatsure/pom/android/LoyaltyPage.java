package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class LoyaltyPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(LoyaltyPage.class.getName());
	public static  WebDriverWait wait; 
	public LoyaltyPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvJoinPassDialogTitle")
	WebElement loyaltyJoinPassDialogTitle;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvJoinPassDialogDesc")
	WebElement loyaltyJoinPassDialogDescription;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvBenefitTag")
	WebElement loyaltyBenefitTag;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FREE Delivery']")
	WebElement loyaltyBenefitTitleFreeDelivery;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Free Dishes']")
	WebElement loyaltyBenefitTitleFreeDishes;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/btnJoinSurePass")
	WebElement loyaltyJoinSurePass;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBenefitDesc'])[1]")
	public WebElement loyaltyeatsureFreedeliveryEligibilityLocalityPage;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBenefitDesc'])[2]")
	public WebElement loyaltyeatsureFreeDishEligibilityLocalityPage;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvJoiningFee")
	WebElement loyaltyJoiningFee;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_close")
	public WebElement closeLoyaltyPopup;
	
	//Locality Page Loyalty Page Locator
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EatSure Elite']")
	public WebElement loyaltyeatsureEliteTitleLocalityPage;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvSurePassDescFirstTime")
	public WebElement loyaltyeatsureDescriptionLocalityPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No Joining fees required']")
	public WebElement loyaltyeatsureNoJoiningFeeBenefitTitleLocalityPage;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvJoinDesc")
	public WebElement loyaltyeatsureJoinDescriptionLocalityPage;
	
	
	//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBenefitDesc'])[1]
	
	//Loyalty Page Locator under once click on Loyalty card
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='How it works?']")
	public WebElement HowitWorksLoyaltyPage;
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Earn SurePoints\r\n"
			+ "on every order']")
	public WebElement earnSurePointsLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Use SurePoints\r\n"
			+ "to join a pass']")
	public WebElement useSurePointsLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Use SurePoints\r\n"
			+ "to join a pass']")
	public WebElement claimFREEBenefitsLoyaltyPage;
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Why Join SureSquad?']")
	public WebElement whyJoinSureSquadeLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SureSquad Levels']")
	public WebElement sureSquadLevelsLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Silver pass']")
	public WebElement silverPassLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gold pass']")
	public WebElement goldPassLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Join Silver pass']")
	public WebElement joinSilverPassButtonLoyaltyPage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FAQ's\"]")
	public WebElement FAQLoyaltyPage;
	
	
	@AndroidFindBy(xpath = "//button[starts-with(@class,'style__BackButton')]")
	public WebElement backButtonLoyaltyPageWEBVIEW;
	
	@AndroidFindBy(className = "android.widget.Button")
	public List<WebElement> backButtonLoyaltyPage;
	

	
	
	
	
	
	
	
	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Use SurePoints\r\n"
//			+ "to join a pass']")
//	//public WebElement earnSurePointsLoyaltyPage;
	
	
	
	/**
	 * Description: verifyloyaltyJoinPassDialogTitle
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyJoinPassDialogTitle() {
		try {
		if (loyaltyJoinPassDialogTitle.getText().equalsIgnoreCase("SureSquad")) {
			return true;

		} else {
			return false;
		}
		} catch (Exception e) {
			log.info("loyaltyJoinPassDialog is not displayed");
			return false;
		}
		
	}
//	public boolean verifyloyaltyJoinPassDialogTitle() {
//		if (loyaltyJoinPassDialogTitle.getText().equalsIgnoreCase("SureSquad")) {
//			return true;
//
//		} else
//			return false;
//		}
	
	
	/**
	 * Description: Verify loyaltyJoinPassDialogDescription
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyJoinPassDialogDescription() {
	
		if (loyaltyJoinPassDialogDescription.getText().equalsIgnoreCase("Use   1200 to join Gold pass  Know more.")) {
			return true;

		} else {
			return false;
		}
	}
	
//	public boolean verifyloyaltyJoinPassDialogDescription() {
//		if (loyaltyJoinPassDialogDescription.getText().equalsIgnoreCase("Use   1200 to join Gold pass  Know more.")) {
//			return true;
//
//		} else
//			return false;
//		}
	/**
	 * Description: verify loyaltyBenefitTag
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyBenefitTag() {
		
		if (loyaltyBenefitTag.getText().equalsIgnoreCase("No Joining fees required")) {
			return true;

		} else
			return false;
		
	}
	
//	public boolean verifyloyaltyBenefitTag() {
//		if (loyaltyBenefitTag.getText().equalsIgnoreCase("No Joining fees required")) {
//			return true;
//
//		} else
//			return false;
//		}
	
	/**
	 * Description: verify loyaltyBenefitTitleFreeDelivery
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyBenefitTitleFreeDelivery() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@text='FREE Delivery']")));
		if (loyaltyBenefitTitleFreeDelivery.getText().equalsIgnoreCase("FREE Delivery")) {
			return true;

		} else
			return false;
		}
	
	/**
	 * Description: verify loyaltyeatsureFreedeliveryEligibilityLocalityPage
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 17-Apr-2024
	 */
	public boolean verifyloyaltyeatsureFreedeliveryEligibilityLocalityPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBenefitDesc'])[1]")));
		if (loyaltyeatsureFreedeliveryEligibilityLocalityPage.getText().equalsIgnoreCase("above ₹199")) {
			return true;

		} else
			return false;
		}
	
	/**
	 * Description: verify loyaltyBenefitTag
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyBenefitTitleFreeDishes() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@text='Free Dishes']")));
		if (loyaltyBenefitTitleFreeDishes.getText().equalsIgnoreCase("Free Dishes")) {
			return true;

		} else
			return false;
		}
	
	/**
	 * Description: verify loyaltyeatsureFreeDishEligibilityLocalityPage
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 17-Apr-2024
	 */
	public boolean verifyloyaltyeatsureFreeDishEligibilityLocalityPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvBenefitDesc'])[2]")));
		if (loyaltyeatsureFreeDishEligibilityLocalityPage.getText().equalsIgnoreCase("above ₹350")) {
			return true;

		} else
			return false;
		}
	/**
	 * Description: verify loyaltyJoinSurePass
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyJoinSurePass() {
		
		if (loyaltyJoinSurePass.getText().equalsIgnoreCase("Join Gold pass")) {
			return true;

		} else
			return false;
		
	}
	
//	public boolean verifyloyaltyJoinSurePass() {
//		if (loyaltyJoinSurePass.getText().equalsIgnoreCase("Join Gold pass")) {
//			return true;
//
//		} else
//			return false;
//		}
	/**
	 * Description: verify loyaltyJoiningFee
	 * 
	 * @return
	 * @author vivek ranjan
	 * @date 28-March-2024
	 */
	public boolean verifyloyaltyJoiningFee() {
		
		if (loyaltyJoiningFee.getText().equalsIgnoreCase("No Joining fees required")) {
			return true;

		} else
			return false;
		
		}
	
	
//	public boolean verifyloyaltyJoiningFee() {
//		if (loyaltyJoiningFee.getText().equalsIgnoreCase("No Joining fees required")) {
//			return true;
//
//		} else
//			return false;
//		}
	 /**
	    * Description:- Click closeLoyaltyPopup button
	    * @param driver
	 * @throws InterruptedException 
	    */
	   public void handleLoyaltyProgramPoppedup() throws InterruptedException {
			
//		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		   try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/iv_close")));
			if(closeLoyaltyPopup.isDisplayed()) {
//		   Thread.sleep(4000);
		   driver.executeScript("mobile: clickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) closeLoyaltyPopup).getId()
				));
		   log.info("LoyaltyProgramPoppedup Notification window is displayed ");
			}
		}catch (Exception e){
			log.info("LoyaltyProgramPoppedup Notification window is not displayed ");	
		}
		   }
	   
	   
	   /**
		 * Description: verifyloyaltyJoinPassDialogTitle
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyloyaltyeatsureEliteTitleLocalityPage() {
			
			if (loyaltyeatsureEliteTitleLocalityPage.getText().trim().equalsIgnoreCase("EatSure Elite")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifyloyaltyJoinPassDialogTitle
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyloyaltyeatsureNoJoiningFeeBenefitTitleLocalityPage() {
			
			if (loyaltyeatsureNoJoiningFeeBenefitTitleLocalityPage.getText().trim().equalsIgnoreCase("No Joining fees required")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifyloyaltyeatsureNoJoiningFeeBenefitTitle
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyloyaltyeatsureDescriptionLocalityPage() {
			
			if (loyaltyeatsureDescriptionLocalityPage.getText().trim().equalsIgnoreCase("EatSure's Loyalty Program  Know more")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifyloyaltyeatsureJoinDescriptionLocalityPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyloyaltyeatsureJoinDescriptionLocalityPage() {
			
			if (loyaltyeatsureJoinDescriptionLocalityPage.getText().trim().equalsIgnoreCase("Earn SurePoints to join the Squad")) {
				return true;

			} else {
				return false;
			}
		}
		
		/**
		 * Description:- Click on Know more button under Loyalty section
		 * 
		 * @param driver
		 * @author vivek ranjan
		 * @date 16-Mar-2024
		 */
		public void clickLoyaltyCardSection() {
            try {
			loyaltyeatsureEliteTitleLocalityPage.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='EatSure Elite']")));
            log.info("Successfully clicked on Loyalty Card Section");
            } catch (Exception e) {
            log.info("Unable to click on Loyalty Card Section");
            	
            }
            }
		
		 /**
		 * Description: verifyHowitWorksLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyHowitWorksLoyaltyPage() {
			
			if (HowitWorksLoyaltyPage.getText().trim().equalsIgnoreCase("How it works?")) {
				return true;

			} else {
				return false;
			}
		}
		 /**
		 * Description: verifywhyJoinSureSquadeLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifywhyJoinSureSquadeLoyaltyPage() {
			
			if (whyJoinSureSquadeLoyaltyPage.getText().trim().equalsIgnoreCase("Why Join SureSquad?")) {
				return true;

			} else {
				return false;
			}
		}
            
		
		
		 /**
		 * Description: verifysureSquadLevelsLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifysureSquadLevelsLoyaltyPage() {
			
			if (sureSquadLevelsLoyaltyPage.getText().trim().equalsIgnoreCase("SureSquad Levels")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifysilverPassLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifysilverPassLoyaltyPage() {
			
			if (silverPassLoyaltyPage.getText().trim().equalsIgnoreCase("Silver pass")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifygoldPassLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifygoldPassLoyaltyPage() {
			
			if (goldPassLoyaltyPage.getText().trim().equalsIgnoreCase("Gold pass")) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifyjoinSilverPassButtonLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
		public boolean verifyjoinSilverPassButtonLoyaltyPage() {
			
			if (joinSilverPassButtonLoyaltyPage.isEnabled()) {
				return true;

			} else {
				return false;
			}
		}
		
		 /**
		 * Description: verifyFAQLoyaltyPage
		 * 
		 * @return
		 * @author vivek ranjan
		 * @date 16-Apr-2024
		 */
			public boolean verifyFAQLoyaltyPage() {
			
			if (FAQLoyaltyPage.getText().trim().equalsIgnoreCase("FAQ's")) {
				return true;

			} else {
				return false;
			}
		}

			/**
			 * Description: change to webview for Back button
			 * @author vivek ranjan
			 * @date 17th-April-2024
			 */
			
			public void clickonBackButtonLoyaltyPageWebView(AndroidDriver driver) throws InterruptedException {
				Set<String> contexts=driver.getContextHandles();
				System.out.println("Number of Context "+ contexts.size());
				for(String contextname:contexts) {
					log.info("Context name" + contextname);
				}
				driver.context("WEBVIEW_com.done.faasos.debug");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[starts-with(@class,'style__BackButton')]")));
				if (backButtonLoyaltyPageWEBVIEW.isDisplayed()) {
					Actions a = new Actions(driver);
					a.moveToElement(backButtonLoyaltyPageWEBVIEW).click().build().perform();
				
					driver.context("NATIVE_APP");
				}
			}
			
			/**
			 * Description:- This is created to click on "Back Button" to navigate to Locality Page
			 * @author vivek ranjan
			 * @param driver
			 * @return
			 * @date:- 15-Mar-2024
			 */
			public void clickonBackButtonLoyaltyPage(int index) {
				try {
					backButtonLoyaltyPage.get(index).click();

					log.info("Navigated to Locality Page from Loyalty page via Native APP ");

				} catch (NoSuchElementException e) {

					log.info("Dinot Navigated to Locality Page from Loyalty page via Native APP ");
				}
//				return driver;
			}
			
			

}
