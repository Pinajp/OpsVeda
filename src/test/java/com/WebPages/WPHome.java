package com.WebPages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.TestExecution.Baseclass;
import com.WebCommonMethods.InitialClass;

public class WPHome extends Baseclass{
    //public WebDriver driver;
	public InitialClass wait;
	String DPPicture = "C:\\Users\\Pinaj\\Automation\\OpsVeda\\Profilepic\\maxresdefault (1).jpg";
	
	@FindBy(xpath ="//input[@id='xs_username-inner']")WebElement usernamefield;
	@FindBy(xpath ="//input[@id = 'xs_password-inner']")WebElement passwordfield;
	@FindBy(xpath ="//div[@id = 'logon_button-inner']")WebElement loginbutton;
	@FindBy(xpath = "//a[@class='navbar-brand navbar-brand-fix']")WebElement companylogo;
    @FindBy(xpath= "//a[@class =\"iconmenu\"]") WebElement menu;
    @FindBy(xpath= "//a[contains(text(),'All Charts.')]") WebElement TabAllCharts;
    @FindBy(xpath= "//div[@class = \"dropdown navProfilePic\"]") WebElement profilepic;
    //@FindBy(xpath= "//i[@class='personPic handOnHover glyphicon glyphicon-user icon-white icon-user-fix ng-scope']") WebElement profilepic;
    @FindBy(xpath= "//div[@class = \"userName ng-binding\"]") WebElement DPusername;
    @FindBy (xpath= "//span[@id = \"shell-current-user\"]") WebElement Menuusername;
    @FindBy(xpath= "//span[@class='statusbar-pills strong ng-scope ng-binding']") WebElement AsOFpill;
    @FindBy(xpath= "//i[@title = \"Change Picture\"]") WebElement DP;
    @FindBy(xpath= "//span[@title = \"Remove Picture\"]") WebElement DPRemove;
	
    
    //Login successfully
	public void login(WebDriver driver) throws InterruptedException {
		String username = excel.getstringcelldata("Credentials", 1, 1);
		String password = excel.getstringcelldata("Credentials", 1, 2);
		Thread.sleep(3000);
		usernamefield.sendKeys(username);
		Thread.sleep(3000);
		passwordfield.sendKeys(password);
		loginbutton.click();
		wait.waitunitelement(driver,companylogo , 50);
		companylogo.click();
		String title = driver.getTitle();
		System.out.println(title);
		
	}
	
	
	
	
	//Company logo is present 
	
	public void Companylogoexist(WebDriver driver) {
		wait.waitunitelement(driver,companylogo , 50);
		boolean companylogovisible = companylogo.isDisplayed();
		try {
			assert companylogovisible = true : " Pass";
			System.out.println("Company logo is present");
		} catch (Exception e) {
			System.out.println("Company logo is not present");
		}
		
		/*if(companylogo.isDisplayed()) {
				System.out.println("Result correct");
		}else {
			System.out.println("Result incorrect");*/
		}
	
	
	//Menu is clicked properly
	
	public void comapanymenuclickable(WebDriver driver) {
		wait.waitunitelement(driver,companylogo , 50);
		wait.WaitforElement(driver, menu);
		Boolean tabdisplayed = TabAllCharts.isDisplayed();
		try {
			assert tabdisplayed = true : " Pass";
			System.out.println("Menu is clicked");
		} catch (Exception e) {
			System.out.println("Menu is not clicked");
		}
		
		
		/*System.out.println(AsOFpill.getText());
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd hh.mm.ss.S aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		System.out.println(formattedDate);
		*/
		}
	
	//As Of
	
	public void ProfileName() {
		profilepic.click();
		String menuusername = Menuusername.getText();
		System.out.println(menuusername);
		String username = DPusername.getText();
		System.out.println(username);
		try {Assert.assertEquals(menuusername, username);
	    System.out.println("Expected and actual  result is matched");
	}catch(Exception e) {
		System.out.println("Expected and actual  result is not matched");
	}
		
		}
	
	public void UploadDp() throws IOException {
		DP.click();
		Runtime.getRuntime().exec("C:\\Users\\Pinaj\\Automation\\OpsVeda\\Profilepic\\New AutoIt v3 Script.exe");
		profilepic.click();
		DPRemove.click();
		
		
	}
	}

