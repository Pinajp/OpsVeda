package com.TestExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.WebCommonMethods.InitialClass;
import com.WebPages.WPHome;
import com.WebPages.WPLogin;

public class HomePage extends Baseclass{
	//public WebDriver driver;
	InitialClass ic = new InitialClass();
	WPHome wphome;
	WPLogin wplogin;
	
	@Test(priority = 4)
	public void companylogoexists() throws InterruptedException {
		logger = report.createTest("Companylogo Exists");
		driver = ic.getbrowser("Chrome");
		//screen.getscreenshots(driver);
        /*wplogin = PageFactory.initElements(driver, WPLogin.class);
		wplogin.loginsuccess(driver);*/
		wphome = PageFactory.initElements(driver, WPHome.class);
		wphome.login(driver);
        logger.info("Companylogo Exists");
		wphome.Companylogoexist(driver);
		//screen.getscreenshots(driver);
		}
	
	@Test(priority = 5)
	
	public void menuclick() throws InterruptedException {
		logger = report.createTest("menuclick");
		wphome = PageFactory.initElements(driver, WPHome.class);
		Thread.sleep(1000);
		wphome.comapanymenuclickable();
		
	}
	
	@Test(priority = 6)
	public void DPbutton() {
		logger = report.createTest("Dp icon is clicked");
		wphome = PageFactory.initElements(driver, WPHome.class);
		wphome.profilelogout();
	}
	
	}


