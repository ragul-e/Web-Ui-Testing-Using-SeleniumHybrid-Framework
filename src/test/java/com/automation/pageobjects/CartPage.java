package com.automation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.Base.SetUp;


/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class CartPage extends SetUp {

	@FindBy(xpath = "//a[text()='Winter Top']")
	WebElement productname;

	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productlinktext;

	@FindBy(xpath = "//tr[@id='product-5']//a[@data-product-id='5']/i")
	WebElement crossmark;

	@FindBy(xpath = "//a[text()='Winter Top']")
	WebElement wintertopproduct;
	
	
	@FindBy(xpath = "//section[@id='do_action']//a[text()='Proceed To Checkout']")
	WebElement proceedtocheckoutbtn;
	
	//button[text()='Continue On Cart']
	@FindBy(xpath = "//button[text()='Continue On Cart']")
	WebElement continueoncart;
	
	@FindBy(xpath = "//a[@href='/login']/u[text()='Register / Login']")
	WebElement loginbeforeproceedtocheckout;
	

	//webdriver reference
	WebDriver driver;

	/**
	 * 
	 * @param driver
	 * constructor to load driver and pagefactory
	 */
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Product display validation
	 */
	public void verifyProductIsDisplayedInCart() {

		if (productname.isDisplayed()) {
			System.out.println("Product is displayed in the cart page.");
		} else {
			System.out.println("Product is not displayed in the cart page.");
		}

	}

	/**
	 * click product link text
	 */
	public void clickProductLinkText() {
		productlinktext.click();

	}

	/**
	 * remover product
	 */
	public void clickXmarkVerifyProductIsRemoved() {
		crossmark.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf(wintertopproduct));
		
		if (wait.until(ExpectedConditions.invisibilityOf(wintertopproduct))) {
			logger.info("successfully removed ");
		} else {
			logger.info("product is not  removed");

		}
	}

	/**
	 * click proceed to checkout button
	 */
	public void clickProceedToCheckOutBtn() {
		proceedtocheckoutbtn.click();
		
	}

	/**
	 * click sign in button
	 */
	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginbeforeproceedtocheckout));
		loginbeforeproceedtocheckout.click();
	}

}
