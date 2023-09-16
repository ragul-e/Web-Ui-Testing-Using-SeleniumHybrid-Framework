package com.automation.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class ExtentReporter {
	
	
	
	public static void generateExtentReport() {
		ExtentReports extentreports = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
	}

}
