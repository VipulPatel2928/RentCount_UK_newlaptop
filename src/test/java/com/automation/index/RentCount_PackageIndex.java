package com.automation.index;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.indexpage.RentCount_PackageIndexpage;
import com.automation.init.RentCount_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.RentCount_Common;
import com.automation.utility.RentCount_Common_demo;
import com.automation.utility.RentCount_Retry;
import com.automation.utility.RentCount_TestData;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RentCount_PackageIndex extends RentCount_SeleniumInit {


	public static int step, numberOfFailure = 1;
	SoftAssert softassertion = new SoftAssert();//For the soft Assertion 
	public static com.aventstack.extentreports.ExtentTest logger;//for the log in extent report
	public static ExtentTest test_package;//for the log in extent report
	public static ExtentTest extent_report_log;//for the log in extent report
	
	//Below method bring the object for the log in the report
	public static void getTest(ExtentTest test) {
		// TODO Auto-generated method stub
		test_package = test;
		extent_report_log=test;
		System.out.println("Get Test Method called");
	}
	
	@Test
	public void TC_LogIn_02() {
		step = 1;
        String step_extend_report_msg;//String for the log in the Report
		RentCount_Common.logcase(" ");
		RentCount_Common.logcase("TEST CASE:TC_LogIn_02::To verify That user is able to Login with the valid details");		
		test_package.log(LogStatus.INFO, "TEST CASE:TC_LogIn_02::To verify That user is able to Login with the valid details");
		step_extend_report_msg ="Step" + (step++) + ": Open the Url---> https://staging.3dbroadcastsales.com/";
		RentCount_Common.logstep(step_extend_report_msg);
    	test_package.log(LogStatus.INFO,step_extend_report_msg);// for new extent report
    	
		if (packageVerification.homepageverify()) {
			RentCount_Common.logveri("-----> 3dbroadcastsales home page open <-----");
			test_package.log(LogStatus.INFO,"-----> 3dbroadcastsales home page open <-----");
			RentCount_Common.AssertPassed();
			Assert.assertTrue(true);
		} else {
			RentCount_Common.logveri("-----> 3dbroadcastsales home page  not open <-----");
			test_package.log(LogStatus.INFO,"-----> 3dbroadcastsales home page not open <-----");
			RentCount_Common.AssertFailed();
			RentCount_Common.makeScreenshot(driver, "LoginFailed");
		}
		
		step_extend_report_msg="Step" + (step++) + ": Click on the Login menu";

		RentCount_Common.logstep(step_extend_report_msg);
		test_package.log(LogStatus.INFO,step_extend_report_msg);
		packageVerification = packageIndexpage.click_login_menu();
		step_extend_report_msg="Step" + (step++) + ": Enter the Details for Login";
        RentCount_Common.logstep(step_extend_report_msg);
		test_package.log(LogStatus.INFO,step_extend_report_msg);
		packageVerification = packageIndexpage.login_details();
	    step_extend_report_msg="Step" + (step++) + ": Click on Login button";
        RentCount_Common.logstep(step_extend_report_msg);
	    test_package.log(LogStatus.INFO,step_extend_report_msg);
		packageVerification = packageIndexpage.login_buton();
		step_extend_report_msg="Step" + (step++) + ": User Login verification.";
		RentCount_Common.logstep(step_extend_report_msg);
		test_package.log(LogStatus.INFO,step_extend_report_msg);
        if (packageVerification.logindetailsverification()) {
			System.out.println("Test Pass.......");//Print the message Test Pass
			RentCount_TestData.SheetResultcellupdate(2, 3, "Pass"); //Update the Excel Sheet As per Test Result
			RentCount_Common.logStatus("Pass");//Mark the in Report Test Case As Pass 
			RentCount_Common.AssertPassed();//Mark the in Report Test Case as Successful 
			Assert.assertTrue(true);
		} else 
		{
			System.out.println("Test Failed.......");//Print the message Test Failed
			RentCount_TestData.SheetResultcellupdate(2, 3, "Failed");
			RentCount_Common.logStatus("Fail");//Mark the in Report Test Case As Fail
			RentCount_Common.AssertFailed();//Mark the in Report Test Case As UNSUCCESSFUL
			RentCount_Common.makeScreenshot(driver, "LoginFailed");//Take a ScreenShot
			Assert.assertTrue(false);
		}

	}// End of TC_LogIn_02 function
	
	@Test
	public void yahoomail_login() throws InterruptedException {
		step = 1;
        String report_msg;//String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "TEST CASE::yahoomail_login::To verify That user is able to Login with the valid details";
		LogClass.logcase(report_msg);		
		extent_report_log.log(LogStatus.INFO, report_msg);
		report_msg ="Step" + (step++) + ": https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd";
		LogClass.logstep(report_msg);
		extent_report_log.log(LogStatus.INFO, report_msg);
		
		if (packageVerification.homepageverify()) {
			LogClass.logveri("-----> YahooMail home page open <-----");
			extent_report_log.log(LogStatus.INFO,"-----> YahooMail home page open <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> YahooMail home page is not open <-----");
			extent_report_log.log(LogStatus.INFO,"-----> YahooMail home page is not open <-----");
			LogClass.AssertFailed();
			LogClass.makeScreenshot(driver, "yahoomail_loginFailed");
		}
		report_msg="Step" + (step++) + ": Enter Login Details";
		LogClass.logstep(report_msg);
		extent_report_log.log(LogStatus.INFO, report_msg);
		packageVerification = RentCount_PackageIndexpage.Yahoomail_login_details();
		
		 if (packageVerification.yahoologindetailsverification()) {
				System.out.println("Test Pass.......");//Print the message Test Pass
				//RentCount_TestData.SheetResultcellupdate(2, 3, "Pass"); //Update the Excel Sheet As per Test Result
				LogClass.logStatus("Pass");//Mark the in Report Test Case As Pass 
				LogClass.AssertPassed();//Mark the in Report Test Case as Successful 
				Assert.assertTrue(true);
			} else 
			{
				System.out.println("Test Failed.......");//Print the message Test Failed
			//	RentCount_TestData.SheetResultcellupdate(2, 3, "Failed");
				LogClass.logStatus("Fail");//Mark the in Report Test Case As Fail
				LogClass.AssertFailed();//Mark the in Report Test Case As UNSUCCESSFUL
				LogClass.makeScreenshot(driver, "LoginFailed");//Take a ScreenShot
				Assert.assertTrue(false);
			}

		
	}// End of yahoomail_login

}// End of Class
