package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.testcases.SetUp;

public class SeleniumUtils extends SetUp  {
	
	
	public static void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
	public static void click(WebElement element) {
        element.click();
    }
	
	public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
	
	private static final int SEC = 10; // Default timeout in seconds


    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static void waitForElementInvisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SEC));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

}
