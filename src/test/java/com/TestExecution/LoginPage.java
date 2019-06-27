package com.TestExecution;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.WebCommonMethods.InitialClass;
import com.WebPages.WPHome;
import com.WebPages.WPLogin;

public class LoginPage extends Baseclass {
	//public WebDriver driver;
		InitialClass ic = new InitialClass();
		WPLogin wplogin;
		//WPHome wphome;
		
		
		
		@Test(priority = 1)
		public void Wrongusername() throws InterruptedException {
			logger = report.createTest("WrongUserName");
			driver = ic.getbrowser("Chrome");
			logger.info("login with wrongusername");
			//screen.getscreenshots(driver);
			wplogin = PageFactory.initElements(driver, WPLogin.class);
			wplogin.loginwrongusername(driver);		
		}
		
		@Test(priority = 2)
		public void Wrongpassword() throws InterruptedException {
			logger = report.createTest("WrongPassword");
			//driver = ic.getbrowser(driver, "Chrome");
			logger.info("login with wrongpassword");
			//screen.getscreenshots(driver);
			wplogin = PageFactory.initElements(driver, WPLogin.class);
			wplogin.loginwrongpassword(driver);
			}
		
		
		
		@Test(priority = 3)
		public void StartExecution() throws InterruptedException {
			logger = report.createTest("OpsVeda Login");
			//driver = ic.getbrowser(driver,"Chrome");
			//screen.getscreenshots(driver);
			logger.info("login with correct cred");
			 wplogin = PageFactory.initElements(driver, WPLogin.class);
			 wplogin.loginsuccess(driver);
			 //screen.getscreenshots(driver);
		
		} 
		
		
		
		/*@Test(priority=4)
		public void companylogoexists() {
			logger = report.createTest("Companylogo Exists");
			logger.info("Companylogo Exists");
			wphome = PageFactory.initElements(driver, WPHome.class);
			wphome.Companylogoexists(driver);
			screen.getscreenshots(driver);
			}*/

}

