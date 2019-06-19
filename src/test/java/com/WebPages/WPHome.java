package com.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TestExecution.Baseclass;
import com.WebCommonMethods.InitialClass;

public class WPHome extends Baseclass{
    public WebDriver driver;
	public InitialClass wait;
	
	@FindBy(xpath = "//a[@class='navbar-brand navbar-brand-fix']")WebElement companylogo;

	
	public void Companylogoexists(WebDriver driver) {
		this.driver = driver;
		wait.waitunitelement(driver,companylogo , 50);
		boolean companylogovisible = companylogo.isDisplayed();
		System.out.println("company logo is present" + companylogovisible);

	}

}
