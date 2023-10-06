package com.automation.pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.WatchEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import com.automation.testcases.SetUp;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class PaymentPage extends SetUp {

	/**
	 * drvier reference variable
	 */
	WebDriver driver;

	/**
 	 * @param driver
 	 * constructor to load driver and pagefactory
 	 */
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name_on_card']")
	WebElement nameoncardfield;

	@FindBy(xpath = "//input[@name='card_number']")
	WebElement cardnumfield;

	@FindBy(xpath = "//input[@name='cvc']")
	WebElement cvcfield;

	@FindBy(xpath = "//input[@name='expiry_month']")
	WebElement monthexpfield;

	@FindBy(xpath = "//input[@name='expiry_year']")
	WebElement yearexpfield;

	@FindBy(xpath = "//button[text()='Pay and Confirm Order']")
	WebElement payanconfirmbtn;

	@FindBy(xpath = "//h2[@class='title text-center']/b[text()='Order Placed!']")
	WebElement ordersuccess;
	
	@FindBy(xpath = "//a[text()='Download Invoice']")
	WebElement downloadInvoice;

	
	/**
	 * verifyPayementSucesMsg
	 */
	public  void verifyPaymentSuccessMsg() {
		
		//failing step intentionally to showcase the screenshot of failed step
		Assert.assertFalse(ordersuccess.isDisplayed());
		if(ordersuccess.isDisplayed()) {
			logger.info("order placed successfully");
		}
		else {
			logger.info("order placed successfully");
		}
	}

	/**
	 * 
	 * @param cardName
	 */
	public void cardname(String cardName) {
		nameoncardfield.clear();
		nameoncardfield.sendKeys(cardName);

	}

	/**
	 * 
	 * @param cardNum
	 */
	public void cardnum(String cardNum) {
		cardnumfield.clear();
		cardnumfield.sendKeys(cardNum);

	}

	/**
	 * 
	 * @param cardCvc
	 */
	public void ccv(String cardCvc) {
		cvcfield.clear();
		cvcfield.sendKeys(cardCvc);
	}

	/**
	 * 
	 * @param cardmonthexp
	 */
	public void monthExp(String cardmonthexp) {
		monthexpfield.clear();
		monthexpfield.sendKeys(cardmonthexp);
	}

	/**
	 * 
	 * @param cardyrexp
	 */
	public void yearExp(String cardyrexp) {
		yearexpfield.clear();
		yearexpfield.sendKeys(cardyrexp);
		
	}
	
	/**
	 * 
	 */
	public void clickPayAndConfirm() {
		payanconfirmbtn.click();
	}

	/**
	 * 
	 */
	public void downloadInvoice() {
		downloadInvoice.click();
	}

	/**
	 * 
	 * @param invoicefilepath
	 */
	public void validateInvoiceDownloadedSuccessfully(String invoicefilepath) {

		// Path to the download folder
		String downloadFolderPath = invoicefilepath;

		// File name of the invoice
		String invoiceFileName = "invoice.txt";

		// Check if the invoice file exists in the download folder
		File invoiceFile = new File(downloadFolderPath, invoiceFileName);
		boolean isInvoiceDownloaded = invoiceFile.exists();

		// Validate if the invoice is downloaded successfully
		if (isInvoiceDownloaded) {
		    System.out.println("Invoice is downloaded successfully.");
		} else {
		    System.out.println("Invoice download failed.");
		}
		
	}

	/**
	 * 
	 * @param invoiceActualText
	 * @param invoicepath
	 */
	public void validateTextInInvoice(String invoiceActualText, String invoicepath) {
		

		// Path to the invoice file
		String invoiceFilePath = invoicepath;

		// Expected text in the invoice
		String expectedInvoiceText = invoiceActualText;

		// Read the contents of the invoice file
		BufferedReader br = null;
		try {
		    br = new BufferedReader(new FileReader(invoiceFilePath));
		    String line;
		    StringBuilder invoiceText = new StringBuilder();
		    while ((line = br.readLine()) != null) {
		        invoiceText.append(line);
		    }

		    // Validate if the invoice text contains the expected text
		    if (invoiceText.toString().contains(expectedInvoiceText)) {
		        System.out.println("Invoice text is validated.");
		    } else {
		        System.out.println("Invoice text validation failed.");
		    }
		} catch (IOException e) {
		    System.out.println("Error reading the invoice file: " + e.getMessage());
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            System.out.println("Error closing the BufferedReader: " + e.getMessage());
		        }
		    }
		}

		
		
		
	}

}
