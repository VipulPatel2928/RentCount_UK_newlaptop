package com.automation.utility;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.utility.RentCount_ExtentManager;
import com.automation.utility.RentCount_ExtentTestManager;
import com.automation.index.RentCount_PackageIndex;
import com.automation.init.RentCount_SeleniumInit;
import com.automation.utility.RentCount_Retry;
 

public class RentCount_TestListener extends RentCount_SeleniumInit implements ITestListener {
	
	public static String testcase_description;
	public static ExtentTest test;
	
	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	    
	    //Before starting all tests, below method runs.
	    @Override
	    public void onStart(ITestContext iTestContext) {
	        System.out.println("I am in onStart method " + iTestContext.getName());
	        testcase_description =iTestContext.getName();
	        iTestContext.setAttribute("WebDriver", this.driver);
	    }
	 
	    //After ending all tests, below method runs.
	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        System.out.println("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for extentreports reporting!
	        RentCount_ExtentTestManager.endTest();
	        RentCount_ExtentManager.getReporter().flush();
	    }
	 
	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
	        //Start operation for extentreports.
	        test = RentCount_ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),testcase_description);
	      //  test.log(LogStatus.INFO, "Step 1");
	        RentCount_PackageIndex.getTest(test);//this is PackageIndex method for the log in the Extent report.
	    }
	 
	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
	        //Extentreports log operation for passed tests.
	        RentCount_ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	    }
	 
	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
	 
	        //Get driver from BaseTest and assign to local webdriver variable.
	        Object testClass = iTestResult.getInstance();
	        WebDriver webDriver = ((RentCount_SeleniumInit) testClass).getDriver();
	 
	        //Take base64Screenshot screenshot.
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        //Extentreports log and screenshot operations for failed tests.
	        RentCount_ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
	                RentCount_ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));      
	        
	    }
	 
	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	        //Extentreports log operation for skipped tests.
	        RentCount_ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	    }
	 
	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }

}
