package com.TestExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.WebCommonMethods.InitialClass;
import com.WebPages.WPHome;
import com.WebPages.WPLogin;

public class HomePage extends Baseclass{
	public WebDriver driver;
	InitialClass ic = new InitialClass();
	//WPHome wphome;
	WPLogin wplogin;
	
	@Test
	public void companylogoexists() throws InterruptedException {
		logger = report.createTest("Companylogo Exists");
		driver = ic.getbrowser(driver, "Chrome");
		wplogin = PageFactory.initElements(driver, WPLogin.class);
		wplogin.loginsuccess(driver);
		logger.info("Companylogo Exists");
		wplogin = PageFactory.initElements(driver, WPLogin.class);
		wplogin.Companylogoexists(driver);
		//screen.getscreenshots(driver);
	}

}
