package com.beginningselenium.selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.LoginPage;
import POM.PassengerDetails;
import POM.PayByCreditCard;
import POM.SelectFlightPage;

public class FirstPOMTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ExtentReport\\POMReports.html");
		ExtentReports report = new ExtentReports();
		// Set up report configuration
	    spark.config().setDocumentTitle("POM Test Reports");
		spark.config().setReportName("Selenium Automation");
		
		report.attachReporter(spark);
		
		// Add System Environment Variables
		report.setSystemInfo("QA Name", "Tester");
		report.setSystemInfo("Test Environement", "Development");

		ExtentTest  Test = report.createTest("POM Report");
		
		Thread.sleep(3000);
		// Open and close the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\drivers\\chromedriver_win32\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
        driver.get("http://travel.agileway.net/login");
        
        Test.info("http://travel.agileway.net/login");
        
        Thread.sleep(3000);
        
        //Use of POM
        
     // take screenshot
  		String LoginPage = "LoginPage";
  		String dateName1 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  		TakesScreenshot ts = (TakesScreenshot) driver;
  		File source = ts.getScreenshotAs(OutputType.FILE);
  		// after execution, you could see a folder "FailedTestsScreenshots" under src
  		// folder
  		String destination = "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ScreenShot\\" + LoginPage + dateName1 + ".png";
  		File finalDestination = new File(destination);
  		FileUtils.copyFile(source, finalDestination);

  		Test.info("1.Login Page Screen Shot");
  		Test.addScreenCaptureFromPath(destination);
       
        //1. LoginPage
     LoginPage objlogin;
     objlogin = new LoginPage(driver);
     objlogin.login();
     
  // take screenshot
  		String SelectFlightPage = "SelectFlightPage";
  		String dateName2 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  		TakesScreenshot ts2 = (TakesScreenshot) driver;
  		File source2 = ts2.getScreenshotAs(OutputType.FILE);
  		// after execution, you could see a folder "FailedTestsScreenshots" under src
  		// folder
  		String destination2 = "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ScreenShot\\" + SelectFlightPage + dateName2 + ".png";
  		File finalDestination2 = new File(destination2);
  		FileUtils.copyFile(source2, finalDestination2);

  		Test.addScreenCaptureFromPath(destination2);
     
     //2. SelectFlightPage
     SelectFlightPage objfly;  
     objfly = new SelectFlightPage(driver); 
     objfly.SelectFlight();
     
     //3. Set Passenger Details
     PassengerDetails objdetails;
     objdetails = new PassengerDetails(driver);
     objdetails.Details();
     
     //4. Pay By Credit Card 
     PayByCreditCard objcard;
     objcard = new PayByCreditCard(driver);
     objcard.CardDetails();
     
     Thread.sleep(5000);
     // take screenshot
		String screenshotName = "PayNow";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination1 = "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ScreenShot\\" + screenshotName + dateName + ".png";
		File finalDestination1 = new File(destination1);
		FileUtils.copyFile(source1, finalDestination1);

		Test.addScreenCaptureFromPath(destination1);

		Test.pass("<b><font color=green>"
				+ " Click the below link OR check the report folder by above screenshot Name to get the Screenshot of results "
				+ "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(destination1).build());

 
 Thread.sleep(3000);
 //test pass
 Test.pass("Test Passed");
 
 //flush the Report
 report.flush();
     
        
     TimeUnit.SECONDS.sleep(2);
     driver.quit();
   }
}