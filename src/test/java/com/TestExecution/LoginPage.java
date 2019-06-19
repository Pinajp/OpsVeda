package com.TestExecution;

import java.sql.Driver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.WebCommonMethods.InitialClass;
import com.WebPages.WPHome;
import com.WebPages.WPLogin;

public class LoginPage extends Baseclass {
		InitialClass ic = new InitialClass();
		WPLogin wplogin;
		WPHome wphome;
		
		
		@Test(priority = 1, enabled = true)
		public void Wrongusername() throws InterruptedException {
			logger = report.createTest("WrongUserName");
			driver = ic.getbrowser(driver, "Chrome");
			logger.info("login with wrongusername");
			//screen.getscreenshots(driver);
			wplogin = PageFactory.initElements(driver, WPLogin.class);
			wplogin.loginwrongusername(driver);		
		}
		
		@Test(priority = 2,enabled = true)
		public void Wrongpassword() throws InterruptedException {
			logger = report.createTest("WrongUserName");
			//driver = ic.getbrowser(driver, "Chrome");
			logger.info("login with wrongpassword");
			//screen.getscreenshots(driver);
			wplogin = PageFactory.initElements(driver, WPLogin.class);
			wplogin.loginwrongpassword(driver);
			}
		
		
		
		@Test(priority = 3,enabled = true)
		public void StartExecution() throws InterruptedException {
			logger = report.createTest("OpsVeda Login");
			//driver = ic.getbrowser(driver,"Chrome");
			//screen.getscreenshots(driver);
			 wplogin = PageFactory.initElements(driver, WPLogin.class);
			 wplogin.loginsuccess(driver);
			 //screen.getscreenshots(driver);
			 driver.close();
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

