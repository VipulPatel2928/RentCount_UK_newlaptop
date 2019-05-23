package com.automation.indexpage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.automation.init.RentCount_AbstractPage;
import com.automation.utility.LogClass;
import com.automation.utility.funcs;
import com.automation.verification.RentCount_PackageVerification;
import com.sun.corba.se.spi.orbutil.fsm.Action;

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
		return new RentCount_PackageVerification(driver);
	}

	@FindBy(xpath="//select[@id='continents']")private static WebElement continents_selection;

	public static RentCount_PackageVerification continets() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(2);
		funcs.selectFromComboByVisibleText(continents_selection, "Europe");
		funcs.waitforseconds(3);
		funcs.selectFromComboByIndex(continents_selection, 0);
		funcs.waitforseconds(3);		
		return new RentCount_PackageVerification(driver);
	}
	
	@FindBy(id="selenium_commands")private static WebElement commands;
	
	public static RentCount_PackageVerification commands() {
		// TODO Auto-generated method stub
		String command[] = {"Wait Commands","Navigation Commands","Wait Commands"};
		funcs.selectFromComboByVisibleText_multi(driver, commands, command);
		return new RentCount_PackageVerification(driver);
	}

	public static RentCount_PackageVerification navi_jqueryui() {
		// TODO Auto-generated method stub
		funcs.switchToNewtabWithUrl(driver, "http://jqueryui.com/", 1);
		return new RentCount_PackageVerification(driver);
	}
    
	@FindBy(xpath="//a[text()='Autocomplete']")private static WebElement autocomplete;
    @FindBy(xpath="//a[text()='Multiple values']")private static WebElement multiple_values;
    @FindBy(xpath="//iframe[@class=\"demo-frame\"]")private static WebElement iframe;
    @FindBy(xpath="//label[text()='Tag programming languages: ']//..//input")private static WebElement text_field_tag;
    @FindBy(xpath="//div[text()='JavaScript']")private static WebElement java_script;
    @FindBy(xpath="//div[text()='BASIC']")private static List<WebElement> basic;
    @FindBy(xpath="//div[text()='PHP']")private static List<WebElement> php;
    
    @FindBy(xpath="//a[text()='Scrollable results']")private static WebElement scrollable_result;
    @FindBy(id="tags")private static WebElement tags;
    
    @FindBy(xpath="//*[@id=\"ui-id-1\"]")private static WebElement scroll;
    @FindBy(xpath="//div[@class=\"ui-menu-item-wrapper\"]")private static List<WebElement> options;
	public static RentCount_PackageVerification autocomplete() {
		// TODO Auto-generated method stub
		funcs.waitforseconds(3);
		autocomplete.click();
		funcs.waitforseconds(3);
		multiple_values.click();
		System.out.println("---> Click on the multiple values <---");
		LogClass.log("---> Click on the multiple values <---");
		LogClass.logExtent("---> Click on the multiple values <---");
		driver.switchTo().frame(iframe);
		System.out.println("---> Switch to iframe <---");
		LogClass.log("---> Switch to iframe <---");
		LogClass.logExtent("---> Switch to iframe <---");
		text_field_tag.sendKeys("ja");
		funcs.waitforseconds(2);
		java_script.click();
		System.out.println("---> Select JavaScript <---");
		LogClass.log("---> Select JavaScript <---");
		LogClass.logExtent("---> Select JavaScript <---");
		text_field_tag.sendKeys("basic");
		funcs.waitforseconds(2);
		System.out.println("basic :"+basic.size());
		basic.get(basic.size()-1).click();
		System.out.println("---> Select Basic <---");
		LogClass.log("---> Select Basic <---");
		LogClass.logExtent("---> Select Basic <---");
		text_field_tag.sendKeys("php");
		System.out.println("php :"+php.size());
		funcs.waitforseconds(2);
		php.get(php.size()-1).click();
		System.out.println("---> Select PHP <---");
		LogClass.log("---> Select PHP <---");
		LogClass.logExtent("---> Select PHP <---");
		driver.switchTo().defaultContent();
		
		scrollable_result.click();
		driver.switchTo().frame(iframe);
		tags.sendKeys("a");
		funcs.waitforseconds(2);
		Actions act = new Actions(driver);
		act.moveToElement(scroll).build().perform();
		for(int i=0;i<options.size();i++) {
		act.moveToElement(options.get(i)).build().perform();
		funcs.waitforseconds(4);
		}
		return new RentCount_PackageVerification(driver);
	}
}
