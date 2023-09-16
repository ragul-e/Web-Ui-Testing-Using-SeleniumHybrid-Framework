package com.automation.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.Base.SetUp;
import com.automation.utilities.ExUtils;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */

public class TC1_RegistrationProcess extends SetUp {

	
	/**
	 * 
	 * @return data
	 */
	@DataProvider
    public String[][] getLogData() {
		String data[][] = ExUtils.readValueAs2d("src/test/java/com/automation/testdata/One.xlsx");
   	 return data;
    }
	
	/**
	 * 
	 * @param username
	 * @param signupname
	 * @param signemail
	 * @param accountinfotext
	 * @param password
	 * @param day
	 * @param Month
	 * @param year
	 * @param address
	 * @param firstname
	 * @param lastname
	 * @param companyname
	 * @param addressone
	 * @param addresstwo
	 * @param country
	 * @param state
	 * @param city
	 * @param zipcode
	 * @param mobnum
	 * @param verifyaccuntcreatedtext
	 * @param Accountcreatedtext
	 * @param loginasusername
	 */
	@Test(dataProvider="getLogData",groups = "smoke",retryAnalyzer = RetryTest.class)
	public void userRegistration(String username, String signupname, String signemail,String accountinfotext, String password, String day, String Month, String year, String address, String firstname,
			                      String lastname,String companyname, String addressone,String addresstwo, String country, String state, String city, String zipcode, String mobnum, String verifyaccuntcreatedtext, String Accountcreatedtext, String loginasusername)  {
//		logger.info("navigate to url");
		loginpage.clickSignUp();
		loginpage.verifyNewUserNameIsVisible(username);
		loginpage.enterSignUpName(signupname);
		loginpage.enterSignupEmail(signemail);
		loginpage.clickSignUpBtn();
		signuppage.validateEnterAccountInformtionIsVisible(accountinfotext);
		signuppage.chooseTitle();
		signuppage.enterPassword(password);
		signuppage.chooseDateOfBirthParams(day,Month,year);
		signuppage.verfiyAddressInfoIsVisible(address);
		signuppage.firstName(firstname);
		signuppage.lastname(lastname);
		signuppage.companyName(companyname);
		signuppage.addressOne(addressone);
		signuppage.addressTwo(addresstwo);
		signuppage.selectCountry(country);
		signuppage.enterState(state);
		signuppage.enterCity(city);
		signuppage.enterZipcode(zipcode);
		signuppage.enterMobileNumber(mobnum);
		signuppage.clickCreateAccountBtn();
		accountpage.isVisibleAccountCreatedText(verifyaccuntcreatedtext);
		accountpage.verifyAccountCreatedText(Accountcreatedtext);
		accountpage.clickOnContinue();
		accountpage.verifyLoggesInAsUsername(loginasusername);
		
		
	}
	
}















