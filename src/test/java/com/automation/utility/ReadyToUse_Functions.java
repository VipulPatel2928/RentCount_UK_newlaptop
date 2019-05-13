package com.automation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class have the Ready to Use functions which will give you highly re-usability of Code.

public class ReadyToUse_Functions {
	
	// All function for the Wait for the Elements with Different Wait Condition
	
	public static void waitforelementvisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitforelementclickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitforseconds(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}
    
	
    
}
