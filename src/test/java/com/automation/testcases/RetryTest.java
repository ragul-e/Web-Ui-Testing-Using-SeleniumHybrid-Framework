package com.automation.testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class RetryTest implements IRetryAnalyzer {
 
  private int retryCount = 0;
  private static final int maxRetryCount = 3;
 
  
  /**
   * @param result
   */
  public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}

