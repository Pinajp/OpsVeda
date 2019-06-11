package com.WebReusabilityMethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotsonwebpages {
	
	public static String getscreenshots(WebDriver driver) {
		TakesScreenshot tc = (TakesScreenshot)driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		String screenshotpath = "C:\\Users\\Pinaj\\Eclipse Project\\OpsVedaAutomation\\Screenshots\\" +getsystemdatetime()+".png";
		try {
			FileHandler.copy(source, new File(screenshotpath));
		} catch (IOException e) {
			System.out.println("Screenshot is not taken:" + e.getMessage());
		}
		return screenshotpath;
	}
	
	public static String getsystemdatetime() {
		DateFormat systemdatetime = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return systemdatetime.format(date);
	}

}
