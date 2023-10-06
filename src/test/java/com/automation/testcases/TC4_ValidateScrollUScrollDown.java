package com.automation.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.utilities.ReadProperties;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class TC4_ValidateScrollUScrollDown extends SetUp {
	
	/**
	 * testScrollUpScrollDown
	 */
	@Test(groups = "smoke",retryAnalyzer = RetryTest.class)
	public void testScrollUpScrollDown() {
		ReadProperties readfile = new ReadProperties();
		homepage.verifyHomePage(readfile.homePageTitle());
		homepage.scrollToBottomOfPage();
		homepage.verifySubscriptionAvailable();
		homepage.clickOnUpArrowBtn();
		homepage.verifyText();
		
	}

}

