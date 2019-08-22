package com.TestExecution;

import java.io.IOException;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.WebCommonMethods.InitialClass;
import com.WebReusabilityMethods.Screenshotsonwebpages;
import com.WebReusabilityMethods.TestDatareader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass extends InitialClass {
	public static TestDatareader excel;
	public Screenshotsonwebpages screen;
	public ExtentHtmlReporter extent;
	public static ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void Firstexecution() {
		 excel = new TestDatareader();
		 //screen = new Screenshotsonwebpages();
		 ExtentHtmlReporter extent = new ExtentHtmlReporter("D:\\Automation\\OpsVeda\\Reports\\OpsVeda"+Screenshotsonwebpages.getsystemdatetime()+".HTML");
		 report = new ExtentReports();
		 report.attachReporter(extent);
	}
	
	@AfterMethod
	public void screenshotattachtoreport(ITestResult result) throws IOException {
		Reporter.log("Attach test cases status to HTML report");
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("success", MediaEntityBuilder.createScreenCaptureFromPath(Screenshotsonwebpages.getscreenshots()).build());
			Reporter.log("Attach all test cases screens with pass statements");
			
		}
		else if(result.getStatus()==ITestResult.FAILURE){
			logger.fail("Failure",MediaEntityBuilder.createScreenCaptureFromPath(Screenshotsonwebpages.getscreenshots()).build());
			logger.log(Status.FAIL, "Failure");
			Reporter.log("Attaching failure test cases screens to html report");
		}
		
		else {
			System.out.println("Screenshot are not attached");
		}
		report.flush();
		Reporter.log("HTML Report Generate",true);
	}

}
