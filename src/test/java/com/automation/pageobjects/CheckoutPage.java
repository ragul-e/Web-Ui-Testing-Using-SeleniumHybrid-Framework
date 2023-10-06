package com.automation.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.DelayableLittleEndianOutput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.automation.testcases.SetUp;
import com.automation.utilities.ExUtils;
import com.automation.utilities.ReadProperties;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */

public class CheckoutPage extends SetUp {

	//webdriver reference variable
	WebDriver driver;

	/**
	 * 
	 * @param driver
	 * constructor to load driver and pagefactory
	 */
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Storing all the webelements in a list
	@FindBy(xpath = "//ul[@id='address_delivery']//li")
	List<WebElement> deliveryaddress;

	@FindBy(xpath = "//ul[@id='address_invoice']//li")
	List<WebElement> registrationdetails;

	@FindBy(xpath = "//ul[@id='address_invoice']//li")
	List<WebElement> invoicedetailsweb;

	@FindBy(xpath = "//div[@class='shop-menu pull-right']//a[text()=' Delete Account']")
	WebElement Delete;
	
	@FindBy(xpath = "(//tbody//tr//td//p)[last()]")
	WebElement totalamount;
	
	@FindBy(xpath = "//tbody//tr//td/h4/a[text()='Men Tshirt']")
	WebElement revieworderproduct2;
	
	@FindBy(xpath = "//tbody//tr//td/h4/a[text()='Sleeveless Dress']")
	WebElement revieworderproduct3;
	
	
	@FindBy(xpath = "//a[text()='Place Order']")
	WebElement placeorder;

	/**
	 * 
	 * @return registration details
	 */
	public List<WebElement> webBillingDatas() {
		return registrationdetails;

	}

	/**
	 * 
	 * @return invoicedetailsweb
	 */
	public List<WebElement> invoiceDatas() {
		return invoicedetailsweb;

	}
	
	/**
	 * verify delivery address
	 */
	public void verifyDeliveryAddress() {
		ReadProperties readfile = new ReadProperties();
		List<String> billingaddress = new ArrayList<String>();
		billingaddress.add(readfile.deliveryName());
		billingaddress.add(readfile.deliveryComp());
		billingaddress.add(readfile.deliveryAddOne());
		billingaddress.add(readfile.deliveryAddTwo());
		billingaddress.add(readfile.deliveryZipCode());
		billingaddress.add(readfile.deliveryCountry());
		billingaddress.add(readfile.deliveryMobNum());

		if (webBillingDatas().size() == billingaddress.size()) {
			int index = 0;

			for (WebElement registrationDetail : webBillingDatas()) {
				String billingAddressValue = billingaddress.get(index);

				String registrationDetailText = registrationDetail.getText();
				if (registrationDetailText.equals(billingAddressValue)) {
					logger.info("Validation passed for item at index " + index);
				} else {
					logger.info("Validation failed for item at index " + index);
				}

				index++;
			}
		}

	}

	/**
	 * verify billing address
	 */
	public void verifyBillingAddress() {

		ReadProperties readfile = new ReadProperties();
		List<String> invoicedata = new ArrayList<String>();
		invoicedata.add(readfile.billingName());
		invoicedata.add(readfile.billingComp());
		invoicedata.add(readfile.billingAddOne());
		invoicedata.add(readfile.billingAddTwo());
		invoicedata.add(readfile.billingCode());
		invoicedata.add(readfile.billingCountry());
		invoicedata.add(readfile.billingMobNum());

		if (invoiceDatas().size() == invoicedata.size()) {
			int index = 0;

			for (WebElement registrationDetail : invoiceDatas()) {
				String invoicedetails = invoicedata.get(index);

				String registrationDetailText = registrationDetail.getText();
				if (registrationDetailText.equals(invoicedetails)) {
					logger.info("Validation passed for item at index " + index);
				} else {
					logger.info("Validation failed for item at index " + index);
				}

				index++;
			}
		}

	}

	/**
	 * Delete
	 */
	public void clickDelete() {
		Delete.click();

	}

	/**
	 * review order
	 */
	public void reviewOrder() {
		String producttwo = revieworderproduct2.getText();
		String productthree = revieworderproduct3.getText();
		logger.info("review order-product one: "+producttwo);
		logger.info("review order-product two: "+productthree);
		
	}

	/**
	 * gets total amount
	 */
	public void totalAmount() {
		String grandtotalamount = totalamount.getText();
		logger.info("Total Amount: "+ grandtotalamount);
	}

	/**
	 * click place order
	 */
	public void clickPlaceOrder() {
		placeorder.click();
	}
	

}
