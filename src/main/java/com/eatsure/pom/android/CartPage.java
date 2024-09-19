package com.eatsure.pom.android;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import io.appium.java_client.TouchAction;

import com.eatsure.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class CartPage extends AndroidActions {
	AndroidDriver driver;
	public static final Logger log = LogManager.getLogger(CartPage.class.getName());
	public static WebDriverWait wait;

	public CartPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivBackButton")
	private WebElement cartBackButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/title")
	private WebElement cartTitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCartSearch")
	private WebElement searchCartPage;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCartTitleHelp")
	private WebElement helpCart;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_selected_mode")
	public WebElement navigationBar;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_mode_slots")
	private WebElement slotplace;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductBrandName")
	private List<WebElement> BrandName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/constraintProceedPay")
	private WebElement ProceedpayButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_continue")
	private WebElement Continuepay;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvProductName")
	private List<WebElement> productname;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCurrentQuantity")
	private WebElement currentQuantity;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvAddProduct")
	private WebElement quantityIncrease;

	@AndroidFindBy(id = "com.done.faasos.debug:id/constraintProceedPay")
	private WebElement reapeat;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvEditCustomisation")
	private WebElement edit;

	@AndroidFindBy(id = "com.done.faasos.debug:id/product_info_container_cardview")
	private WebElement productContainer;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_product_customize_header")
	private WebElement productCustomizationHeader;

	@AndroidFindBy(id = "com.done.faasos.debug:id/buttonAddItem")
	private WebElement additem;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_cooking_inst")
	private WebElement cookingInst;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_cook_inst")
	private WebElement cookingInsticon;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_cooking_inst_arrow")
	private WebElement cookingInstArrow;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_cooking_instruction")
	private WebElement cookingInsttitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/edt_cooking_inst")
	private WebElement inputInstBox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_save_cook_inst")
	private WebElement instSaveButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCartAddressChange")
	private WebElement addressChange;

	@AndroidFindBy(id = "com.done.faasos.debug:id/choose_delivery_text")
	private WebElement addressListHeader;

	@AndroidFindBy(id = "//android.widget.TextView[@text='Near by Location']")
	private WebElement nearByAddress;

	@AndroidFindBy(id = "//android.widget.TextView[@text='Other Location']")
	private WebElement otherlocation;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_add_address")
	private WebElement addnewAddessButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvAddAddressPayment")
	private WebElement addAdessCart;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_map_locate_me")
	private WebElement currentLOcation;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_search")
	private WebElement searchLOcation;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_confirm_location")
	private WebElement conformhLOcation;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvLocalityName")
	private WebElement localityName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_address_detail_locality_name")
	private WebElement deliverylocalityName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_address_detail_change")
	private WebElement addressdetalisChange;

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_flat_name")
	private WebElement flatName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_apartment")
	private WebElement apartmentName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_how_reach")
	private WebElement landmark;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvHome")
	private WebElement home;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvWork")
	private WebElement work;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvOther")
	private WebElement others;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_save_loc")
	private WebElement saveAddressButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/et_other_tag")
	private WebElement othersTextBox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvDeliveringAt")
	private WebElement deliverTo;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvSelectedAddressIcon")
	private WebElement selectAddressTag;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_address_select")
	private WebElement addressSelect;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_cart_coupon_widget_title")
	private WebElement couponBoxHeader;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_coupon_widget_title")
	private WebElement couponBoxtitle;
    //ID of "View all" depends on A/B experiment
//	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_coupon_widget_view_all")
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_cart_coupon_widget_view_all")
	private WebElement viewAll;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Coupons for you']")
	private WebElement couponListHeader;

	@AndroidFindBy(id = "com.done.faasos.debug:id/etCoupon")
	private WebElement couponInputBox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_apply_coupon_code")
	private WebElement applyInputBox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_coupon_code_error_msg")
	private WebElement couponErrorMessge;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvApply")
	private WebElement couponApply;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCoupon")
	private WebElement applyCouponName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCouponDesc")
	private WebElement couponDiscount;

	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	private WebElement couponapplyToastMessage;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_coupon_widget_subtitle")
	private WebElement afterapplyCoupon;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_coupon_widget_remove")
	private WebElement removecoupon;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sure_squad_title_center")
	private WebElement popupCouponName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/layout_sp_cart_active")
	private WebElement suresquardSection;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvBillTitle")
	private WebElement billSummaryTittle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Basket Total (Excl.Taxes)']")
	private WebElement baskettotalText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Taxes & Charges    ']")
	private WebElement taxText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delivery fees ']")
	private WebElement deliveryFeeText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/rvBillDetails")
	private WebElement billbox;

	@AndroidFindBy(id = "com.done.faasos.debug:id/new_tvOfferApplied")
	private WebElement coupontag;

	@AndroidFindBy(id = "com.done.faasos.debug:id/new_tv_cart_price")
	private List<WebElement> productPrice;

	@AndroidFindBy(id = "com.done.faasos.debug:id/layoutBillDetails")
	private WebElement billDetailsLayout;

	@AndroidFindBy(id = "com.done.faasos.debug:id/layout_sp_cart_active")
	private WebElement sureSquardLayout;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sure_squad_title_left")
	private WebElement sureSquardtitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sure_pass_free_del")
	private WebElement freedeliveryText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sure_pass_free_dish")
	private WebElement freedishText;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_surepass_es_logo")
	private WebElement sureSquardLogo;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_fp_product_name")
	private WebElement freedishProductName;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_fp_display_price")
	private WebElement freedishProductprice;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_fp_spash_price")
	private WebElement freedishProductSlashprice;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_sp_fp_change_upgrade_dish")
	private WebElement changeupgrade;

	@AndroidFindBy(id = "com.done.faasos.debug:id/btn_sp_fp_claim")
	private WebElement addbutton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvLocStateTitle")
	private WebElement freePageTitle;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvLockStateDescription")
	private WebElement freePageDescription;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvCartTotalPrice")
	private WebElement cartTotalPrice;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvfp_benefi_tag")
	private WebElement benefittagforfreeDish;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvBenefitTag")
	private WebElement benefittagforfreeDelivery;

	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_sp_fp_add_items")
	private WebElement shopmore;

	@AndroidFindBy(id = "com.done.faasos.debug:id/ivFreeProductImage")
	private List<WebElement> freeCollection;

	@AndroidFindBy(id = "com.done.faasos.debug:id/rbFreeProduct")
	private List<WebElement> radioButton;

	@AndroidFindBy(id = "com.done.faasos.debug:id/tvFreeProductName")
	private List<WebElement> freeProduct;
	
	@AndroidFindBy(id = "tvSaveSelection")
	private WebElement continueButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTextSavingsInfobar")
	private WebElement savingInfoBar;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTextSavingsInfobar")
	private WebElement savingTextBill;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTotalSavingValue")
	private WebElement savingamount;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tax_title")
	private WebElement savingpopUpTitle;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/iv_close")
	private WebElement close;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tvTaxPrice")
	private List<WebElement> savingPrices;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_have_coupon_code")
	private WebElement haveCodeButton;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/tv_coupons_header")
	private WebElement couponHeader;
	
	@AndroidFindBy(id = "com.done.faasos.debug:id/edt_coupon_code")
	private WebElement couponInputBoxNew;
	
	
	public String couponInputBoxText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/edt_coupon_code")));
		return couponInputBoxNew.getText();
	}
	
	
	public int totalSavingCal() {
		int sum=0;
		for(int i=0;i<savingPrices.size();i++) {
			String text=savingPrices.get(i).getText().replace("\u20b9", "").toString().trim();
			int SavingAmount = Integer.parseInt(text);
			sum=sum+SavingAmount;
			}
		return sum;
	}
	
	
	public int totalSavingINpopUp() {
		String text=savingamount.getText().replace("\u20b9", "").toString().trim();
		int SavingAmount = Integer.parseInt(text);
		return SavingAmount;
	}
	
	
	public String topSavingOpen() {
		savingInfoBar.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tax_title")));
		return savingpopUpTitle.getText();
	}
	
	public void close() {
		close.click();
	}
	
	public String buttosavingopen() {
		savingTextBill.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tax_title")));
		return savingpopUpTitle.getText();
	}
	
	public int saving() {
	String text=savingamount.getText().replace("\u20b9", "").toString().trim();
	int SavingAmount = Integer.parseInt(text);
	return SavingAmount;
	}
	
	public String savingText() {
		savingTextBill.isDisplayed();
		return savingTextBill.getText();
	}
	
	public int savingInfoBar() {
		String text=savingInfoBar.getText().replace("\u20b9", "").toString().trim();
		int SavingAmount = Integer.parseInt(text.split(" ")[0]);
		return SavingAmount;
	}
	
	
	public String afterCangeProductName() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/btn_sp_fp_claim")));
		Thread.sleep(3000);
		return freedishProductName.getText().trim();
	}
	public void continueButton() {
		continueButton.click();
	}

	public String selectFreeProduct() throws InterruptedException {

		String productname2 = "";
		for (int i = 0; i < radioButton.size(); i++) {
			if (!Boolean.parseBoolean(radioButton.get(i).getAttribute("checked"))) { // freeProduct.get(i).getText();
				radioButton.get(i).click();
				Thread.sleep(2000);
				productname2 = freeProduct.get(i).getText();
				break;

			}else {
				productname2=freeProduct.get(i).getText();
			}
		}
		return productname2;
	}

	public void changClick() {
		changeupgrade.click();
	}

	public String freeDishPageTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvLocStateTitle")));
		return freePageTitle.getText();
	}

	public boolean freeDescription() {
		if (freePageDescription.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: Verify the cart header
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public boolean cartHeaderContain() {

		if (cartBackButton.isDisplayed() && cartTitle.isDisplayed() && searchCartPage.isDisplayed()
				&& helpCart.isDisplayed()) {
			return true;
		}
		return false;

	}

	/**
	 * Description: verify the navigation bar
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String navigation() {
		if (navigationBar.isDisplayed()) {
			if (slotplace.isDisplayed()) {
				String selectedSlot = slotplace.getText();
				return selectedSlot;
			}
		}
		return null;
	}

	/**
	 * Description: Calculate the brand count
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public int brandName() {
		for (int i = 0; i < BrandName.size(); i++) {
			String brandName = BrandName.get(i).getText();
			log.info(brandName + ",");

		}
		int TotalBrandCount = BrandName.size();
		return TotalBrandCount;

	}

	/**
	 * Description: click on proceed to pay button
	 * 
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void paybutton() {
		if (ProceedpayButton.isDisplayed()) {
			ProceedpayButton.click();
			try {
				Continuepay.click();
			} catch (Exception e) {
				log.info("there is not bxgx product or already allied");
			}
		}
	}

	/**
	 * Description: product count
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public int productCount() {
		int totalProduct = productname.size();
		return totalProduct;

	}

	/**
	 * Description: verify the product current quantity
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public int currentQantity() {
		String quantity = currentQuantity.getText();
		int firstQuantity = Integer.parseInt(quantity);
		return firstQuantity;
	}

	/**
	 * Description: quantity increase
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public int increaseQuantity() throws InterruptedException {
		quantityIncrease.isDisplayed();
		{
			quantityIncrease.click();
			Thread.sleep(2000);
			try {
			reapeat.click();
			log.info("Normal Product with custemization giot added");
			} catch (Exception e) {
				log.info("Normal Product without custemization giot added");
			}
		}

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvCurrentQuantity")));
		String quantity = currentQuantity.getText();
		int Quantity = Integer.parseInt(quantity);
		return Quantity;
	}

	/**
	 * Description: verify the product edit option
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void editProduct() {
		try {
			if (edit.isDisplayed()) {

				String Productname = productContainer.findElement(By.id("com.done.faasos.debug:id/tvProductName"))
						.getText();
				edit.click();
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/clCustomisationItemList")));
				WebElement customizationBox = driver
						.findElement(By.id("com.done.faasos.debug:id/clCustomisationItemList"));
				String custoicustomizationBox = customizationBox
						.findElement(By.id("com.done.faasos.debug:id/tvProductName")).getText();

				SoftAssert as = new SoftAssert();
//				as.assertEquals(Productname, custoicustomizationBox, "Customiztion product name not right");
//				as.assertAll();
				productCustomizationHeader.isDisplayed();
				additem.click();
				log.info("Customization box show the right product name with right customization");
			}
		} catch (Exception e) {
			log.info("no product has customization ");
		}
	}

	/**
	 * Description: verify the cooking instruction box
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String instruction() {
		if (cookingInst.isDisplayed() && cookingInsticon.isDisplayed() && cookingInstArrow.isDisplayed()) {
			String textBox = cookingInst.getText();
			cookingInst.click();
			return textBox;
		}
		return "instrustion box not display";
	}

	/**
	 * Description: input the cooking instruction
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String instructionInputBox() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_cooking_instruction")));
		String header = cookingInsttitle.getText();
		inputInstBox.sendKeys("Automation Test order");
		instSaveButton.click();
		return header;

	}

	/**
	 * Description: verify the instruction added successfully
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public String afterAddInst() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/iv_cooking_inst_arrow")));
		String textBox = cookingInst.getText();
		return textBox;
	}

	/**
	 * Description: add or change address button click
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void address() {
		try {
			addressChange.isDisplayed();
			addressChange.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/choose_delivery_text")));
			String addressText = addressListHeader.getText();

			SoftAssert as = new SoftAssert();
			as.assertEquals(addressText, "Select Delivery Address", "address list page don't show right Header");
			as.assertAll();
			log.info(addressText);
			// nearByAddress.isDisplayed();
			// otherlocation.isDisplayed();
			addnewAddessButton.click();
			log.info("User already has address");
		} catch (Exception e) {
			addAdessCart.isDisplayed();
			addAdessCart.click();
			log.info("This is new user don't have address");
		}
	}

	/**
	 * Description: verify the conform location page
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String conformLocation() throws InterruptedException {
		Thread.sleep(3000);
		// if(currentLOcation.isDisplayed() && searchLOcation.isDisplayed() &&
		// conformhLOcation.isDisplayed()) {
		String LocalityName = localityName.getText();
		return LocalityName;

	}

	/**
	 * Description: conform location button click
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void clickConformLOcation() throws InterruptedException {
		Thread.sleep(3000);
		try {
		conformhLOcation.click();
		} catch (Exception e) {
			log.info("Address details will help us to deliver at your location-- page not displayed");
		}
	}

	/**
	 * Description: verify the locality name
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public String addaddresspagelocalityName() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_address_detail_locality_name")));
		addressdetalisChange.isDisplayed();
		String loalityName = deliverylocalityName.getText();
		return loalityName;
	}

	/**
	 * Description: put the new address
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void addressAdded() throws InterruptedException {
		flatName.sendKeys("Test Address");
		apartmentName.sendKeys("Automation");
		SoftAssert as = new SoftAssert();
		as.assertEquals(saveAddressButton.isEnabled(), true);
		as.assertAll();
		landmark.sendKeys("Automation");
		if (home.isDisplayed() && work.isDisplayed() && others.isDisplayed()) {
			others.click();
			Thread.sleep(2000);
			othersTextBox.sendKeys("Eatsure");
			saveAddressButton.click();
		}
		// saveAddressButton.click();
	}

	/**
	 * Description: verify the new address added successfully
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public String verifyAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tvDeliveringAt")));
		String text = selectAddressTag.getText();
		return text;
	}

	/**
	 * Description: select existing address
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public void selectAddress() {
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/iv_address_select")));
			addressSelect.click();
		} catch (Exception e) {

		}

	}

	/**
	 * Description: verify the coupon box header
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String couponboxHeader() {
		return couponBoxHeader.getText();
	}

	/**
	 * Description: verify coupon box title
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String couponboxtitle() throws InterruptedException {
		Thread.sleep(3000);
		return couponBoxtitle.getText();
	}

	/**
	 * Description: click on view all button for coupon
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void view() {
		viewAll.isEnabled();
		viewAll.click();
	}

	/**
	 * Description: coupon list page header verify
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String couponHeader() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_coupons_header")));
		haveCodeButton.isDisplayed();
		return couponHeader.getText();
	}

	/**
	 * Description: verify the input box apply button
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public boolean apply() {
		return applyInputBox.isEnabled();
	}

	/**
	 * Description: input box put unknown coupon name
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public boolean afterInput() {
		couponInputBoxNew.sendKeys("Eatsure");
		return applyInputBox.isEnabled();
	}

	/**
	 * Description: verify the coupon error message
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public boolean couponError() {
		applyInputBox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.done.faasos.debug:id/tv_coupon_code_error_msg")));
		return couponErrorMessge.isDisplayed();
	}

	/**
	 * Description: verify the coupon name
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public String applyCouponName() {
		String couponName = "";
		try {
			if (couponApply.isEnabled()) {
				couponName = applyCouponName.getText();

			}
		} catch (Exception e) {
			log.info("no applicable coupon is there");
		}
		return couponName;
	}

	/**
	 * Description:get the coupon discoutn values
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public int applydiscount() {
		String discountText = couponDiscount.getText().replace("\u20b9", "").toString().trim();
		String text = discountText.split(" ")[1];
		int couponAmount = Integer.parseInt(text.split(" ")[0]);
		return couponAmount;

	}

	/**
	 * Description: apply coupon button
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public void applycoupon() {
		try{couponApply.isEnabled();
		couponApply.click();
		log.info("Successfully apply coupon " +cuponapplyMessage());
		}catch(Exception e) {
			cartBackButton.click();
			log.info("coupon not appicable");
			
		}
	}

	/**
	 * Description: coupon successfully apply toast msg
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */
	public String cuponapplyMessage() {
		String msg = couponapplyToastMessage.getAttribute("name");
		return msg;
	}

	/**
	 * Description: after apply coupon saving price checking
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public int cartcouponprice() {
		String text = afterapplyCoupon.getText().replace("\u20b9", "").toString().trim();
		int couponAmount = Integer.parseInt(text.split(" ")[0]);
		return couponAmount;
	}

	/**
	 * Description: verify successful pop up coupon name
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 10th-April-2024
	 */

	public String popupCoupon() {
		return popupCouponName.getText();
	}

	/**
	 * Description: verify coupon tag after apply section
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public boolean couponTag() {
		return coupontag.isDisplayed();

	}

	/**
	 * Description: verify bill details section
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public String biilHeader() {
		return billSummaryTittle.getText();
	}

	/**
	 * Description: verify bill details 3 text option
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public boolean billfields() {
		if (baskettotalText.isDisplayed() && taxText.isDisplayed() && deliveryFeeText.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Description: get the basketTotal price
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public int basketTotal() {

		WebElement priceText = billbox.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvTaxPrice'])[1]"));
		String text = priceText.getText().replace("\u20b9", "").toString().trim();
		int price = Integer.parseInt(text);
		return price;

	}

	/**
	 * Description: get the products price sum
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public int productSum() {
		int sum = 0;
		for (int i = 0; i < productPrice.size(); i++) {
			String priceText = productPrice.get(i).getText().replace("\u20b9", "").toString().trim();
			int price = Integer.parseInt(priceText);
			sum = sum + price;
		}
		return sum;
	}

	/**
	 * Description: calculate the grand total
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public int calGrandTotal() {
		WebElement priceText = billbox.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvTaxPrice'])[1]"));
		String text = priceText.getText().replace("\u20b9", "").toString().trim();
		int basketprice = Integer.parseInt(text);
		log.info("basketTotal " + basketprice);

		WebElement taxText = billbox.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvTaxPrice'])[2]"));
		String text1 = taxText.getText().replace("\u20b9", "").toString().trim();
		int Taxprice = Integer.parseInt(text1);
		log.info("tax " + Taxprice);

		WebElement deliveryText = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.done.faasos.debug:id/tvTaxPrice'])[3]"));
		String text2 = deliveryText.getText().replace("\u20b9", "").toString().trim();
		int delievrytprice = Integer.parseInt(text2);
		log.info("delivery fee" + delievrytprice);

		int totalSum = basketprice + Taxprice + delievrytprice;
		return totalSum;
	}

	public void scroll() {

		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) suresquardSection).getId(), "direction", "down",
						"speed", 500));

	}

	public void scroll1() {

		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) navigationBar).getId(), "direction", "up", "speed",
						500));

	}

	/**
	 * Description: scroll upto end
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public void scrollVertical() {
		TouchAction touchAction = new TouchAction(driver);

		// Define the start and end points
		PointOption startPoint = PointOption.point(0, (int) (driver.manage().window().getSize().height * 0.8));
		PointOption endPoint = PointOption.point(0, (int) (driver.manage().window().getSize().height * 0.2));

		// Perform the press action
		touchAction.press(startPoint).moveTo(endPoint).release().perform();

	}

	/**
	 * Description: scroll upto top
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public void scrollUpInFrameB() {
		// Perform scroll-up action on the entire page until elements in Frame B become
		// visible
		while (!areFrameBElementsVisible()) {
			scrollUp();
		}
	}

	public void scrollUp() {
		// Perform scroll-up action on the entire page
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = (int) (size.getHeight() * 0.8);
		int endY = (int) (size.getHeight() * 0.2);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
				.perform();
	}

	public boolean areFrameBElementsVisible() {
		try {
			// Check if any elements within Frame B are visible
			// Replace "frameBElementLocator" with the appropriate locator for an element
			// within Frame B
			return driver.findElement(By.id("com.done.faasos.debug:id/tv_selected_mode")).isDisplayed();
		} catch (NoSuchElementException e) {
			// Frame B elements are not yet visible
			return false;
		}
	}

	/**
	 * Description: verify sureSquard section
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public String sureSquard() {
		try {
			sureSquardLayout.isDisplayed();
			return "this is a loyalty user";

		} catch (Exception e) {
			return "This is non loyalty user";
		}

	}

	/**
	 * Description: verify sureSquard Header
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public String freedishHeader() {
		return sureSquardtitle.getText();
	}

	/**
	 * Description: verify sureSquard design
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public boolean designFreeDishBox() {
		if (freedeliveryText.isDisplayed() && freedishText.isDisplayed() && sureSquardLogo.isDisplayed()) {
			return true;

		}
		return false;
	}

	/**
	 * Description: get the free product name
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public String freeProductName() {
		return freedishProductName.getText();
	}

	/**
	 * Description: get the free product price
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public int productPrice() {
		String text = freedishProductprice.getText().replace("\u20b9", "").toString().trim();
		int freeprice = Integer.parseInt(text);
		return freeprice;
	}

	/**
	 * Description: get the free product slash price
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public int productSlashPrice() {
		String text = freedishProductSlashprice.getText().replace("\u20b9", "").toString().trim();
		int freeprice = Integer.parseInt(text);
		return freeprice;
	}

	/**
	 * Description: click and verify add button
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */
	public String clickadd() {
		

		 if (cartTotal() > 350) { 
		        if (changeupgrade.isDisplayed() && addbutton.isDisplayed()) {
		            addbutton.click();
		            log.info("Both the benefits are applicable");
		            return "Both the benefits are applicable";
		
            }
		}else if(productSum()>199 && productSum()<350)
		{
			benefittagforfreeDish.isDisplayed();
				if (benefittagforfreeDish.getText().equalsIgnoreCase("You are missing out on Free Dish")) {
            shopmore.isDisplayed();
            log.info("Free delivery applied but free dish not applied");
            return "Free delivery applied but free dish not applied";
        }else{
        	if(benefittagforfreeDelivery.getText().equalsIgnoreCase("You are missing out on benefits")){
                shopmore.isDisplayed();
                log.info("Free delivery and free dish both are not applied");
                return "Free delivery and free dish both are not applied";
        	}
        }
		}
		return "Free dish section not coming";


}

	/**
	 * Description: verify the remove button
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public boolean removeButton() {
		log.info(addbutton.getText());
		if (addbutton.getText().equalsIgnoreCase("Remove")) {
			return true;
		}
		return false;
	}

	/**
	 * Description: get the cart total price
	 * 
	 * @param stagingNumber
	 * @author Soumya Adhikary
	 * @date 11th-April-2024
	 */

	public int cartTotal() {
		String text = cartTotalPrice.getText().replace("\u20b9", "").toString().trim();
		int cartPrice = Integer.parseInt(text);
		return cartPrice;
	}
	
	public void haveCodeBUttonClick() {
		haveCodeButton.click();
	}

}
