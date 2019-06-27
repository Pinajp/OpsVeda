package com.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.TestExecution.Baseclass;
import com.WebCommonMethods.InitialClass;

public class WPLogin extends Baseclass{
	//public WebDriver driver;
	public InitialClass wait;
	
	
	@FindBy(xpath ="//input[@id='xs_username-inner']")WebElement usernamefield;
	@FindBy(xpath ="//input[@id = 'xs_password-inner']")WebElement passwordfield;
	@FindBy(xpath ="//div[@id = 'logon_button-inner']")WebElement loginbutton;
	@FindBy(xpath = "//a[@class='navbar-brand navbar-brand-fix']")WebElement companylogo;
	@FindBy(xpath= ".//*[@id='login_error']") WebElement wrongcredentialerror;

	
	
	public void loginwrongusername(WebDriver driver) throws InterruptedException {
		//this.driver = driver;
		String username = excel.getstringcelldata("Credentials", 2, 1);
		String passsword = excel.getstringcelldata("Credentials", 2, 2);
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(passsword);
		loginbutton.click();
		wait.waitunitelement(driver, wrongcredentialerror , 50);
		String wrongcredential = wrongcredentialerror.getText();
		System.out.println(wrongcredential);
		usernamefield.clear();
		passwordfield.clear();
		try {Assert.assertEquals(wrongcredential, "- Login failed : wrong credentials.");
		    System.out.println("Expected and actual result result is matched");
		}catch(Exception e) {
			
		}
		
		
	}
	
	public void loginwrongpassword(WebDriver driver)throws InterruptedException{
		//this.driver = driver;
		String username = excel.getstringcelldata("Credentials", 3, 1);
		String passsword = excel.getstringcelldata("Credentials", 3, 2);
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(passsword);
		loginbutton.click();
		//wait.waitunitelement(driver, wrongcredentialerror,60 );
		String wrongcredential = wrongcredentialerror.getText();
		System.out.println(wrongcredential);
		usernamefield.clear();
		passwordfield.clear();
		try {Assert.assertEquals(wrongcredential, "- Login failed : wrong credentials.");
		    System.out.println("Expected and actual result result is matched");
		}catch(Exception e) {
			System.out.println("Expected and actual result is not matched");
			
		}
	}
	
	
	public void loginsuccess(WebDriver driver) throws InterruptedException {
		//this.driver = driver;
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
		try {
			Assert.assertEquals("OpsVeda :: Operational Intelligence Suite", title);
			System.out.println("Expected and actual result result is matched");
		} catch (Exception e) {
			System.out.println("Expected and actual result is not matched");
			
		}
		
	}


	
	public void Companylogoexists(WebDriver driver) {
		//this.driver = driver;
		wait.waitunitelement(driver,companylogo , 50);
		boolean companylogovisible = companylogo.isDisplayed();
		System.out.println("company logo is present" + companylogovisible);

	}

	

}