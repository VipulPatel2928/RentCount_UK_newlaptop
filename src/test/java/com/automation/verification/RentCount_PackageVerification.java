package com.automation.verification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.automation.index.RentCount_PackageIndex;
import com.automation.indexpage.RentCount_PackageIndexpage;
import com.automation.init.RentCount_AbstractPage;
import com.automation.utility.LogClass;
import com.automation.utility.RentCount_Common;
import com.automation.utility.funcs;
import com.relevantcodes.extentreports.LogStatus;
//import com.init.Common;

public class RentCount_PackageVerification extends RentCount_AbstractPage {

	public RentCount_PackageVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean homepageverify() {
		// TODO Auto-generated method stub
		String urlpass = "https://www.toolsqa.com/";

		if (driver.getCurrentUrl().equals(urlpass))
			return true;
		else
			return false;
	}

	public boolean yahoologindetailsverification() {
		// TODO Auto-generated method stub
		LogClass.logveri("---> Verification Start <---");
		RentCount_PackageIndex.extent_report_log.log(LogStatus.INFO, "---> Verification Start <---");
		WebElement compose = driver.findElement(By.xpath("//a[text()='Compose']"));
		WebElement username = driver.findElement(By.xpath("//span[text()='vipul']"));

		if (compose.isDisplayed() && username.getText().equals("vipul")) {
			RentCount_PackageIndex.extent_report_log.log(LogStatus.INFO, "---> Verification SUCCESSFUL <---");
			return true;
		} else {
			RentCount_PackageIndex.extent_report_log.log(LogStatus.INFO, "---> Verification UNSUCCESSFUL Check the ScreenShot Please <---");
			return false;
		}
	}
	
public boolean jqueryuihomepageverify() {
		// TODO Auto-generated method stub
		String urlpass = "http://jqueryui.com/";
		if (driver.getCurrentUrl().equals(urlpass))
			return true;
		else
			return false;
	}

	public boolean app_form_open_verify() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		WebElement app_form_text = driver.findElement(By.xpath("//h1[text()='Practice Automation Form']"));
		LogClass.logveri("---> Verification Start <---");
		LogClass.logExtent("---> Verification Start <---");
		if(app_form_text.getText().equals("Practice Automation Form")) {
			LogClass.logExtent("---> Verification SUCCESSFUL <---");
			return true;
		}
		else {
			LogClass.logExtent("---> Verification UNSUCCESSFUL Check the ScreenShot Please <---");
		return false;}
	}

	
	
	
}
