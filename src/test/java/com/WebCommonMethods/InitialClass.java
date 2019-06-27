package com.WebCommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestExecution.Baseclass;
import com.WebReusabilityMethods.TestDatareader;

public class InitialClass extends TestDatareader{
	public static WebDriver driver;
	
	public static  WebDriver getbrowser(String Browser) throws InterruptedException {
		if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pinaj\\Automation\\OpsVeda\\BrowserDriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 Thread.sleep(5000);
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver chromedriver=new ChromeDriver(capabilities);*/
			String URL = getstringcelldata("Credentials", 1, 0);
			driver.get(URL);
			System.out.println("Chrome broswer opened successfully");
		}
		else if(Browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pinaj\\Eclipse Project\\OpsVedaAutomation\\BrowserDriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://ovc.opsvedadev.opsveda.com:4302/OpsVeda_new/?");
			System.out.println("Firefox broswer opened successfully");
			
		}
		else if(Browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Pinaj\\Eclipse Project\\OpsVedaAutomation\\BrowserDriver\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get("https://ovc.opsvedadev.opsveda.com:4302/OpsVeda_new/?");
			System.out.println("IE broswer opened successfully");
		}
		
		else {
			System.out.println("Browser not loaded");
		}
		return driver;
	}

	public static void waitunitelement(WebDriver driver,WebElement element,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
}
