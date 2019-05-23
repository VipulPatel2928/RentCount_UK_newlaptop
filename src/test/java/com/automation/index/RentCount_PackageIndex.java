package com.automation.index;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.indexpage.RentCount_PackageIndexpage;
import com.automation.init.RentCount_SeleniumInit;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
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
		//test_package = test;
		extent_report_log=test;
		System.out.println("Get Test Method called");
	}
	
	@Test(priority=0)
	public void yahoomail_login(){
		step = 1;
        String report_msg;//String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "TEST CASE::yahoomail_login::To verify That user is able to Login with the valid details";
		LogClass.logcase(report_msg);		
		extent_report_log.log(LogStatus.INFO, report_msg);
		report_msg ="Step " + (step++) + ": https://login.yahoo.com/?.src=ym&.lang=en-IN&.intl=in&.done=https%3A%2F%2Fmail.yahoo.com%2Fd";
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
		report_msg="Step " + (step++) + ": Enter Login Details";
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
	
	//This is practice Test Case
	@Test(priority=1)
	public void Practice_Automation_Form(){
		step = 1;
        String report_msg;//String for the log in the Report
		LogClass.logcase(" ");
		report_msg = "TEST CASE::Practice Automation Form";
		LogClass.logcase(report_msg);		
		LogClass.logExtent(report_msg);
		
		report_msg ="Step " + (step++) + ":Open : https://www.toolsqa.com/";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);		
		if (packageVerification.homepageverify()) {
			LogClass.logveri("-----> Toolsqa home page is open <-----");
			LogClass.logExtent("-----> Toolsqa home page is open <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Toolsqa home page is not open <-----");
			LogClass.logExtent("-----> Toolsqa home page is not open <-----");
			LogClass.AssertFailed();
			LogClass.makeScreenshot(driver, "Practice_Automation_Form");
		}
		report_msg="Step " + (step++) + ": Navigate to Practice Automation Form";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = RentCount_PackageIndexpage.navi_to_app_form();
		if (packageVerification.app_form_open_verify()) {
			LogClass.logveri("-----> Application form is open <-----");
			LogClass.logExtent("-----> Application form is open <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> Application form is not open <-----");
			LogClass.logExtent("-----> Application form is not open <-----");
			LogClass.AssertFailed();
			LogClass.makeScreenshot(driver, "Practice_Automation_Form");
		}
		report_msg = "Step " + (step++) + ": Filling the Details into Practice Automation Form";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = RentCount_PackageIndexpage.filling_Details_into_app_form();
		
		report_msg = "Step " + (step++) + ": Select Continents";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = RentCount_PackageIndexpage.continets();
		
		report_msg = "Step " + (step++) + ": Select Seleniu Commands";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);
		packageVerification = RentCount_PackageIndexpage.commands();
		
		report_msg ="Step " + (step++) + ":Open : http://jqueryui.com/";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);		
		packageVerification = RentCount_PackageIndexpage.navi_jqueryui();
		if (packageVerification.jqueryuihomepageverify()) {
			LogClass.logveri("-----> jqueryui home page is open <-----");
			LogClass.logExtent("-----> jqueryui home page is open <-----");
			LogClass.AssertPassed();
			Assert.assertTrue(true);
		} else {
			LogClass.logveri("-----> jqueryui home page is not open <-----");
			LogClass.logExtent("-----> jqueryui home page is not open <-----");
			LogClass.AssertFailed();
			LogClass.makeScreenshot(driver, "Practice_Automation_Form");
		}
		report_msg ="Step " + (step++) + ":Click on Autocomplete";
		LogClass.logstep(report_msg);
		LogClass.logExtent(report_msg);		
		packageVerification = RentCount_PackageIndexpage.autocomplete();
		funcs.waitforseconds(5);
		
		
		
		
		/* if (packageVerification.yahoologindetailsverification()) {
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
			}*/
		
	}// End of yahoomail_login
	
	
	

}// End of Class
