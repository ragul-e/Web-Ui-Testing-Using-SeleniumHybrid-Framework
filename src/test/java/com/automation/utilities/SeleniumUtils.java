package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.testcases.SetUp;


/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class SeleniumUtils extends SetUp  {
	
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
	
	/**
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
//		waitForElementInvisible(driver, element);
        element.click();
    }
	
	/**
	 * 
	 * @param element
	 * @param text
	 */
	public static  void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
	
	private static final int SEC = 10; // Default timeout in seconds

	/**
	 * 
	 * @param driver
	 * @param element
	 */
    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 
     * @param driver
     * @param element
     */
    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public static void waitForElementInvisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    /**
     * 
     * @param driver
     * @param element
     */
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

}
