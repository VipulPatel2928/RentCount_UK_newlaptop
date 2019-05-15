package com.automation.indexpage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.init.RentCount_AbstractPage;
import com.automation.utility.LogClass;
import com.automation.utility.ReadyToUse_Functions;
import com.automation.utility.RentCount_Common;
import com.automation.verification.RentCount_PackageVerification;

public class RentCount_PackageIndexpage extends RentCount_AbstractPage {

	public RentCount_PackageIndexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="login-username")private static WebElement yahooemail_address; 
	@FindBy(id="login-signin")private static WebElement btn_next;
	@FindBy(xpath="//input[@name='skip']")private static WebElement skip;
	@FindBy(xpath="//button[@name='sendCode']")private static WebElement sendcode;
	@FindBy(xpath="//span[contains(text(),'Your Yahoo verification code is')]")private static List<WebElement> emails;
	@FindBy(xpath="//div//p[text()='If so, use this code to finish signing in.']/..//p[3]//b//b")private static WebElement verifying_code;
	@FindBy(id="verification-code-field")private static WebElement verification_code_text_field;
	@FindBy(xpath="//button[@name='verifyCode']")private static WebElement btn_continue;
	
	@FindBy(id="")private static WebElement yahoomail_password;
	public static RentCount_PackageVerification Yahoomail_login_details() throws InterruptedException {
		String fileName = "lib/LoginDetails.txt";
		ArrayList<String> data;
		data = ReadyToUse_Functions.ReadTextFile(fileName, 2);		
		String firsthandle = driver.getWindowHandle();
		ReadyToUse_Functions.senddata(driver,yahooemail_address, data.get(0));
		LogClass.log("---> Email Addess : " + data.get(0) + " <---");
		btn_next.click();	
		System.out.println("Click on the Next Button");
		ReadyToUse_Functions.waitforseconds(4);
		skip.click();
		System.out.println("I don't have access to this phone");
		ReadyToUse_Functions.waitforseconds(2);
		sendcode.click();
		System.out.println("Yes, please send me a verification code");
		ReadyToUse_Functions.waitforseconds(3);
		//move to gmail in new window
		ReadyToUse_Functions.switchToNewtabWithUrl(driver, "https://mail.google.com/mail/u/0/#inbox", 1);
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));		
		ReadyToUse_Functions.senddata(driver, username, "vipul.2928");
		System.out.println("Enter Gmail User name");
		WebElement btn_next = driver.findElement(By.xpath("//span[text()='Next']"));
		btn_next.click();
		System.out.println("Click on the gmail Next Button");
		ReadyToUse_Functions.waitforseconds(4);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		ReadyToUse_Functions.senddata(driver, password, "hetalmylove");
		System.out.println("Enter Gmail Password");
		WebElement btn_next_2 = driver.findElement(By.xpath("//span[text()='Next']"));
		btn_next_2.click();
		ReadyToUse_Functions.waitforseconds(10);
		emails.get(1).click();
		System.out.println("Open the email to get verification code");
		ReadyToUse_Functions.waitforseconds(6);
		String code = verifying_code.getText();
		System.out.println("Verification Code is :"+code);
		driver.switchTo().window(firsthandle);
		ReadyToUse_Functions.waitforseconds(5);	
		System.out.println("Move to the Yahoomail screen");
		ReadyToUse_Functions.senddata(driver, verification_code_text_field, code);
		System.out.println("Entere the verification code :"+code);
		btn_continue.click();
		System.out.println("Click on the continue button");
		ReadyToUse_Functions.waitforseconds(3);
		WebElement btn_continue_again = driver.findElement(By.xpath("//a[@class='pure-button puree-button-primary puree-spinner-button margin24 continue']"));
		btn_continue_again.click();
		ReadyToUse_Functions.waitforseconds(5);
		
		// TODO Auto-generated method stub
		return new RentCount_PackageVerification(driver);
	}

}
