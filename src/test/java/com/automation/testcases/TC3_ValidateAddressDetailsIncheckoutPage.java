package com.automation.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageobjects.CheckoutPage;
import com.automation.utilities.Constant;
import com.automation.utilities.DataSetters;
import com.automation.utilities.ExUtils;
import com.automation.utilities.ReadProperties;
import com.automation.utilities.TC1_Datas;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class TC3_ValidateAddressDetailsIncheckoutPage extends SetUp{
	
	
//	retryAnalyzer = RetryTest.class
	@Test(groups = "regression")
	public void validateAddressDetailsInCheckoutPage() {
		ReadProperties readfile = new ReadProperties();

		homepage.verifyHomePage("Automation Exercise");
		loginpage.clickSignUp();
		
		loginpage.enterSignUpName(readfile.signUpName());
		loginpage.enterSignupEmail(readfile.signupemail());
		loginpage.clickSignUpBtn();
		signuppage.chooseTitle();
		signuppage.enterPassword(data.getEnterPassword());
		
		logger.info("print enter password "+TC1_Datas.dataTcOne().getEnterPassword());
		signuppage.chooseDateOfBirthParams(readfile.doBirth(),readfile.doMon(),readfile.doYear());
		signuppage.verfiyAddressInfoIsVisible(readfile.addressInfoTxt());
		signuppage.firstName(readfile.firstName());
		signuppage.lastname(readfile.lastname());
		signuppage.companyName(readfile.compName());
		signuppage.addressOne(readfile.addressOne());
		signuppage.addressTwo(readfile.addressTwo());
		signuppage.selectCountry(readfile.countryName());
		signuppage.enterState(readfile.stateName());
		signuppage.enterCity(readfile.cityName());
		signuppage.enterZipcode(readfile.zipCode());
		signuppage.enterMobileNumber(readfile.mobNumber());
		signuppage.clickCreateAccountBtn();
		accountpage.isVisibleAccountCreatedText(readfile.isVisibleText());
		accountpage.verifyAccountCreatedText(readfile.verifyAccntTxt());
		accountpage.clickOnContinue();
		accountpage.verifyLoggesInAsUsername(readfile.verifyUsername());
		cartpage.clickProductLinkText();
		productpage.addProductOne(Constant.productone);
		productpage.clickCartLinkTest();
		cartpage.clickProceedToCheckOutBtn();
		productpage.clickCartAndVerifyIsDisplayed();
		cartpage.clickProceedToCheckOutBtn();
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.clickDelete();
	}
}
