package com.automation.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.pageobjects.CartPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.ProductPage;
import com.automation.utilities.Constant;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */


public class TC2_ValidateCardItems extends SetUp{
	 
	
	/**
	 * 
	 */
	@Test(groups = "smoke",retryAnalyzer = RetryTest.class)
	public void validateAddItemToCartAndNonExistenceProduct() {
		
		
		
		homepage.verifyHomePage("Automation Exercise");
		homepage.scrollToBottomOfPage();
		homepage.verifyVisibiltyOfRecommendedItems();
		homepage.validateNavigationButtonIsVisible();
		homepage.addWintertopProductToCart();
		homepage.clickOnViewCart();
		
		cartpage.verifyProductIsDisplayedInCart();
		cartpage.clickProductLinkText();
		productpage.addProductOne(Constant.productone);
		productpage.addProductTwo(Constant.producttwo);
		productpage.addProductThree(Constant.productthree);
		productpage.addProductFour(Constant.productfour);
		productpage.addProductFive(Constant.productfive);
		productpage.addProductSix(Constant.productsix);
		productpage.addProductSeven(Constant.productseven);
		productpage.addProductEight(Constant.productoneeight);
		productpage.addProductNine(Constant.productonenine);
		productpage.addProductTen(Constant.productoneten);
		productpage.addProductEleven(Constant.productoneeleven);
		productpage.clickCartAndVerifyIsDisplayed();
		cartpage.clickXmarkVerifyProductIsRemoved();
		
		
		
		
		

		
		

	}

}
