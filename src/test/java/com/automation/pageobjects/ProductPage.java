package com.automation.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.Base.SetUp;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class ProductPage extends SetUp{

	/**
	 * drvier reference variable
	 */
	WebDriver driver;

	/**
 	 * @param driver
 	 * constructor to load driver and pagefactory
 	 */
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search Product']")
	WebElement searchbox;

	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement searchbtn;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continuebtn;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='1']")
	WebElement bluetop;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='6']")
	WebElement summerwhitetop;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='11']")
	WebElement sleeveprintedtop;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='14']")
	WebElement fullsleevetopcheery;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='7']")
	WebElement madametop;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='8']")
	WebElement fancygreentop;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='30']")
	WebElement polotshirt;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='37']")
	WebElement slimfitjean;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='31']")
	WebElement greentshirt;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='30']")
	WebElement PureCottonVNeckTShirt;

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='35']")
	WebElement regularfitjean;

	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cartBtn;

	@FindBy(xpath = "//tr[@id='product-6']//td/a[@class='cart_quantity_delete']")
	WebElement cartremove;

	@FindBy(xpath = "//tr[@id='product-5']//td/a[@class='cart_quantity_delete']/i")
	WebElement cartremovemark;

	@FindBy(xpath = "//a[text()='Winter Top']")
	WebElement deleteproduct;

	/**
	 * 
	 * @param <T>
	 * @param productone
	 */
	public <T extends CharSequence> void addProductOne(T productone) {
		searchbox.clear();
		searchbox.sendKeys(productone);
		bluetop.click();
		continuebtn.click();
	}

	/**
	 * 
	 * @param <T>
	 * @param producttwo
	 */
	public <T extends CharSequence> void addProductTwo(T producttwo) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(producttwo));
		bluetop.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productthree
	 */
	public <T> void addProductThree(T productthree) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productthree));
		sleeveprintedtop.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productfour
	 */
	public <T> void addProductFour(T productfour) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productfour));
		fullsleevetopcheery.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productfive
	 */
	public <T> void addProductFive(T productfive) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productfive));
		madametop.click();
		continuebtn.click();
	}

	/**
	 * 
	 * @param <T>
	 * @param productsix
	 */
	public <T> void addProductSix(T productsix) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productsix));
		fancygreentop.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productseven
	 */
	public <T> void addProductSeven(T productseven) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productseven));
		polotshirt.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param producteight
	 */
	public <T> void addProductEight(T producteight) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(producteight));
		slimfitjean.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productnine
	 */
	public <T> void addProductNine(T productnine) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productnine));
		greentshirt.click();
		continuebtn.click();

	}

	/**
	 * 
	 * @param <T>
	 * @param productten
	 */
	public <T> void addProductTen(T productten) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productten));
		regularfitjean.click();
		continuebtn.click();
	}

	/**
	 * 
	 * @param <T>
	 * @param productEleven
	 */
	public <T> void addProductEleven(T productEleven) {
		searchbox.clear();
		searchbox.sendKeys(String.valueOf(productEleven));
		PureCottonVNeckTShirt.click();
		continuebtn.click();

	}

	/**
	 * clickCartAndVerifyIsDisplayed
	 */
	public  void clickCartAndVerifyIsDisplayed() {
		cartBtn.click();
		String actualcarttitle = driver.getTitle();
		String exceptedcarttitle = "Automation Exercise - Checkout";
		Assert.assertEquals(actualcarttitle, exceptedcarttitle);
		if (actualcarttitle.equals(exceptedcarttitle)) {
			logger.info("cart page is displayed successfully");
			Assert.assertTrue(true);
		} else {
			logger.info("cart page is not displayed successfully");
			Assert.assertTrue(false);
		}

	}
	
	/**
	 * clickCartLinkTest
	 */
	public void clickCartLinkTest() {
		cartBtn.click();
	}

	/**
	 * clickOnContinueShopping
	 */
	public void clickOnContinueShopping() {
		continuebtn.click();
	}

}
