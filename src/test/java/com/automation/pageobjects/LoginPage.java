package com.automation.pageobjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.Base.SetUp;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class LoginPage extends SetUp {
	
     WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement loginlinktext;
	
	@FindBy(xpath = "//div[@class='signup-form']/h2")
	WebElement newusersignuptext;
	
	@FindBy(xpath  = "//input[@placeholder='Name']")
	WebElement signupnamefield;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signupemailfield;
	
	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signupbtn;
	
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement loginemail;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement logpass;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cartBtn;

	

	public void clickSignUp() {
		loginlinktext.click();
	}

	public <T> void verifyNewUserNameIsVisible(T newusername) {
		
		Assert.assertEquals(StringUtils.chop(newusersignuptext.getText()),newusername);
		
	
		
	}

	public <T> void enterSignUpName(T name) {
		signupnamefield.sendKeys(String.valueOf(name));
		
	}

	public <T> void enterSignupEmail(T email) {
		signupemailfield.sendKeys(String.valueOf(email));
		
	}

	public  void clickSignUpBtn() {
		signupbtn.click();
		
	}

	public <T> void enterEmail(T loguserEmail) {
		loginemail.sendKeys(String.valueOf(loguserEmail));
	}

	public <T> void enterPassword(T logPass2) {
		logpass.sendKeys(String.valueOf(logPass2));
		
	}

	public void clickLogin() {
		loginbtn.click();
		
	}

	public void clickCart() {
		cartBtn.click();
		
	}


}
