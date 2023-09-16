package com.automation.pageobjects;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.Base.SetUp;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class AccountPage extends SetUp {

	
	//webdriver reference
	WebDriver driver;

	//account page constructor to set driver to this(Account page) and initilizing page factory
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//h2[@class='title text-center']/b")
	WebElement accountcreatedtext;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	WebElement AcceptAds;

	@FindBy(xpath = "//div[@class='shop-menu pull-right']//ul/li[last()]//a")
	WebElement username;

	
	/**
	 * 
	 * @param accntcreatedtxt
	 */
	public void verifyAccountCreatedText(String accntcreatedtxt) {
		Assert.assertEquals(StringUtils.chop(accountcreatedtext.getText()), accntcreatedtxt);

	}

	/**
	 *@param
	 *click continue button
	 */
	public void clickOnContinue() {
		continuebtn.click();

	}

	/**
	 * 
	 * @param logsinasusernametext
	 * username verification
	 */
	public void verifyLoggesInAsUsername(String logsinasusernametext) {
		username.isDisplayed();
			

	}

	/**
	 * 
	 * @param text
	 * Account created text verification
	 */
	public  void isVisibleAccountCreatedText(String text) {
		boolean istextvisible = accountcreatedtext.isDisplayed();
		Assert.assertTrue(istextvisible,"element is visible");
	}

}
