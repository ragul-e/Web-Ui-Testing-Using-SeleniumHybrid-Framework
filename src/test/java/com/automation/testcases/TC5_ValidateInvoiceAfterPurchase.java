package com.automation.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageobjects.PaymentPage;
import com.automation.utilities.ReadProperties;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class TC5_ValidateInvoiceAfterPurchase extends SetUp {

	
	
	/**
	 * validateInvoice
	 */
	@Test(groups = "smoke",retryAnalyzer = RetryTest.class)
	public void validateInvoice() {
		ReadProperties readfile = new ReadProperties();
		homepage.verifyHomePage(readfile.homePageTitle());
		homepage.clickProduct();
		homepage.mouseHoverOnSecondProduct();
		productpage.clickOnContinueShopping();
		homepage.mouseHoverOnThirdProduct();
		productpage.clickOnContinueShopping();
		productpage.clickCartAndVerifyIsDisplayed();
		cartpage.clickProceedToCheckOutBtn();
		cartpage.clickSignIn();
		loginpage.enterEmail(readfile.logEmail());
		loginpage.enterPassword(readfile.logPass());
		loginpage.clickLogin();
		loginpage.clickCart();
		cartpage.clickProceedToCheckOutBtn();
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.reviewOrder();
		checkoutPage.totalAmount();
		checkoutPage.clickPlaceOrder();
		paymentpage.cardname(readfile.cardName());
		paymentpage.cardnum(readfile.cardNum());
		paymentpage.ccv(readfile.cardCvc());
		paymentpage.monthExp(readfile.cardmonthexp());
		paymentpage.yearExp(readfile.cardyrexp());
		paymentpage.clickPayAndConfirm();
		paymentpage.verifyPaymentSuccessMsg();
		paymentpage.downloadInvoice();
		paymentpage.validateInvoiceDownloadedSuccessfully(readfile.invoiceFilePath());
		paymentpage.validateTextInInvoice(readfile.invoiceText(),readfile.invoiceFilePath());
		
	}
}
