package com.automation.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

public class LogClass {

	// Function for the Test Case
	public static void logcase(String msg) {
		System.out.println(msg);
		Reporter.log("<strong><h1 style=\"color:DarkViolet;font-size:13px;\"> " + msg + "</h1> </strong>");
	}

	// Function for the Steps in the Script
	public static void logstep(String msg) {
		System.out.println(msg);
		Reporter.log("<br><strong><font color=\"blue\">" + msg + "</font></strong></br>");
	}

	// Function for the Verification Steps in the Script
	public static void logveri(String msg) {
		System.out.println(msg);
		Reporter.log("<strong><h1 style=\"color:saddlebrown;font-size:11px;\"> " + msg + "</h1> </strong>");
	}

	// Function for the Successful verification
	public static void AssertPassed() {
		System.out.println();
		Reporter.log("<strong> <h3 style=\"color:DarkGreen\">  &#10004; <i>  SUCCESSFUL </i></h3> </strong> ");
	}

	// Function for the UnSuccessful verification
	public static void AssertFailed() {
		System.out.println();
		Reporter.log("<strong> <h3 style=\"color:DarkRed\"> &#10008; <i> UNSUCCESSFUL </i></h3> </strong>");
	}
    // Function for the log status
	public static void logStatus(String Status) {
        System.out.println(Status);
		if (Status.equalsIgnoreCase("Pass")) {
			log("<hr size='15px' noshade color='green'>");
		} else if (Status.equalsIgnoreCase("Fail")) {
			log("<hr size='15px' noshade color='red'>");
		}
	}
	
	// Function to take a ScreenShot
	public static void makeScreenshot(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {

			String reportFolder = "C:/Users/User/eclipse-workspace/RentCount_UK/test-output" + File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			log("Failed to capture screenshot: " + e.getMessage());
		}
		log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
	}
	// Function to Log given message to Reporter output. @param msg Message/Log to
	// be reported.

	public static void log(String msg) {
		System.out.println(msg);
		Reporter.log("</br>&nbsp;&nbsp;&nbsp;&nbsp;" + msg + "</br>");
	}

	// Function to Generates link for TestNG report.@param screenshot_name
	// Screenshot name.@param link_text@return Formatted link for TestNG report.
	public static String getScreenshotLink(String screenshot_name, String link_text) {
		log("<br><Strong><font color=#FF0000>--Failed</font></strong>");
		return "<a href='screenshots/" + screenshot_name + "' target='_new'>" + link_text + "</a>";
	}
}
