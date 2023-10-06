package com.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.nio.file.*;

import com.automation.testcases.SetUp;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2022
 *
 */
public class Listeners extends TestListenerAdapter {

	public ExtentReports extent;
	public ExtentSparkReporter htmlreporter;
	public ExtentTest test;
	
	

	/**
	 * @param testcontext
	 * onStart
	 */
	public void onStart(ITestContext testContext) {
		
//		SetUp.logger.info("Test started");

		// time stamp
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// specifying location
		String repname = "Test-Report:" + timestamp + ".html";
		htmlreporter = new ExtentSparkReporter(
//				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
		System.getProperty("user.dir") + "\\docs\\index.html");
		extent = new ExtentReports();

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("user", "RagulRaj E");
		extent.setSystemInfo("Environment", "Testing");

		// Report title
		htmlreporter.config().setDocumentTitle("E-commerce app");
//		
//		//Report Name
		htmlreporter.config().setReportName("AutomationExercise");
//		
//		//Report color
		htmlreporter.config().setTheme(Theme.STANDARD);

	}

	/**
	 * onTestSucces
	 */
	public void onTestSuccess(ITestResult tr) {

		
		
		String testname = tr.getName();
		// Create new entry in the report
		test = extent.createTest(tr.getName());

		// passed info
		test.log(Status.PASS, MarkupHelper.createLabel(testname, ExtentColor.GREEN));
//		SetUp.logger.info("Test passed");

	}

	/**
	 * onTestFailure
	 */
	public void onTestFailure(ITestResult tr) {
		WebDriver driver = SetUp.driver;
		test = extent.createTest(tr.getName());
		String testname = tr.getName();
//		File screenshot = ((TakesScreenshot) SetUp.driver).getScreenshotAs(OutputType.FILE);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String destination = "Screenshots/" + testname + ".png";
		String destination = "docs/Screenshots/" + testname + ".png";
		

		try {
			File destinationFile = new File(destination);
			java.nio.file.Files.copy(screenshot.toPath(), destinationFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
			test.addScreenCaptureFromPath("../Screenshots/" + testname + ".png", "TestFailureSnap");

			
		} catch (IOException e) {
			e.printStackTrace();
		}

		String methodName = tr.getMethod().getMethodName();
		test.log(Status.FAIL, MarkupHelper.createLabel(methodName, ExtentColor.RED));
//		System.out.println("Test Failed");
//		
	}

	/**
	 * onTestSkipped
	 */
	public void onTestSkipped(ITestResult tr) {
		String testname = tr.getName();
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(testname, ExtentColor.ORANGE));
		test.log(Status.SKIP, tr.getThrowable());
//		SetUp.logger.info("Test skipped");

	}

	/**
	 * onFinish
	 */
	public void onFinish(ITestContext testContext) {
		System.out.println("Test executed");
		extent.flush();
	}
}