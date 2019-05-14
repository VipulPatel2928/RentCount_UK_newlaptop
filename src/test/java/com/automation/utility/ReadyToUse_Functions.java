package com.automation.utility;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
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

	public static void waitforseconds(int secs){
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {

		}
	}
    // Function to Enter Data in the TextFields
	public static void senddata(WebDriver driver,WebElement element,String data) {
		waitforelementvisible(driver, element);
		element.click();
		element.clear();
		element.sendKeys(data);
	}

	// Function Read data from the Text File
	public static ArrayList<String> ReadTextFile(String filename, int nooflines) {
		String fileName = filename;
		// This will reference one line at a time
		String line = null;
		ArrayList<String> data = new ArrayList<String>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			for (int i = 1; i <= nooflines; i++) {
				if ((line = bufferedReader.readLine()) != null)
					data.add(line);
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return data;
	}
	
	//Function to use opne url in the new tab window
	public static void switchToNewtabWithUrl(WebDriver driver,String URL,int tab)
	 {
	  waitforseconds(5);
	  System.out.println("==========="+System.getProperty("os.name"));
	  ((JavascriptExecutor)driver).executeScript("window.open();");
	  waitforseconds(2);
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(tab));
	  waitforseconds(2);
	  driver.get(URL);
	  waitforseconds(5);
	 }

	
}//End of Ready To Use class
