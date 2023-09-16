package com.automation.pageobjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.Base.SetUp;
import com.automation.utilities.DataSetters;
import com.automation.utilities.SeleniumUtils;
import com.mongodb.diagnostics.logging.Logger;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class HomePage<T> extends SetUp {

	//webdriver reference variable
	WebDriver driver;

	/**
	 * 
	 * @param driver
	 * constructor to load driver and pagefactory
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginlinktext;
	
	@FindBy(xpath = "//h2[text()='recommended items']")
	WebElement recitemstext;

	@FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-slide='next']")
	WebElement nextbtn;

	@FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-slide='prev']")
	WebElement prevbtn;

	@FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-product-id='5']")
	WebElement winteraddtocartbtn;

	@FindBy(xpath = "//div[@id='cartModal']//a[@href='/view_cart']")
	WebElement viewcartlinktext;
	
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productlinktext;
	
	
	@FindBy(xpath = "//div[@class='single-widget']//h2[text()='Subscription']")
	WebElement subscription;
	
	@FindBy(xpath = "//a[@id='scrollUp']/i")
	WebElement uparrowbtn;
	
	@FindBy(xpath = "//div[@class='item active']//h2[text()='Full-Fledged practice website for Automation Engineers']")
	WebElement fullflegedtext;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='2' and text()='Add to cart']")
	WebElement secondProduct;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='3' and text()='Add to cart']")
	WebElement thirdproduct;
	
	
	@FindBy(xpath = "//div[@id='dismiss-button']")
	WebElement adclosebtn;
	
	
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@href='/view_cart']")
	WebElement cartlinktext;

	/**
	 * @param title
	 * verify home page 
	 */
	public void verifyHomePage(T title) {
		String actual = driver.getTitle();
//		String expected = String.valueOf(title);
		T expected = title;

		if (actual.equals(expected)) {
			Assert.assertTrue(true);
			logger.info("Homepage is verified");
		} else {
			Assert.assertTrue(false);
			logger.info("Homepage is not verified");
		}

	}

	/**
	 *scrollToBottomOfPage 
	 */
	public void scrollToBottomOfPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", recitemstext);

	}

	/**
	 * verifyVisibilityofRecommendedItems
	 */
	public void verifyVisibiltyOfRecommendedItems() {
		if (recitemstext.isDisplayed()) {
			logger.info("RECOMMENDED ITEMS section is visible.");
		} else {
			logger.info("RECOMMENDED ITEMS section is not visible.");
		}

	}

	/**
	 * AddWinterProductToCart
	 */
	public void addWintertopProductToCart() {
		SeleniumUtils.click(winteraddtocartbtn);

	}

	/**
	 * ClickONViewCart
	 */
	public void clickOnViewCart() {
		SeleniumUtils.click(viewcartlinktext);

	}

	/**
	 * ValidateNavogationButtonIsVisible
	 */
	public void validateNavigationButtonIsVisible() {

		if (nextbtn.isDisplayed() && prevbtn.isDisplayed()) {
			System.out.println("Navigation buttons in recommended items section are visible.");
		} else {
			System.out.println("Navigation buttons in recommended items section are not visible.");
		}

	}

	/**
	 * VerifySubscriptionAvailbale
	 */
	public void verifySubscriptionAvailable() {
		if (subscription.isDisplayed()) {
			logger.info("subscription is visible");
		}
		else {
			logger.info("subscription is visible");
		}
		
	}

	/**
	 * ClickOnUpArrorBtn
	 */
	public void clickOnUpArrowBtn() {
		SeleniumUtils.click(uparrowbtn);
	}
	
	/**
	 * clickProduct
	 */
	public void clickProduct() {
		SeleniumUtils.click(productlinktext);
	}

	/**
	 * VerifyText
	 */
	public void verifyText() {
        if (fullflegedtext.isDisplayed()) {
            logger.info("Page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible.");
        } else {
        	logger.info("Page is not scrolled up or 'Full-Fledged practice website for Automation Engineers' text is not visible.");
        }
		
	}

	/**
	 * mouseHoveronSecondProduct
	 */
	public void mouseHoverOnSecondProduct() {
        
        SeleniumUtils.hoverOverElement(driver, secondProduct);
	}

	/**
	 * moseHoverOnthirdProduct
	 */
	public void mouseHoverOnThirdProduct() {
		Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform();
        thirdproduct.click();
        
		
	}

	
	/**
	 * closeAd
	 */
	public void closeAd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(adclosebtn));
	}

}
