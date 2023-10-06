package com.automation.pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automation.testcases.SetUp;
import com.automation.userdefinedexception.TextExist;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class SignUpPage extends SetUp {

	/**
	 * drvier reference variable
	 */
	WebDriver driver;

	/**
 	 * @param driver
 	 * constructor to load driver and pagefactory
 	 */
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='login-form']/h2/b[text()='Enter Account Information']")
	WebElement enteraccountinfotext;

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement titleradiobtn;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;

	@FindBy(xpath = "//select[@id='days']")
	WebElement daydropdown;

	@FindBy(xpath = "//select[@id='months']")
	WebElement monthdropdown;

	@FindBy(xpath = "//select[@id='years']")
	WebElement yeardropdown;

	@FindBy(xpath = "//form[@action='/signup']/h2/b[text()='Address Information']")
	WebElement addressinfotext;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstnamefield;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastnamefield;

	@FindBy(xpath = "//input[@id='company']")
	WebElement companyfield;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1field;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2field;

	@FindBy(xpath = "//select[@id='country']")
	WebElement counrtydropdown;

	@FindBy(xpath = "//input[@id='state']")
	WebElement statefield;

	@FindBy(xpath = "//input[@id='city']")
	WebElement cityfield;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcodefield;

	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobilenumberfield;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createaccountbtn;

	/**
	 * 
	 * @param enteraccntnametxt
	 * validate accountinfotext
	 */
	public void validateEnterAccountInformtionIsVisible(String enteraccntnametxt) {
//		Assert.assertTrue(enteraccountinfotext.isDisplayed());

		if (enteraccountinfotext.isDisplayed()) {
			System.out.println("Enter account information is visible");
			logger.info("Enter account information is visible");
		} else {
			logger.info("Enter account information is not  visible");
		}
		
		try {
		if(enteraccountinfotext.getText().equals(enteraccntnametxt)) {
			Assert.assertTrue(enteraccountinfotext.isDisplayed());
			logger.info("Enter account information is visible");
			
		}
		else {
			throw new TextExist(" text is not visible ");
		}
		}catch (TextExist e) {
			e.printStackTrace();
		}

	}

	/**
	 * chooseTitle
	 */
	public void chooseTitle() {
		titleradiobtn.click();
	}

	/**
	 * 
	 * @param <T>
	 * passord
	 * @param password
	 * enterpassword
	 */
	public <T> void enterPassword(T password) {
		passwordfield.sendKeys(String.valueOf(password));

	}

	/**
	 * 
	 * @param dob
	 * enterDOB
	 */
	public  void chooseDateOfBirth(String dob) {

//		dob

//		String dateStr = "01-Dec-2022";
	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
	    
	    LocalDate date = LocalDate.parse(dob, inputFormatter);
	    
	    int day = date.getDayOfMonth();
	    String month = date.format(monthFormatter);
	    int year = date.getYear();

		Select dayselect = new Select(daydropdown);
		dayselect.selectByVisibleText(String.valueOf(day));
		Select monthselect = new Select(monthdropdown);
		monthselect.selectByVisibleText(month);
		Select yearsselect = new Select(yeardropdown);
		yearsselect.selectByVisibleText(String.valueOf(year));

	}

	/**
	 * 
	 * @param <T>
	 * addressinfo
	 * @param addressinfo
	 * ProvideAddress
	 */
	public <T> void verfiyAddressInfoIsVisible(T addressinfo) {
		
		if(addressinfotext.isDisplayed()) {
			Assert.assertEquals(addressinfotext.getText(), String.valueOf(addressinfo));
			logger.info("address information text is visible");
		}
		else {
			logger.info("address information text is not visible");
		}

	}

	/**
	 * 
	 * @param <T>
	 * firstname
	 * @param signfirstname
	 * EnterFirstname
	 */
	public <T> void firstName(T signfirstname) {
		firstnamefield.sendKeys(String.valueOf(signfirstname));

	}

	/**
	 * 
	 * @param <T>
	 * Lastname
	 * @param lastname
	 * EnterLastname
	 */
	public <T> void lastname(T lastname) {
		lastnamefield.sendKeys(String.valueOf(lastname));

	}
	
	/**
	 * 
	 * @param <T>
	 * CompanyName
	 * @param compname
	 * EnterCompanyName
	 */
	public <T> void companyName(T compname) {
		companyfield.sendKeys(String.valueOf(compname));

	}

	/**
	 * 
	 * @param <T>
	 * AddressOne
	 * @param addone
	 * EnterAdddressOne
	 */
	public <T> void addressOne(T addone) {
		address1field.sendKeys(String.valueOf(addone));

	}

	/**
	 * 
	 * @param <T>
	 * AddressTwo
	 * @param addtwo
	 * EnterAddressTwo
	 */
	public <T> void addressTwo(T addtwo) {
		address2field.sendKeys(String.valueOf(addtwo));

	}

	/**
	 * 
	 * @param <T>
	 * selectCountry
	 * @param countryname
	 * countryname
	 * 
	 */
	public <T> void selectCountry(T countryname) {
		Select country = new Select(counrtydropdown);
		country.selectByVisibleText(String.valueOf(countryname));

	}

	/**
	 * 
	 * @param <T>
	 * StatName
	 * @param statename
	 * EnterState
	 */
	public <T> void enterState(T statename) {
		statefield.sendKeys(String.valueOf(statename));

	}

	/**
	 * 
	 * @param cityname
	 * EnterCity
	 */
	public void enterCity(String cityname) {
		cityfield.sendKeys(cityname);

	}

	/**
	 * 
	 * @param <T>
	 * pincode
	 * @param zippin
	 * enterZipcode
	 */
	public <T> void enterZipcode(T zippin) {
		zipcodefield.sendKeys(String.valueOf(zippin));

	}

	/**
	 * 
	 * @param <T>
	 * MobileNumber
	 * @param mobnum
	 * EnterMobNum
	 */
	public <T> void enterMobileNumber(T mobnum) {
		mobilenumberfield.sendKeys(String.valueOf(mobnum));
	}

	/**
	 * clickCreateAccountBtn
	 * 
	 */
	public  void clickCreateAccountBtn() {
		createaccountbtn.click();

	}

	/**
	 * 
	 * @param doBirth
	 * EnterBirthDate
	 * @param doMon
	 * EnterBirthMonth
	 * @param doYear
	 * EnterBirthYear
	 * SelectDobInDropDown
	 */
	public void chooseDateOfBirthParams(String doBirth, String doMon, String doYear) {
		Select dayselect = new Select(daydropdown);
		dayselect.selectByVisibleText(doBirth);
		Select monthselect = new Select(monthdropdown);
		monthselect.selectByVisibleText(doMon);
		Select yearsselect = new Select(yeardropdown);
		yearsselect.selectByVisibleText(doYear);
		
	}

}
