package com.automation.Base;

import java.util.Arrays;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.time.Duration;

import com.automation.pageobjects.AccountPage;
import com.automation.pageobjects.CartPage;
import com.automation.pageobjects.CheckoutPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LoginPage;
import com.automation.pageobjects.PaymentPage;
import com.automation.pageobjects.ProductPage;
import com.automation.pageobjects.SignUpPage;
import com.automation.utilities.DataSetters;
import com.automation.utilities.Listeners;
import com.automation.utilities.ReadProperties;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class SetUp {

	ReadProperties readfile = new ReadProperties();
	public String url = readfile.getUrl();
	public String chrompath = readfile.getChromePath();
	public String edgepath = readfile.getEdgePath();

	public static WebDriver driver;
	
	//Login page reference variable
	public LoginPage loginpage;

	//Signup page reference variable
	public SignUpPage signuppage;
	
	//Account page reference variable
	public AccountPage accountpage;
	
	//Homepage page reference variable
	public HomePage<String> homepage;
	
	//Cart page reference variable
	public CartPage cartpage;
	
	//Login page reference variable
	public CheckoutPage checkoutPage;
	
	//Product page reference variable
	public ProductPage productpage;
	
	//Cart page reference variable
	public PaymentPage paymentpage;
	
	//Datasetter class accupte type sting using type reference
	public static  DataSetters<String> data;
	public static Logger logger;

	
	/**
	 * launch the edge browser with url
	 */
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() {
		
		

		System.setProperty("webdriver.chrome.driver", chrompath);
		EdgeOptions options = new EdgeOptions();
		
		//diabling notification
		options.addArguments("diable-notifications");
		options.addArguments("diable-geolocation");
		options.addArguments("--headless");
		options.addArguments("--disable-ads");
		options.addArguments("--remote-allow-origins=*");
		
		//Added add blockers
		options.addExtensions(new File("src/test/resources/AdBlocker/odfafepnkmbhccpbejgmiehpchacaeak.crx"));
		
		//passing options to edge driver class
		driver = new EdgeDriver(options);
		
		//Default wait 5 second
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Maximize the winnow
		driver.manage().window().maximize();
		driver.get(url);
		
		
		//Instantiating data setter class
		data = new DataSetters<>();
		
		//Instantiating login page
		loginpage = new LoginPage(driver);
		
		//Instantiating signup page
		signuppage = new SignUpPage(driver);
		
		//Instantiating account page
		accountpage = new AccountPage(driver);
		
		//Instantiating signup page
		cartpage = new CartPage(driver);

		//Instantiating home page
		homepage = new HomePage<>(driver);
		
		//Instantiating signup page
		productpage = new ProductPage(driver);
		
		//Instantiating checkout page
		checkoutPage = new CheckoutPage(driver);
		
		//Instantiating payment page
		paymentpage = new PaymentPage(driver);
		 
		//creating instance for apache log4j logger
		logger = (Logger) LogManager.getLogger(SetUp.class);
	}

	@AfterClass
	public void closeBrowser() {

		// Close the driver
		logger.info("Test execution completed.");
		driver.quit();
		System.gc(); // Trigger garbage

	}
}
