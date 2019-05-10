package com.automation.utility;

import com.relevantcodes.extentreports.ExtentReports;

public class RentCount_ExtentManager {
	private static ExtentReports extent;
	 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Extent_Report_new.html", true);
        }
        return extent;
    }
	
}
