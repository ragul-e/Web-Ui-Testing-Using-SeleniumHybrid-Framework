package com.automation.utilities;

import com.automation.testcases.SetUp;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class TC1_Datas extends SetUp {

//	ReadProperties read = new ReadProperties();
//	public static DataSetters datatcone = new DataSetters();

	public  static DataSetters dataTcOne() {
		ReadProperties read = new ReadProperties();
//		 datatcone = new DataSetters();
		data.setVerifynewusername(read.verifyNewUserName());
		data.setSignUpName(read.signUpName());
		data.setSignUpEmail(read.signupemail());
		data.setVerifyaccuntinfotext(read.verifyEnterAccntInfotext());
		data.setEnterPassword(read.setPassword());
		data.setDayOfBirth(read.doBirth());
		data.setDateofmonth(read.doMon());
		data.setDateofyear(read.doYear());
		data.setAddressInfoText(read.addressInfoTxt());
		data.setLastName(read.lastname());
		data.setCompanyName(read.compName());
		data.setAddressOne(read.addressOne());
		data.setAddressTwo(read.addressTwo());
		data.setCountry(read.countryName());
		data.setZipCode(read.zipCode());
		data.setMobileNumber(read.mobNumber());
		data.setIsAccntCratedVisibleText(read.isVisibleText());
		data.setVerifyAccountText(read.verifyAccntTxt());
		data.setLogedAsUsername(read.verifyUsername());
		
		return data;

	}

}
