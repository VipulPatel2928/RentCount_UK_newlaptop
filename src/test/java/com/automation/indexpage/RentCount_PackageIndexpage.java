package com.automation.indexpage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.init.RentCount_AbstractPage;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
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
	//@FindBy(id="")private static WebElement yahoomail_password;
	
	public static RentCount_PackageVerification Yahoomail_login_details(){
		String fileName = "lib/LoginDetails.txt";
		ArrayList<String> data;
		data = funcs.ReadTextFile(fileName, 2);		
		String firsthandle = driver.getWindowHandle();
		funcs.senddata(driver,yahooemail_address, data.get(0));
		LogClass.log("---> Email Addess : " + data.get(0) + " <---");
		btn_next.click();	
		System.out.println("Click on the Next Button");
		funcs.waitforseconds(4);
		skip.click();
		System.out.println("I don't have access to this phone");
		funcs.waitforseconds(2);
		sendcode.click();
		System.out.println("Yes, please send me a verification code");
		funcs.waitforseconds(3);
		//move to gmail in new window
		funcs.switchToNewtabWithUrl(driver, "https://mail.google.com/mail/u/0/#inbox", 1);
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));		
		funcs.senddata(driver, username, "vipul.2928");
		System.out.println("Enter Gmail User name");
		WebElement btn_next = driver.findElement(By.xpath("//span[text()='Next']"));
		btn_next.click();
		System.out.println("Click on the gmail Next Button");
		funcs.waitforseconds(4);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		funcs.senddata(driver, password, "hetalmylove");
		System.out.println("Enter Gmail Password");
		WebElement btn_next_2 = driver.findElement(By.xpath("//span[text()='Next']"));
		btn_next_2.click();
		funcs.waitforseconds(10);
		emails.get(1).click();
		System.out.println("Open the email to get verification code");
		funcs.waitforseconds(6);
		String code = verifying_code.getText();
		System.out.println("Verification Code is :"+code);
		driver.switchTo().window(firsthandle);
		funcs.waitforseconds(5);	
		System.out.println("Move to the Yahoomail screen");
		funcs.senddata(driver, verification_code_text_field, code);
		System.out.println("Entere the verification code :"+code);
		btn_continue.click();
		System.out.println("Click on the continue button");
		funcs.waitforseconds(3);
		WebElement btn_continue_again = driver.findElement(By.xpath("//a[@class='pure-button puree-button-primary puree-spinner-button margin24 continue']"));
		btn_continue_again.click();
		funcs.waitforseconds(5);
		// TODO Auto-generated method stub
		return new RentCount_PackageVerification(driver);
	}

	@FindBy(xpath="//nav//ul//li//span//span[text()='DEMO SITES']")private static WebElement Demo_Sites;
	@FindBy(xpath="//nav//ul//li//ul//li//span[text()='Automation Practice Form']")private static WebElement Automation_practice_form;
	
	
	public static RentCount_PackageVerification navi_to_app_form() {
		// TODO Auto-generated method stub
		
		funcs.mouseHoverUsingJS(driver, Demo_Sites);
		System.out.println("Mouse Hover on Demo_sites_menu");
		LogClass.log("---> Mouse Hover on Demo_sites_menu <---");
		LogClass.logExtent("---> Mouse Hover on Demo_sites_menu <---");
		funcs.waitforseconds(4);
		funcs.jsClick(driver, Automation_practice_form);
		System.out.println("Click on the Automation practice form menu");
		LogClass.log("---> Click on the Automation practice form menu <---");
		LogClass.logExtent("---> Click on the Automation practice form menu <---");
		return new RentCount_PackageVerification(driver);
	}

	@FindBy(id="sex-0")private static WebElement male;
	@FindBy(id="sex-1")private static WebElement female;
    @FindBy(id="photo")private static WebElement choose_file;
	public static RentCount_PackageVerification filling_Details_into_app_form() {
		// TODO Auto-generated method stub
		funcs.scrollBy_vertical(driver, 600);
        male.click();
        String sex = funcs.getattributes_value(male);
        System.out.println("Sex :"+sex);
        LogClass.log("---> Click on the Radio button :" +sex +" <---");
        LogClass.logExtent("---> Click on the Radio button :" +sex +" <---");
        funcs.waitforseconds(2);
        female.click();
        sex = funcs.getattributes_value(female);
        System.out.println("Sex :"+sex);
        LogClass.log("---> Click on the Radio button :" +sex +" <---");
        LogClass.logExtent("---> Click on the Radio button :" +sex +" <---");    
        funcs.waitforseconds(3);
        funcs.scrollBy_vertical(driver, 600);
        String path = "Downloads/Cloud Hosting Agreement.pdf";
        funcs.uploadthefile(driver, choose_file, 5, path);
        System.out.println("File Uploaded :"+path);
        LogClass.log("---> File Uploaded :" +path+" <---");
        LogClass.logExtent("---> File Uploaded :" +path+" <---");
        funcs.waitforseconds(6);
        funcs.scrollBy_vertical(driver, -1600);
        funcs.waitforseconds(6);        
		return new RentCount_PackageVerification(driver);
	}

}
