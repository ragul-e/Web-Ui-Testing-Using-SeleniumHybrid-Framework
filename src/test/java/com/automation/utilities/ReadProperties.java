package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.store.DomImpl.Dom;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class ReadProperties {

	Properties property;
	File file;
	FileInputStream fileinput;

	public ReadProperties() {
		file = new File("src/test/resources/configuration/config.properties");
		try {
			fileinput = new FileInputStream(file);
			property = new Properties();
			property.load(fileinput);
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public  String getUrl() {
		return property.getProperty("Url");
	}

	public String getChromePath() {
		return property.getProperty("Chromepath");
	}

	public String getEdgePath() {
		return property.getProperty("Edgepath");
	}

	public String homePageTitle() {
		return property.getProperty("homepagetitle");
	}

	public String signUpName() {
		return property.getProperty("signupname");
	}

	public String signupemail() {
		return property.getProperty("siginupemail");
	}
	
	public String verifyEnterAccntInfotext() {
		return property.getProperty("verifyenteraccntinfo");
	}

	public String setPassword() {
		return property.getProperty("enterpass");
	}

	public String doBirth() {
		return property.getProperty("dob");
	}

	public String doMon() {
		return property.getProperty("dom");

	}

	public String doYear() {
		return property.getProperty("doy");

	}

	public String addressInfoTxt() {
		return property.getProperty("addressinfotxt");
	}

	public String firstName() {
		return property.getProperty("firstname");

	}

	public String lastname() {
		return property.getProperty("lastname");
	}

	public String compName() {
		return property.getProperty("compname");
	}

	public String addressOne() {
		return property.getProperty("addressone");
	}

	public String addressTwo() {
		return property.getProperty("addresstwo");
	}

	public String countryName() {
		return property.getProperty("country");
	}

	public String stateName() {
		return property.getProperty("state");
	}

	public String cityName() {
		return property.getProperty("city");
	}

	public String zipCode() {
		return property.getProperty("zipcode");
	}

	public String mobNumber() {
		return property.getProperty("mobnum");
	}

	public String isVisibleText() {
		return property.getProperty("isvisibletext");
	}

	public String verifyAccntTxt() {
		return property.getProperty("verifyAccnttext");
	}

	public String verifyUsername() {
		return property.getProperty("username");
	}
		
	public String deliveryName() {
		return property.getProperty("deliveryname");
	}
	
	public String deliveryComp() {
		return property.getProperty("deliverycomp");
	}
	
	public String deliveryAddOne() {
		return property.getProperty("deliveryaddone");
	}
	
	public String deliveryAddTwo() {
		return property.getProperty("deliveryaddtwo");
	}
	
	public String deliveryZipCode() {
		return property.getProperty("deliverycode");
	}
	
	public String deliveryCountry() {
		return property.getProperty("deliveryCountry");
	}
	
	public String deliveryMobNum() {
		return property.getProperty("deliveryMobnum");
	}
	
	
	public String billingName() {
		return property.getProperty("bilingname");
	}
	
	public String billingComp() {
		return property.getProperty("billingcomp");
	}
	
	public String billingAddOne() {
		return property.getProperty("billingaddone");
	}
	
	public String billingAddTwo() {
		return property.getProperty("billingaddtwo");
	}
	
	public String billingCode() {
		return property.getProperty("billingcode");
	}
	
	public String billingCountry() {
		return property.getProperty("billingcountry");
	}
	
	public String billingMobNum() {
		return property.getProperty("billingmobnum");

	}
	
	public String logEmail() {
		return property.getProperty("loginemail");
	}
	
	public String logPass() {
		return property.getProperty("loginpass");
	}
	
	public String cardName() {
		return property.getProperty("cardname");
	}
	
	public String cardNum() {
		return property.getProperty("cardnum");
	}
	
	public String  cardCvc() {
		return property.getProperty("cardcvc");
	}
	
	public String cardmonthexp() {
		return property.getProperty("cardmonthexp");
	}
	
	public String cardyrexp() {
		return property.getProperty("cardyrexp");
	}
	
	public String invoiceText() {
		return property.getProperty("Invoicetext");
	}
	
	public String invoiceFilePath() {
		return property.getProperty("Invoicefilepath");
	}
	
	public String verifyNewUserName() {
		return property.getProperty("verifynewusername");

	}
	
	
	
	
	public String verfifyNewUserNametc1() {
		return property.getProperty("verifynewusernameTC1");
		
	}
	
	public String signupnametc1() {
		return property.getProperty("signupnameTC1");
		
	}
	
	public String signupemailtc1() {
		return property.getProperty("signupemailTC1");
		
	}
	
	public String verifyLogAsUsernametc1() {
		return property.getProperty("verifyloginasusernameTC1");
		
	}
	
	
	
	
	
	
	
}
