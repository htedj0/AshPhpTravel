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
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class BrowserCheck {
	

	//public static void main(String[] args) throws InterruptedException, IOException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ExtentReport\\Reports.html");
		ExtentReports report = new ExtentReports();
		// Set up report configuration
	    spark.config().setDocumentTitle("Test Reports");
		spark.config().setReportName("Selenium Automation");
		
		report.attachReporter(spark);
		
		// Add System Environment Variables
		report.setSystemInfo("QA Name", "Tester");
		report.setSystemInfo("Test Environement", "Development");

		
		
		ExtentTest  Test = report.createTest("Lesson 3 Report");
		
		Thread.sleep(3000);
		// Open and close the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\drivers\\chromedriver_win32\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
        driver.get("https://trainingbypackt.github.io/Beginning-Selenium/lesson_3/exercise_3_1.html");
        
        Test.info("https://trainingbypackt.github.io/Beginning-Selenium/lesson_3/exercise_3_1.html");
        
     // take screenshot
     		String screenshotName = "screenshot1";
     		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
     		TakesScreenshot ts = (TakesScreenshot) driver;
     		File source = ts.getScreenshotAs(OutputType.FILE);
     		// after execution, you could see a folder "FailedTestsScreenshots" under src
     		// folder
     		String destination = "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\ScreenShot" + screenshotName + dateName + ".png";
     		File finalDestination = new File(destination);
     		FileUtils.copyFile(source, finalDestination);

     		Test.addScreenCaptureFromPath(destination);

        
        Thread.sleep(3000);
        //test pass
        Test.pass("Test Passed");
        
        //flush the Report
        report.flush();
        
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
       
      
  }
}

