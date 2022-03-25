package com.beginningselenium.selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class trainingbypackt {
	

	//public static void main(String[] args) throws InterruptedException {
		// Open and close the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krishna\\eclipse-workspace\\lesson1\\drivers\\chromedriver_win32\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
        driver.get("https://trainingbypackt.github.io/Beginning-Selenium/lesson_3/exercise_3_1.html");
        driver.manage().window().maximize();
        	
        Thread.sleep(2000);
        WebElement FN = driver.findElement(By.xpath("//input[@id='firstName']"));
        FN.sendKeys("Ashwini");
        
        WebElement LN = driver.findElement(By.xpath("//input[@id='lastName']"));
        LN.sendKeys("Kale");
        
        TimeUnit.SECONDS.sleep(3);
        
       Select DOB = new Select(driver.findElement(By.xpath("//select[@id='dayOfBirth']")));
       //DOB.getFirstSelectedOption().getText();
       DOB.selectByVisibleText("10");
       

        //Select DOB = new Select(driver.findElement(By.xpath("//select[@id='dayOfBirth']")));
		//DOB.getFirstSelectedOption().getText();
       
       Thread.sleep(2000);
       Select DOM = new Select(driver.findElement(By.xpath("//select[@id='monthOfBirth']")));
      // DOM.getFirstSelectedOption().getText();
       DOM.selectByIndex(10);
       
       Thread.sleep(2000);
       WebElement YOB = driver.findElement(By.xpath("//input[@id='yearOfBirth']"));
       YOB.sendKeys("1989");
       
       System.out.println("Date Of Birth -"+ "  "+DOB.getFirstSelectedOption().getText()+" "+DOM.getFirstSelectedOption().getText()+" "+YOB.getAttribute("value")+";");
       System.out.println("Full Name -"+"   "+ FN.getAttribute("value")+ LN.getAttribute("value"));
       
      
       Thread.sleep(2000);
       Select HB = new Select(driver.findElement(By.xpath("//select[@id='hobbies']")));
       HB.selectByVisibleText("Reading");
      
       Thread.sleep(2000);
       Select HB1 = new Select(driver.findElement(By.xpath("//select[@id='hobbies']")));
       HB1.selectByVisibleText("Traveling");
       
       Thread.sleep(2000);
       WebElement Deg = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/input[2]"));
       Deg.click();
       
       Thread.sleep(2000);
       WebElement Email = driver.findElement(By.xpath("//input[@id='emailUpdates']"));
       Email.click();
       
       Thread.sleep(2000);
       WebElement AboutYou= driver.findElement(By.xpath("//textarea[@id='aboutYourself']"));
       AboutYou.sendKeys("I like to learn new things.");
       
       Thread.sleep(2000);
       WebElement Submit = driver.findElement(By.xpath("//button[@id='submit']"));
       Submit.click();
       
      // Thread.sleep(3000);
       //System.out.println("Date Of Birth -"+ "  "+DOB.getFirstSelectedOption().getText()+" "+DOM.getFirstSelectedOption().getText()+" "+YOB.getAttribute("value")+";");
      // System.out.println("Full Name -"+"   "+ FN.getAttribute("value")+ LN.getAttribute("value"));
      
       TimeUnit.SECONDS.sleep(2);
  		driver.quit();
   }

	

}

